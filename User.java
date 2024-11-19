import java.io.*;

public class User {
    private String name, uname, password, email;
    private boolean isBuyer, isSeller, isAdmin;

    public User() {
        name = uname = password = email = "";
        isBuyer = isSeller = isAdmin = false;
    }

    public User(String name, String uname, String password, String email) {
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.email = email;
        isBuyer = true;
        isAdmin = isSeller = false;
    }

    public String getPassword() {return password;}

    public String getUname() {return uname;}

    public boolean validateUser(String uname, String password) {return (this.uname.equals(uname) && this.password.equals(password));}
}
