import java.util.Scanner;

//练习键盘输入
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int num = sc.nextInt();
        System.out.println(num);
        System.out.println("helloword");
        //输入两个数并且输出他们之间的和
        System.out.println("请输入两个数：");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = num1+num2;
        System.out.println("他们之和为："+sum);
    }
}
