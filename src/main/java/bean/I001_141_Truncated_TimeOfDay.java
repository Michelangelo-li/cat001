package bean;

import lombok.Data;

@Data
public class I001_141_Truncated_TimeOfDay {
    private double TruncatedTimeOfDay;
    private double lsb = 128.0;

    public static int length = 2;

    public I001_141_Truncated_TimeOfDay(int[] data, int index) {
        TruncatedTimeOfDay = (data[index] << 8 | data[index + 1]) / lsb;
    }

    @Override
    public String toString() {
        return TruncatedTimeOfDay + "";
    }
}
