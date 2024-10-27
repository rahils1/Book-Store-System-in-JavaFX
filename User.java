public class User {
    private String fname, lname, uname, password, email;
    private int userID;
    private boolean isBuyer, isSeller, isAdmin;

    public User(String fname, String lname, String uname, String password, String email, int userID) {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.userID = userID;
        isBuyer = true;
        isAdmin = isSeller = false;
    }

    public String getPassword() {return password;}

    public String getUname() {return uname;}

    public boolean validateUser(String uname, String password) {
        return (this.uname.equals(uname) && this.password.equals(password));
    }
}
