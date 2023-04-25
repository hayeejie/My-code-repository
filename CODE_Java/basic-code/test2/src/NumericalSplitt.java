import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/3 23:21
 */
public class NumericalSplitt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int num = sc.nextInt();

        //对数字进行拆解
        //个位
        System.out.println(num % 10);

        //十位
        System.out.println(num / 10 % 10);

        //百位
        System.out.println(num / 100 % 10);

    }
}
