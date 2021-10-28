package bean;

import lombok.Data;

@Data
public class I001_161_TrackPlotNumber {
    private int TRACKPLOT_NUMBER;
    public static int length = 2;

    public I001_161_TrackPlotNumber(int[] data, int index) {
        TRACKPLOT_NUMBER = data[index] << 8 | data[index + 1];
    }

    @Override
    public String toString() {
        return TRACKPLOT_NUMBER + "";
    }
}
