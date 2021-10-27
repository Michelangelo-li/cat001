package bean;


import lombok.Data;

@Data
public class I001_210_TrackQuality {
    private int Quality_indicator;
    public static int length = 1;

    public I001_210_TrackQuality(int[] data, int index) {
        Quality_indicator = (data[index] >> 1) & 0x7f;
    }

    public String toString() {
        return Quality_indicator + "";
    }
}

