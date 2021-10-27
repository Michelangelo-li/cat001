package bean;

import lombok.Data;

@Data
public class I001_170_TrackStatus {
    private int CON;
    private int RAD;
    private int MAN;
    private int DOU;
    private int RDPC;
    private int GHO;
    private int TRE;

    private static int length;

    public I001_170_TrackStatus(int[] data, int index) {
        length = 1;
        CON = (data[index] >> 7) & 0x01;
        RAD = (data[index] >> 6) & 0x01;
        MAN = (data[index] >> 5) & 0x01;
        DOU = (data[index] >> 4) & 0x01;
        RDPC = (data[index] >> 3) & 0x01;
        GHO = (data[index] >> 1) & 0x01;
        if ((data[index] & 0x01) == 1) {
            length += 1;
            TRE = (data[index + 1] >> 7) & 0x01;
        }
    }

    @Override
    public String toString() {
        return CON + "," + RAD + "," + MAN + "," + DOU + "," + RDPC + "," + GHO + "," + TRE;
    }
}
