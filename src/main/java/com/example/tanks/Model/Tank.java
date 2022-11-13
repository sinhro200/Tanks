package com.example.tanks.Model;


import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Enums.Team;
import com.example.tanks.Panes.TankPane;
import com.example.tanks.Settings;

public class Tank {
    private TankPane tankPane;

    private double speed;
    private double health;
    private double damage;
    private long fireCooldown;
    private Direction currDirection;
    private Team team;

    public Tank(TankPane tankPane, double speed, double health, double damage,long fireCooldown, Team team) {
        this.tankPane = tankPane;
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.fireCooldown =fireCooldown;
        this.team = team;
    }

    public Tank(TankPane tankPane) {
        this(tankPane, Settings.DEF_TANK_SPEED,Settings.DEF_TANK_HEALTH,
                Settings.DEF_TANK_DAMAGE,Settings.DEF_TANK_FIRE_COOLDOWN, Team.neutral);
    }

    public Tank(TankPane tankPane, Team team) {
        this(tankPane, Settings.DEF_TANK_SPEED,Settings.DEF_TANK_HEALTH,
                Settings.DEF_TANK_DAMAGE,Settings.DEF_TANK_FIRE_COOLDOWN, team);
    }

    public void rotate(Direction direction){
        tankPane.setDirection(direction);
        this.currDirection = direction;
    }

    public void setPosXCenter(double xCenter){
        tankPane.setTranslateX(xCenter- getTankWidth()/2);
    }

    public void setPosYCenter(double yCenter){
        tankPane.setTranslateX(yCenter- getTankHeight()/2);
    }

    public void setHealth(double health){
        this.health = health;
    }

    public Team getTeam() {
        return team;
    }

    public double getTankWidth() {
        return tankPane.getTankWidth();
    }

    public double getTankHeight() {
        return tankPane.getTankHeight();
    }

    public double getPosX() {
        return tankPane.getPosX();
    }

    public double getPosY() {
        return tankPane.getPosY();
    }

    public void setPosX(double x) {
        tankPane.setTranslateX(x);
    }

    public void setPosY(double y) {
        tankPane.setTranslateY(y);
    }

    public Direction getCurrDirection() {
        return this.currDirection;
    }

    public TankPane getTankPane() {
        return tankPane;
    }

    public double getSpeed() {
        return speed;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public long getFireCooldown() {
        return fireCooldown;
    }
}
