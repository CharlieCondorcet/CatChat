package cl.ucn.disc.dsm.charlie.p2pchat;

public class ChatUser {
    private final String Name;
    private final int Id;
    private final String Email;
    private final String Password;

    public ChatUser(String name, int id, String email, String password) {
        this.Name = name;
        this.Id = id;
        this.Email = email;
        this.Password = password;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}
