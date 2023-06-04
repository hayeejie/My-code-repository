/**
 * Hard learning
 *
 * @author hayeejie
 * @name StudentManageSystemDemo
 * @date 2023/4/27 21:02
 */
public class User {
    private String userName;
    private String password;
    private String personid;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String password, String personid, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.personid = personid;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
