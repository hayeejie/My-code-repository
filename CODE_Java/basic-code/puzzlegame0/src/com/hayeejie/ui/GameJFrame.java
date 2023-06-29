package com.hayeejie.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzle-game
 * @date 2023/5/13 15:33
 */
public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //创建一个二维数组
    int[][] data = new int[4][4];
    //定义空白图片在二维数组中的位置
    int x = 0;
    int y = 0;
    //定义一个变量，记录当前展示图片的路径
    String path = "image\\girl\\girl3\\";
    //定义一个二维数组，存储正确的数据
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //定义变量用来统计步数
    int step = 0;

    //创建选项下的几个条目对象
    //美女
    JMenuItem girl = new JMenuItem("美女");
    //动物
    JMenuItem animal = new JMenuItem("动物");
    //运动
    JMenuItem sport = new JMenuItem("运动");
    //重新游戏
    JMenuItem replayGame = new JMenuItem("重新游戏");
    //重新登录
    JMenuItem reLogin = new JMenuItem("重新登录");
    //关闭游戏
    JMenuItem closeGame = new JMenuItem("关闭游戏");

    //公众号
    JMenuItem wechat = new JMenuItem("公众号");

    public GameJFrame() {
        //初始化窗口
        initJFrame();

        //初始化菜单
        initMenu();

        //初始化数据（打乱）
        initData();

        //初始化图片（根据打乱后的数据打印图片）
        initImage();

        //让窗口显示出来，一般写在最后
        this.setVisible(true);
    }

    //初始化数据（打乱）
    private void initData() {
        //定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组数据中的数字
        //遍历数组得到每一个数据，拿着每一个元素跟随即索引上的数据进行交换
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随即索引
            int index = random.nextInt(tempArr.length);
            //拿着每一个元素跟随即索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //给二位数组添加数据
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    //添加图片
    //添加图片的时候，就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        //清空原本已经出现的图片
        this.getContentPane().removeAll();

        if (victory()) {
            //显示胜利图片
            JLabel winjLabel = new JLabel(new ImageIcon("image\\win.png"));
            //指定图片位置
            winjLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winjLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                //获取当前要加载添加图片的序号
                int number = data[j][i];
                //创建一个图片ImageIcon的对象
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));
                //指定图片位置
                jLabel.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面当中
        this.getContentPane().add(background);

        //刷新以下界面
        this.getContentPane().repaint();
    }

    private void initMenu() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上的两个选项的对象

        //功能
        JMenu functionjMenu = new JMenu("功能");
        //关于我们
        JMenu aboutjMenu = new JMenu("关于我们");

        //创建更换图片
        JMenu changeImage = new JMenu("更换图片");

        //把美女，动物，运动添加到更换图片当中
        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);

        //将几个选项添加到功能
        functionjMenu.add(changeImage);
        functionjMenu.add(replayGame);
        functionjMenu.add(reLogin);
        functionjMenu.add(closeGame);

        //将公众号添加到关于我们
        aboutjMenu.add(wechat);

        //给条目绑定事件
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        replayGame.addActionListener(this);
        reLogin.addActionListener(this);
        closeGame.addActionListener(this);
        wechat.addActionListener(this);

        //将组件添加到菜单
        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);

        //将菜单添加到窗口
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置窗口大小
        this.setSize(603, 680);
        //设置窗口标题
        this.setTitle("拼图游戏单机版 V1.0");
        //设置窗口置顶
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口默认关闭操作
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认布局
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //清空原本已经出现的图片
            this.getContentPane().removeAll();
            //创建一个图片ImageIcon的对象
            //创建一个JLabel的对象（管理容器）
            JLabel alljLabel = new JLabel(new ImageIcon(path + "all.jpg"));
            //指定图片位置
            alljLabel.setBounds(83, 134, 420, 420);
            //把图片添加到界面当中
            this.getContentPane().add(alljLabel);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            //把背景图片添加到界面当中
            this.getContentPane().add(background);

            //刷新以下界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (victory()) {
            return;
        }

        //对上，下，左，右进行判断
        //左37，上38，右39，下40
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 0) {
                //说明空白方块已经到边界了，直接结束方法
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 0) {
                //说明空白方块已经到边界了，直接结束方法
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 39) {
            if (y == 3) {
                //说明空白方块已经到边界了，直接结束方法
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 3) {
                //说明空白方块已经到边界了，直接结束方法
                return;
            }
            //把空白方块下方的数字往上移动
            //x，y 表示空白方块
            //x+1，y 表示空白方块下方的数字

            //把空白方块下面的数字赋值给空白方块
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            x = 3;
            y = 3;
            initImage();
        }
    }

    //判断data数组中的数据是否与win数组中相同
    //如果全部相同，返回true，否则返回false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    //有一个不一样，返回false
                    return false;
                }
            }
        }
        //循环完毕，说明全部相同
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();
        //获取当前被点击的条目对象
        Object obj = e.getSource();
        //判断
        if (obj == girl) {
            System.out.println("美女");
            int num = r.nextInt(13) + 1;
            path = "image\\girl\\girl" + num + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
        } else if (obj == animal) {
            System.out.println("动物");
            int num = r.nextInt(8) + 1;
            path = "image\\animal\\animal" + num + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
        } else if (obj == sport) {
            System.out.println("运动");
            int num = r.nextInt(10) + 1;
            path = "image\\sport\\sport" + num + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
        } else if (obj == replayGame) {
            System.out.println("重新游戏");
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
        } else if (obj == reLogin) {
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeGame) {
            System.out.println("关闭游戏");
            //直接关闭虚拟机即可
            System.exit(0);
        } else if (obj == wechat) {
            System.out.println("公众号");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(344, 344);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }
    }
}
