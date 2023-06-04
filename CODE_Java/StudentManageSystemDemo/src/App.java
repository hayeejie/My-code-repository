import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name StudentManageSystemDemo
 * @date 2023/4/27 21:33
 */
public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码 4退出");
            Scanner input = new Scanner(System.in);
            String choose = input.next();
            switch (choose){
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("退出");
                    return;
                }
                default -> System.out.println("选项不存在");
            }
        }
    }

    private static void forgetPassword(ArrayList<User> arrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        boolean flag = contains(arrayList,name);
        if (!flag) {
            System.out.println("用户未注册");
            return;
        }
        int index = getIndex(arrayList,name);
        System.out.println("请输入身份证号：");
        String idCard = scanner.next();
        System.out.println("请输入手机号：");
        String phone = scanner.next();
        if (idCard.equals(arrayList.get(index).getPersonid()) && phone.equals(arrayList.get(index).getPhoneNumber())) {
            System.out.println("请输入新密码：");
            String password = scanner.next();
            arrayList.get(index).setPassword(password);
            System.out.println("修改成功");
        }else {
            System.out.println("账号信息不匹配，修改失败");
        }
    }

    private static void register(ArrayList<User> arrayList) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        while (true) {
            String name = scanner.next();
            boolean flag = contains(arrayList,name);
            if (flag) {
                System.out.println("用户名已存在，请重新输入：");
                continue;
            }
            if (name.length() < 6 || name.length() > 14) {
                System.out.println("用户名长度不符合要求，请重新输入：");
                continue;
            }
            //只能是字母加数字的组合，但是不能是纯数字
            if (name.matches("[a-zA-Z0-9]+") && !name.matches("[0-9]+")) {
                user.setUserName(name);
                break;
            } else {
                System.out.println("用户名格式不符合要求，请重新输入：");
            }
        }
        System.out.println("请输入密码：");
        while (true) {
            String password = scanner.next();
            System.out.println("请再次输入密码");
            String password2 = scanner.next();
            if (password.equals(password2)) {
                user.setPassword(password);
                break;
            }else {
                System.out.println("两次密码不一致，请重新输入：");
            }
        }
        System.out.println("请输入身份证号：");
        while (true) {
            String idCard = scanner.next();
            if (idCard.length() != 18) {
                System.out.println("身份证号长度不符合要求，请重新输入：");
                continue;
            }
            if(idCard.charAt(0) == '0') {
                System.out.println("身份证号不能以0开头，请重新输入：");
                continue;
            }
            if (idCard.matches("[0-9]{17}[0-9Xx]")) {
                user.setPersonid(idCard);
                break;
            } else {
                System.out.println("身份证号格式不符合要求，请重新输入：");
            }
        }
        System.out.println("请输入手机号：");
        while (true) {
            String phone = scanner.next();
            if (phone.length() != 11) {
                System.out.println("手机号长度不符合要求，请重新输入：");
                continue;
            }
            if(phone.charAt(0) == '0') {
                System.out.println("手机号不能以0开头，请重新输入：");
                continue;
            }
            if (phone.matches("[1-9][0-9]{10}")) {
                user.setPhoneNumber(phone);
                break;
            } else {
                System.out.println("手机号格式不符合要求，请重新输入：");
            }
        }
        arrayList.add(user);
        System.out.println("注册成功");
    }

    private static void login(ArrayList<User> arrayList) {
        ManegeSystem manegeSystem = new ManegeSystem();
        Scanner scanner = new Scanner(System.in);
        for (int i = 3 ; i > 0 ; i--) {
            System.out.println("请输入用户名：");
            String name = scanner.next();
            boolean flag = contains(arrayList, name);
            if (!flag) {
                System.out.println("用户名未注册，请先注册");
                return;
            }
            int index = getIndex(arrayList, name);
            System.out.println("请输入密码：");
            String password = scanner.next();
            while (true) {
                //生成验证码
                String code = getCode();
                System.out.println("验证码为：" + code);
                System.out.println("请输入验证码：");
                String inputCode = scanner.next();
                if (inputCode.equals(code)) {
                    break;
                } else {
                    System.out.println("验证码错误，请重新输入");
                }
            }
            if (name.equals(arrayList.get(index).getUserName()) && password.equals(arrayList.get(index).getPassword())) {
                System.out.println("登录成功");
                manegeSystem.startManegeSystem();
                break;
            }else if (i == 1){
                System.out.println("已连续三次输入账号密码错误，账号已锁定，请联系管理员");
                break;
            }else {
                System.out.println("用户名或密码错误，您还有"+ (i-1) +"次机会，请重新输入");
            }
        }
    }

    private static boolean contains(ArrayList<User> arrayList,String username) {
        return getIndex(arrayList,username) >= 0;
    }

    private static int getIndex(ArrayList<User> arrayList,String username) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUserName().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    private static String getCode() {
        char[] chs = new char[52];
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < chs.length; i++) {
            //ASCII码表
            if(i <= 25){
                //添加小写字母
                chs[i] = (char)(97 + i);
            }else{//27
                //添加大写字母
                chs[i] = (char)(65 + i - 26);
            }
        }
        for (int i = 0; i < 4; i++) {
            sb.append(chs[r.nextInt(chs.length)]);
        }
        sb.append(nums[r.nextInt(nums.length)]);
        String code = sb.toString();
        // 将字符串转换为 char 数组
        char[] c = code.toCharArray();

        // 循环随机打乱数组中的元素
        for (int i = 0; i < c.length; i++) {
            int index = r.nextInt(c.length);
            char temp = c[i];
            c[i] = c[index];
            c[index] = temp;
        }
        code = new String(c);
        return code;
    }

}
