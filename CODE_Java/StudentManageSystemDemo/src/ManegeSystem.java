import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/25 21:11
 */
public class ManegeSystem {
    public void startManegeSystem() {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            menu();
            String i = input.next();
            switch (i) {
                case "1" -> addStudent(array);
                case "2" -> deleteStudent(array);
                case "3" -> changeStudent(array);
                case "4" -> findStudent(array);
                case "5" -> {
                    System.out.println("退出");
                    return;
                }
                default -> System.out.println("输入错误");
            }
        }
    }
    public static void menu() {
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入你的选择：");
    }
    public static void addStudent(ArrayList<Student> array) {
        Student student = new Student();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号：");
        String id = input.nextLine();
        //判断id唯一性
        for (Student value : array) {
            if (value.getId().equals(id)) {
                System.out.println("该学生已存在，请重试");
                return;
            }
        }
        //添加学生对象
        student.setId(id);

        System.out.println("请输入姓名：");
        String name = input.nextLine();
        student.setName(name);

        System.out.println("请输入年龄：");
        String age = input.nextLine();
        student.setAge(age);

        System.out.println("请输入家庭住址：");
        String homeAddress = input.nextLine();
        student.setHomeaddress(homeAddress);

        array.add(student);
        System.out.println("学生信息添加成功");
    }
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号：");
        String id = input.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getId().equals(id)) {
                array.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("学生不存在");
    }
    public static void changeStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要修改的学生学号：");
        String id = input.nextLine();
        for (Student student : array) {
            if (student.getId().equals(id)) {
                System.out.println("请输入新的学生姓名：");
                String name = input.nextLine();
                student.setName(name);
                System.out.println("请输入新的学生年龄：");
                String age = input.nextLine();
                student.setAge(age);
                System.out.println("请输入新的学生家庭住址：");
                String homeAddress = input.nextLine();
                student.setHomeaddress(homeAddress);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("学生不存在");
    }
    public static void findStudent(ArrayList<Student> array) {
        if (!array.isEmpty()) {
            System.out.println("id\t\t\t姓名\t\t年龄\t\t家庭住址");
            for (Student student : array) {
                System.out.println("" + student.getId() + "\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getHomeaddress());
            }
            return;
        }
        System.out.println("无学生信息，请添加后再查询");
    }
}
