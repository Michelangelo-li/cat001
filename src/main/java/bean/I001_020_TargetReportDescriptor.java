package bean;


import lombok.Data;

@Data
public class I001_020_TargetReportDescriptor {
    private int TYP;
    private int SIM;
    private String SSR_PSR;
    private int ANT;
    private int SPI;
    private int RAB;
    private Extent020 extent020;
    public static int length;

    public I001_020_TargetReportDescriptor(int[] data, int index) {
        length = 1;
        TYP = (data[index] >> 7) & 0x01;
        SIM = (data[index] >> 6) & 0x01;
        SSR_PSR = ((data[index] >> 5) & 0x01) + "" + ((data[index] >> 4) & 0x01);
        ANT = (data[index] >> 3) & 0x01;
        SPI = (data[index] >> 2) & 0x01;
        RAB = (data[index] >> 1) & 0x01;
        if ((data[index] & 0x01) == 1) {
            length += 1;
            extent020 = new Extent020(data[index + 1]);
        } else {
            extent020 = null;
        }
    }

    @Override
    public String toString() {
        if (extent020 == null) {
            return TYP + "," + SIM + "," + SSR_PSR + "," + ANT + "," + SPI + "," + RAB;
        } else {
            return TYP + "," + SIM + "," + SSR_PSR + "," + ANT + "," + SPI + "," + RAB + "," + extent020;
        }
    }
}
