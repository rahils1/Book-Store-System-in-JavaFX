import java.io.*;

public class User implements Externalizable {
    private String fname, lname, uname, password, email;
    private int userID;
    private boolean isBuyer, isSeller, isAdmin;

    public User() {
        fname = lname = uname = password = email = "";
        userID = -1;
        isBuyer = isSeller = isAdmin = false;
    }

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

    public boolean validateUser(String uname, String password) {return (this.uname.equals(uname) && this.password.equals(password));}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(fname);    // Serialize fname
        out.writeObject(lname);    // Serialize lname
        out.writeObject(uname);    // Serialize uname
        out.writeObject(password); // Serialize password
        out.writeObject(email);    // Serialize email
        out.writeInt(userID);      // Serialize userID
        out.writeBoolean(isBuyer); // Serialize isBuyer
        out.writeBoolean(isSeller);// Serialize isSeller
        out.writeBoolean(isAdmin); // Serialize isAdmin
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fname = (String) in.readObject();   // Deserialize fname
        lname = (String) in.readObject();   // Deserialize lname
        uname = (String) in.readObject();   // Deserialize uname
        password = (String) in.readObject();// Deserialize password
        email = (String) in.readObject();   // Deserialize email
        userID = in.readInt();              // Deserialize userID
        isBuyer = in.readBoolean();         // Deserialize isBuyer
        isSeller = in.readBoolean();        // Deserialize isSeller
        isAdmin = in.readBoolean();         // Deserialize isAdmin
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userID=" + userID +
                ", isBuyer=" + isBuyer +
                ", isSeller=" + isSeller +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public void Serialize() {
        String file = uname + ".ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            this.writeExternal(out);
        } catch (IOException e) {}
    }
}
