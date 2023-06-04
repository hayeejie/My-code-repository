package com.hayeejie.ui;

import com.hayeejie.domain.User;
import com.hayeejie.util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzleGame
 * @date 2023/5/13 15:36
 */
public class LoginJFrame extends JFrame implements MouseListener {

    //定义登录和注册按钮
    JButton login = new JButton();
    JButton register = new JButton();

    //验证码按钮
    JLabel rightCode = new JLabel();

    //用户名输入框
    JTextField username = new JTextField();

    //密码输入框
    JTextField password = new JTextField();

    //验证码输入框
    JTextField code = new JTextField();

    //创建一个集合存储正确的用户名和密码
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }


    public LoginJFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        //初始化的验证码
        String codeStr = CodeUtil.getCode();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加鼠标监听
        rightCode.addMouseListener(this);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }


    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //login & register
        //获取当前鼠标点击的是哪个按钮
        Object source = e.getSource();
        if (source == login) {
            System.out.println("登录按钮被按下了");
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            User userInfo = new User(usernameInput,passwordInput);

            if (codeInput.length() == 0) {
                showJDialog("验证码为空");
            } else if (!codeInput.equals(rightCode.getText())) {
                showJDialog("验证码错误，请重新输入");
                rightCode.setText(CodeUtil.getCode());
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("用户名和密码为空");
            } else if (contains(userInfo)) {
                showJDialog("登录成功");
                this.setVisible(false);
                new GameJFrame();
            } else {
                showJDialog("用户名密码不正确");
                rightCode.setText(CodeUtil.getCode());
            }
        } else if (source == register) {
            System.out.println("注册按钮被按下了");
        }else if (source == rightCode) {
            System.out.println("验证码按钮被按下了");
            rightCode.setText(CodeUtil.getCode());
        }
    }

    private boolean contains(User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User rightInfo = list.get(i);
            if (userInfo.getName().equals(rightInfo.getName()) && userInfo.getPassword().equals(rightInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //login & register
        //获取当前鼠标点击的是哪个按钮
        Object source = e.getSource();
        if (source == login) {
            login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        } else if (source == register) {
            register.setIcon(new ImageIcon("image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //login & register
        //获取当前鼠标点击的是哪个按钮
        Object source = e.getSource();
        if (source == login) {
            login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        } else if (source == register) {
            register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
