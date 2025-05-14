package org.example;

import org.example.Audio.MP3Audio;
import org.example.AudioConvertor.Adapter;
import org.example.AudioConvertor.MP4ToMP3Adapter;
import org.example.Video.Video;
import org.example.Video.MP4Video;
import org.example.Audio.Audio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Media Converter");

        // Create a video object
        Video mp4Video = new MP4Video(10, new int[]{2, 2, 4, 6, 2, 8});

        // Use the adapter to convert video to MP3 audio format
        Adapter mp4ToMp3Adapter = new MP4ToMP3Adapter(mp4Video);

        // Create an MP3 audio object that adapts the video
        Audio mp3Audio = new MP3Audio(mp4ToMp3Adapter);

        // Now we can use the video as if it were MP3 audio
        int audioSize = mp3Audio.getSize();
        int[] audioBytes = mp3Audio.getBytes();

        System.out.println("Audio size = " + audioSize);

        System.out.print("Audio bytes: ");
        for (int audioByte : audioBytes) {
            System.out.print(audioByte + " ");
        }
        System.out.println();

        // Example of creating native MP3 audio without adaptation
        Audio nativeMp3 = new MP3Audio(5, new int[]{1, 2, 3, 4, 5});
        System.out.println("Native MP3 size: " + nativeMp3.getSize());

        System.out.print("Native Audio bytes: ");
        for (int audioByte : audioBytes) {
            System.out.print(audioByte + " ");
        }
        System.out.println();
    }
}