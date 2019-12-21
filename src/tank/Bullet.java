package tank;

import java.awt.*;

/**
 * @Description:
 * @Author: JackYan
 * @Date2019/12/21 17:18
 * @Version V1.0
 **/
public class Bullet {

    private int x,y;

    private Direction dir;

    private static final int SPEED = 10;

    private static final int WIDTH = 5,HEIGHT = 5;

    public Bullet(int x,int y,Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        move();
    }

    private void move() {
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
