package com.hayeejie.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzlegame
 * @date 2023/5/15 16:23
 */
public class Test2 extends JFrame implements ActionListener {
    //创建一个按钮对象
    JButton jbt1 = new JButton("点我啊");
    //创建一个按钮对象
    JButton jbt2 = new JButton("点我啊");
    public Test2(){
        //设置窗口大小
        this.setSize(603, 680);
        //设置窗口标题
        this.setTitle("拼图游戏单机版 V1.0");
        //设置窗口置顶
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口默认关闭操作
        this.setDefaultCloseOperation(3);
        //取消默认布局
        this.setLayout(null);

        //设置按钮的位置和宽高
        jbt1.setBounds(0,0,100,50);
        jbt1.addActionListener(this);

        //设置按钮的位置和宽高
        jbt2.setBounds(100,0,100,50);
        jbt2.addActionListener(this);

        //把按钮添加到整个界面中
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前按钮对象进行判断

        //获取当前被操作的按钮对象
        Object source = e.getSource();

        if (source == jbt1) {
            jbt1.setSize(200,200);
        } else if (source == jbt2) {
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
