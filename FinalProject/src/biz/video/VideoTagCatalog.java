package biz.video;

import biz.nw.Network;

import java.util.HashMap;
import java.util.stream.Collectors;

public class VideoTagCatalog {
    private Network network;
    private HashMap<String, VideoTag> videoTagHashMap;

    public VideoTagCatalog(Network network) {
        this.network = network;
        this.videoTagHashMap = new HashMap<>();
    }

    public VideoTag getOrNewTag(String name) {
        VideoTag t = videoTagHashMap.getOrDefault(name, new VideoTag(name));
        this.videoTagHashMap.put(name, t);
        return t;
    }

    public HashMap<String, VideoTag> getVideoTagHashMap() {
        return videoTagHashMap;
    }

    public Network getNetwork() {
        return network;
    }

    public HashMap<VideoTag, Integer> countVideoByTag() {
        HashMap<VideoTag, Integer> map = new HashMap<>();
        network.getVideoCatalog().getVideoArrayList()
                .forEach(video -> video.getTagHashSet().forEach(tag -> {
                    int num = map.getOrDefault(tag, 0);
                    map.put(tag, num + 1);
                }));
        return map;
    }

    public HashMap<VideoTag, Integer> countCanViewVideoByTag() {
        HashMap<VideoTag, Integer> map = new HashMap<>();
        network.getVideoCatalog().getVideoArrayList()
                .stream()
                .filter(Video::canView)
                .forEach(video -> video.getTagHashSet().forEach(tag -> {
                    int num = map.getOrDefault(tag, 0);
                    map.put(tag, num + 1);
                }));
        return map;
    }
}
