package at.technikum.model;
import java.time.LocalDateTime;

public class Rating
{
    private int id;
    private int userId;
    private int mediaEntryId;
    private int stars;
    private String comment;
    private LocalDateTime timestamp;
    private boolean confirmed;
    // true = bestätigt, also sichtbar; false = noch nicht bestätigt, also versteckt

    // Konstruktor 1 für bestehendes Rating
    public Rating(int id, int userId, int mediaEntryId, int stars, String comment, LocalDateTime timestamp, boolean confirmed)
    {
        this.id = id;
        this.userId = userId;
        this.mediaEntryId = mediaEntryId;
        this.stars = stars;
        this.comment = comment;
        this.timestamp = timestamp;
        this.confirmed = confirmed;
    }

    // Konstruktor 2 für ein neues Rating
    public Rating(int userId, int mediaEntryId, int stars, String comment)
    {
        this.userId = userId;
        this.mediaEntryId = mediaEntryId;
        this.stars = stars;
        this.comment = comment;
        // Diese vier oberen Werte kommen von außen rein, deshalb sind sie in den Klammern.
        // Die zwei unteren jettzt stehen bei einem neuen Rating IMMER fest, deshalb setzt der Konstruktor sie selbst.
        this.timestamp = LocalDateTime.now();
        this.confirmed = false;
    }

    // Getter und Setter für diese
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getStars()
    {
        return stars;
    }

    public void setStars(int stars)
    {
        this.stars = stars;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public boolean isConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed)
    {
        this.confirmed = confirmed;
    }

    // Nur Getter für diese, da wir hier die Werte im Nachhinein nicht verändern wollen
    public int getUserId()
    {
        return userId;
    }

    public int getMediaEntryId()
    {
        return mediaEntryId;
    }
}

