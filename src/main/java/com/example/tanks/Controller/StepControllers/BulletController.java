package com.example.tanks.Controller.StepControllers;

import com.example.tanks.Controller.MapController;
import com.example.tanks.Controller.StepControllers.TankControllers.TankController;
import com.example.tanks.Controller.StepControllers.TankControllers.Utils.TankControllerContainer;
import com.example.tanks.Model.Bullet;
import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Tank;
import com.example.tanks.Settings;
import com.example.tanks.Utils.IntersectionService;

public class BulletController implements MyStepController {
    public Bullet bullet;
    public MapController mapController;
//    public List<TankController> tanks;

    private final double intersectionWithTankBeforeDie = 10;

    public BulletController(Bullet bullet, MapController mapController) {
        this.bullet = bullet;
        this.mapController = mapController;
//        this.tanks = tanks;
    }

    @Override
    public void nextStep() {
        if ( move()){
            checkTanks();
        }
    }

    private void die(){
        mapController.removeNode(bullet.getBulletPane());
        StepControllerContainer.getInstance().remove(this);
    }

    private void checkTanks(){
        for(TankController tankController : TankControllerContainer.getInstance().getControllers()){
            Tank tank = tankController.getTank();
            if (!tank.getTeam().equals(bullet.getTeam())) {
                Direction direction = bullet.getDirection();
                double tankX = tank.getPosX() ;
                double tankY = tank.getPosY() ;
                double tankWidth = tank.getTankWidth() ;
                double tankHeight = tank.getTankHeight() ;
                if (direction == Direction.Up || direction == Direction.Down  ){
                    tankY+=intersectionWithTankBeforeDie;
                    tankHeight-=2*intersectionWithTankBeforeDie;
                }else if(direction == Direction.Left || direction == Direction.Right  ){
                    tankX+=intersectionWithTankBeforeDie;
                    tankWidth-=2*intersectionWithTankBeforeDie;
                }


                if (IntersectionService.hasIntersection(
                        tankX,tankY,tankWidth,tankHeight,
                        bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight()
                )) {
                    tankController.toHurt(bullet.getDamage());
                    die();
                }
            }

        }
    }
    private boolean move(){
        Direction direction = bullet.getDirection();
        double speed = bullet.getSpeed();

        BlockType[][] field = mapController.getGameMap().field;
        double newX = bullet.getX();
        double newY= bullet.getY();

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

        int lx = (int) (newX/ Settings.BLOCK_WIDTH);
        int rx = (int) ((newX + bullet.getWidth())/ Settings.BLOCK_WIDTH);

        int ty = (int) (newY/Settings.BLOCK_HEIGHT);
        int by = (int) ((newY+bullet.getHeight())/Settings.BLOCK_HEIGHT);

        if (BlockType.isObstacle(field[ty][lx]) ||
                BlockType.isObstacle(field[ty][rx]) ||
                BlockType.isObstacle(field[by][lx]) ||
                BlockType.isObstacle(field[by][rx])) {
            die();
            return false;
        }



        bullet.setX(newX);
        bullet.setY(newY);
        return true;
    }
}
