package at.technikum.model;

public class User
{
    private int id;
    private String username;
    private String password;

    // Konstruktoren (dasselbe Muster wie bei MediaEntry, mit und ohne id)
    public User(int id, String password, String username)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String password, String username)
    {
        this.username = username;
        this.password = password;
    }

    // Getter und Setter
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

