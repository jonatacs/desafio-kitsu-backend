package Application.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes extends Common {
    private String description;
    
    @JsonProperty("canonicalTitle")
    private String name;
    private String chapterCount;
    private String volumeCount;
    private PosterImage posterImage;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getChapterCount() {
        return chapterCount;
    }

    public String getVolumeCount() {
        return volumeCount;
    }

    public PosterImage getPosterImage() {
        return posterImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChapterCount(String chapterCount) {
        this.chapterCount = chapterCount;
    }

    public void setVolumeCount(String volumeCount) {
        this.volumeCount = volumeCount;
    }

    public void setPosterImage(PosterImage posterImage) {
        this.posterImage = posterImage;
    }
}
