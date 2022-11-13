package com.example.tanks.Controller.StepControllers.TankControllers;

import com.example.tanks.Controller.StepControllers.BulletController;
import com.example.tanks.Controller.MapController;
import com.example.tanks.Controller.StepControllers.MyStepController;
import com.example.tanks.Controller.StepControllers.StepControllerContainer;
import com.example.tanks.Controller.StepControllers.TankControllers.Utils.TankControllerContainer;
import com.example.tanks.Model.BulletControllerConstructor;
import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Tank;
import com.example.tanks.Settings;
import com.example.tanks.Utils.IntersectionService;

import java.util.Timer;
import java.util.TimerTask;

public abstract class TankController implements MyStepController{
    protected MapController mapController;
    protected Tank tank;
//    protected List<TankController> tankList;

    private Timer timer;
    private boolean canFire;

    public TankController(MapController mapController, Tank tank) {
        this.mapController = mapController;
        this.tank = tank;
//        this.tankList = tankList;

        this.canFire = true;
        timer = new Timer();
    }

    public void die(){
        mapController.removeNode(tank.getTankPane());
        StepControllerContainer.getInstance().remove(this);
        TankControllerContainer.getInstance().remove(this);
//        tankList.remove(this);
    }

    protected void tryToFire(){
        if (!canFire)
            return;
        Direction dir = tank.getCurrDirection();

        BulletController bulletController = BulletControllerConstructor.createBulletController(
                dir,
                tank.getPosX()+0.5*tank.getTankWidth(),tank.getPosY()+0.5*tank.getTankHeight(),
                tank.getTeam(),tank.getDamage(), Settings.DEF_BULLET_SPEED,mapController
        );

        StepControllerContainer.getInstance().add(bulletController);

        canFire = false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                canFire = true;
            }
        },tank.getFireCooldown());

    }

    public Tank getTank() {
        return tank;
    }

    public void toHurt(double damage){
        double newH = tank.getHealth() - damage;
        if (newH < 0)
            die();
        else
            tank.setHealth(newH);
    }

    protected Direction getDirectionOfEnemy(){
        double xC = tank.getPosX()+tank.getTankWidth()/2;
        double yC = tank.getPosY()+tank.getTankHeight()/2;

        int blockX = (int) (xC/ Settings.BLOCK_WIDTH);
        int blockY = (int) (yC/ Settings.BLOCK_HEIGHT);

        BlockType[][] field = mapController.getGameMap().field;

        double rightBorder = xC;
        //to the right
        for (int i = blockX; i < mapController.getGameMap().countBlocksWidth; i++)
            if(!BlockType.isVisible(field[blockY][i])) {
                rightBorder = i * Settings.BLOCK_WIDTH;
                break;
            }

        double leftBorder = xC;
        //to the left
        for (int i = blockX; i >= 0; i--)
            if(!BlockType.isVisible(field[blockY][i])) {
                leftBorder = (i + 1) * Settings.BLOCK_WIDTH;
                break;
            }

        double botBorder = yC;

        //to the bottom
        for (int i = blockY; i < mapController.getGameMap().countBlocksHeight; i++)
            if(!BlockType.isVisible(field[i][blockX])) {
                botBorder = i * Settings.BLOCK_HEIGHT;
                break;
            }

        double topBorder = yC;
        //to the top
        for (int i = blockY; i >= 0; i--)
            if(!BlockType.isVisible(field[i][blockX])) {
                topBorder = (i + 1) * Settings.BLOCK_HEIGHT;
                break;
            }

        for (TankController tankController : TankControllerContainer.getInstance().getControllers()){
            if (tankController==this || tankController.getTank().getTeam().equals(tank.getTeam()))
                continue;
            Tank tank = tankController.getTank();
            double tankX = tank.getPosX();
            double tankY = tank.getPosY();
            double tankWidth = tank.getTankWidth();
            double tankHeight = tank.getTankHeight();

            if (tankX <= xC && tankX+tankWidth >= xC ) {
                if (tankY + tankHeight > topBorder && tankY + tankHeight < yC)
                    return Direction.Up;
                if (tankY < botBorder && tankY + tankHeight > yC)
                    return Direction.Down;
            }
            if (tankY<= yC && tankY+tankHeight >= yC){
                if (tankX< rightBorder && tankX+tankWidth > xC)
                    return Direction.Right;
                if (tankX+tankWidth > leftBorder && tankX < xC)
                    return Direction.Left;
            }
        }
        return null;
    }

    public boolean moveTankInItsDir(){
        Direction direction = tank.getCurrDirection();
        double speed = tank.getSpeed();

        BlockType[][] field = mapController.getGameMap().field;
        double newX = tank.getPosX();
        double newY= tank.getPosY();

        switch (direction){
            case Up:
                newY-=speed;
                break;
            case Down:
                newY+=speed;
                break;
            case Right:
                newX+=speed;
                break;
            case Left:
                newX-=speed;
                break;
        }

        int mapWid = mapController.getGameMap().countBlocksWidth;
        int mapHei = mapController.getGameMap().countBlocksHeight;
        int lx = (int) (newX/ Settings.BLOCK_WIDTH);
            lx = Math.min(mapWid-1,lx);
        int rx = (int) ((newX + tank.getTankWidth())/Settings.BLOCK_WIDTH);
            rx = Math.min(mapWid-1,rx);

        int ty = (int) (newY/Settings.BLOCK_HEIGHT);
            ty = Math.min(ty,mapHei-1);
        int by = (int) ((newY+tank.getTankHeight())/Settings.BLOCK_HEIGHT);
            by = Math.min(by,mapHei-1);
        if (BlockType.isObstacle(field[ty][lx]) ||
                BlockType.isObstacle(field[ty][rx]) ||
                BlockType.isObstacle(field[by][lx]) ||
                BlockType.isObstacle(field[by][rx]))
            return false;

        for (TankController tankController : TankControllerContainer.getInstance().getControllers()){
            if (tankController == this)
                continue;
            Tank currTank = tankController.getTank();
            if (IntersectionService.hasIntersection(
                    currTank.getPosX(),currTank.getPosY(),
                    currTank.getTankWidth(),currTank.getTankHeight(),
                    newX,newY,tank.getTankWidth(),tank.getTankHeight()
            ))
                return false;
        }

        tank.setPosX(newX);
        tank.setPosY(newY);
        return true;
    }
}
