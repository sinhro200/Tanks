package com.example.tanks.Model;


import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Enums.Team;
import com.example.tanks.Panes.BulletPane;
import com.example.tanks.Settings;

public class Bullet {
    private BulletPane bulletPane;
    private double speed;
    private double damage;
    private Direction direction;
    private Team team;

    public Bullet(BulletPane bulletPane,Direction direction,double damage,Team team,double speed) {
        this.bulletPane = bulletPane;
        this.speed = speed;
        this.damage = damage;
        this.direction = direction;
        this.team = team;
    }

    public Bullet(BulletPane bulletPane, Direction direction,double damage,Team team) {
        this(bulletPane,direction,damage,team, Settings.DEF_BULLET_SPEED);
    }

    public Bullet(BulletPane bulletPane, Direction direction,double damage) {
        this(bulletPane,direction,damage,Team.neutral);
    }

    public void setX(double x){
        bulletPane.setTranslateX(x);
    }

    public void setY(double y){
        bulletPane.setTranslateY(y);
    }

    public BulletPane getBulletPane() {
        return bulletPane;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDamage() {
        return damage;
    }

    public Direction getDirection() {
        return direction;
    }

    public double getX(){
        return bulletPane.getTranslateX();
    }

    public double getY(){
        return bulletPane.getTranslateY();
    }

    public double getWidth(){
        return bulletPane.getWidth();
    }

    public double getHeight(){
        return bulletPane.getHeight();
    }

    public Team getTeam() {
        return team;
    }
}
