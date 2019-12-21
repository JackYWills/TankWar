package tank;

import java.awt.*;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/21 16:36
 * @Version V1.0
 **/
public class Tank {

    /** tank's coordinate at the screen **/
    private int x = 200,y = 200;

    private final int SPEED = 5;

    private Direction dir = Direction.DOWN;

    private boolean moving = false;

    public Tank(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /** 绘制tank自身：50*50的正方形 **/
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        move();
    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
    }
}
