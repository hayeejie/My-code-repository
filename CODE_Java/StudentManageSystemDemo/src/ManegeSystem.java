import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/25 21:11
 */
public class ManegeSystem {
    public static void main(String[] args) {
        meau();
        Scanner input = new Scanner(System.in);

        while (true) {
            switch (input.nextInt()) {
                case 1:
                    System.out.println("添加学生");
                    break;
                case 2:
                    System.out.println("删除学生");
                    break;
                case 3:
                    System.out.println("修改学生");
                    break;
                case 4:
                    System.out.println("查询学生");
                    break;
                case 5:
                    System.out.println("退出");
                    System.exit(0);
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }
    public static void meau() {
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入你的选择：");
    }
}
