package tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 * @Author: yanwenjie
 * @Date2019/12/13 20:19
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();

        //50ms重绘一次
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint(); //调paint
        }
    }
}
