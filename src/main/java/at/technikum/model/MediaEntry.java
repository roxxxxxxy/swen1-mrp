package at.technikum.model;

import java.util.List;

public class MediaEntry
{
    private int id;
    private String title;
    private String description;
    private MediaType mediaType;
    // Der Typ ist MediaType, weil ich den im Paket model als enum definiert habe.
    // -> dadurch sind nur MOVIE, SERIES oder GAME erlaubt
    private int releaseYear;
    private List<String> genres;
    private int ageRestriction;

    // Konstruktor: generiert, damit Klasse benutzbar wird (Generate > Constructor > alle ausgewählt)
    public MediaEntry(int id, String title, String description, MediaType mediaType, int releaseYear, List<String> genres, int ageRestriction)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.mediaType = mediaType;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.ageRestriction = ageRestriction;
    }

    // Getter und Setter: generiert (gleich wie Konstruktor)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public MediaType getMediaType()
    {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public List<String> getGenres()
    {
        return genres;
    }

    public void setGenres(List<String> genres)
    {
        this.genres = genres;
    }

    public int getAgeRestriction()
    {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction)
    {
        this.ageRestriction = ageRestriction;
    }
}
