package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 *  从Frame继承来显示
 * @Date2019/12/13 20:34
 * @Version V1.0
 **/
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200, Direction.DOWN);

    public TankFrame(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setTitle("Tank War");
        this.setResizable(false);

        /** 窗口监听
            WindowAdapter 为 WindowListener的子类 **/
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /** 键盘监听
            此处以内部类调用；也可按匿名内部类方式调用 **/
        addKeyListener(new MyKeyListener());

    }

    /** 重绘时（frame.repaint()）自动调用 **/
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    /** 处理键盘事件
        内部类：只有自己用到的类无需暴露在外部 **/
    class MyKeyListener extends KeyAdapter {
        boolean boolLeft = false;
        boolean boolRight = false;
        boolean boolUp = false;
        boolean boolDown = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                //virtual Key
                case KeyEvent.VK_LEFT:
                    boolLeft = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    boolRight = true;
                    break;
                case KeyEvent.VK_UP:
                    boolUp = true;
                    break;
                case KeyEvent.VK_DOWN:
                    boolDown = true;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                //virtual Key
                case KeyEvent.VK_LEFT:
                    boolLeft = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    boolRight = false;
                    break;
                case KeyEvent.VK_UP:
                    boolUp = false;
                    break;
                case KeyEvent.VK_DOWN:
                    boolDown = false;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        /** 设置坦克方向:可能两个键一起摁到，故不用elseif **/
        void setTankDir(){
            if(!boolLeft && !boolUp && !boolRight && !boolDown){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(boolLeft){
                    myTank.setDir(Direction.LEFT);
                }
                if(boolUp){
                    myTank.setDir(Direction.UP);
                }
                if(boolRight){
                    myTank.setDir(Direction.RIGHT);
                }
                if(boolDown){
                    myTank.setDir(Direction.DOWN);
                }
            }
        }

    }

}

