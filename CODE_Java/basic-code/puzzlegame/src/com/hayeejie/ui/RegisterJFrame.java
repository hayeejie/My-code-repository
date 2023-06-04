package com.hayeejie.ui;

import javax.swing.*;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzlegame
 * @date 2023/5/13 15:37
 */
public class RegisterJFrame extends JFrame {
    public RegisterJFrame() {
        //设置窗口大小
        this.setSize(488, 500);
        //设置窗口标题
        this.setTitle("拼图游戏注册界面 V1.0");
        //设置窗口置顶
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口默认关闭操作
        this.setDefaultCloseOperation(3);
        //让窗口显示出来，一般写在最后
        this.setVisible(true);
    }
}
