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

    int x = 200,y = 200;

    public TankFrame(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setTitle("Tank War");
        this.setResizable(false);

        // 窗口监听
        // WindowAdapter 为 WindowListener的子类
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 键盘监听
        // 此处以内部类调用；也可按匿名内部类方式调用
        addKeyListener(new MyKeyListener());

    }

    // 重绘时（frame.repaint()）自动调用
    @Override
    public void paint(Graphics g) {
        // 绘制50*50的正方形
        g.fillRect(x,y,50,50);
    }

    // 处理键盘事件
    // 内部类：只有自己用到的类无需暴露在外部
    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                //virtual Key
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                //virtual Key
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
        }
    }

}

