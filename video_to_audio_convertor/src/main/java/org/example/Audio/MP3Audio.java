package org.example.Audio;
import org.example.AudioConvertor.Adapter;

public class MP3Audio implements Audio {
    private Adapter adapter;
    private int size;
    private int[] bytes;

    public MP3Audio(int size, int[] bytes) {
        this.size = size;
        this.bytes = bytes;
        this.adapter = null;
    }

    public MP3Audio(Adapter adapter) {
        this.adapter = adapter;
        this.size = -1; // Will be obtained from adapter
        this.bytes = null; // Will be obtained from adapter
    }

    @Override
    public int getSize() {
        if (adapter != null) {
            return adapter.getSize();
        }
        return size;
    }

    @Override
    public int[] getBytes() {
        if (adapter != null) {
            return adapter.getBytes();
        }
        return bytes;
    }
}
