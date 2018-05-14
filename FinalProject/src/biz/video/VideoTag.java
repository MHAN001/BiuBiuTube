package biz.video;

public class VideoTag {
    public String name;

    public VideoTag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
