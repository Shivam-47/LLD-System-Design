package org.example.AudioConvertor;

import org.example.Video.Video;

public class MP4ToMP3Adapter implements Adapter {
    private final Video video;

    public MP4ToMP3Adapter(Video video) {
        this.video = video;
    }

    @Override
    public int getSize() {
        // Convert video size to audio size (simplified)
        return video.getMediaSize() / 2;
    }

    @Override
    public int[] getBytes() {
        // Convert video bytes to audio bytes (simplified)
        int[] videoBytes = video.getBytes();
        int[] audioBytes = new int[videoBytes.length];

        for (int i = 0; i < videoBytes.length; i++) {
            audioBytes[i] = videoBytes[i] / 2;
        }

        return audioBytes;
    }
}
