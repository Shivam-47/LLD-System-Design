package org.example.Video;

public class MP4Video implements Video {
    private final int size;
    private final int[] bytes;

    public MP4Video(int size, int[] bytes) {
        this.size = size;
        this.bytes = bytes;
    }

    @Override
    public int getMediaSize() {
        return size;
    }

    @Override
    public int[] getBytes() {
        return bytes.clone(); // Return a copy to prevent modification
    }
}