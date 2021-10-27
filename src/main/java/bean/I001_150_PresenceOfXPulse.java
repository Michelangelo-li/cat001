package bean;

import lombok.Data;

@Data
public class I001_150_PresenceOfXPulse {
    private int XA;
    private int XC;
    private int X2;

    public static int length = 1;

    public I001_150_PresenceOfXPulse(int[] data, int index) {
        XA = (data[index] >> 7) & 0x01;
        XC = (data[index] >> 5) & 0x01;
        X2 = (data[index] >> 2) & 0x01;
    }

    @Override
    public String toString() {
        return XA + "," + XC + "," + X2;
    }
}
