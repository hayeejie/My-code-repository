/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/25 21:04
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private String homeaddress;

    public Student() {
    }

    public Student(String id, String name, int age, String homeaddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.homeaddress = homeaddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }
}
