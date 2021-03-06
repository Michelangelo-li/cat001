package bean;

import lombok.Data;

@Data
public class I001_080_Mode3ACodeConfidenceIndicator {
    private String Mode3ACodeConfidenceIndicator;
    public static int length = 2;

    public I001_080_Mode3ACodeConfidenceIndicator(int[] data, int index) {
        int QA4;
        int QA2;
        int QA1;
        int QB4;
        int QB2;
        int QB1;
        int QC4;
        int QC2;
        int QC1;
        int QD4;
        int QD2;
        int QD1;

//        a1 = (data[index] >> 1) & 0x07;
//        a2 = ((data[index]) & 0x01) + ((data[index + 1] >> 6) & 0x03);
//        a3 = (data[index + 1] >> 3) & 0x07;
//        a4 = (data[index + 1]) & 0x07;
        QA4 = (data[index] >> 3) & 0x01;
        QA2 = (data[index] >> 2) & 0x01;
        QA1 = (data[index] >> 1) & 0x01;
        QB4 = data[index] & 0x01;
        QB2 = (data[index + 1] >> 7) & 0x01;
        QB1 = (data[index + 1] >> 6) & 0x01;
        QC4 = (data[index + 1] >> 5) & 0x01;
        QC2 = (data[index + 1] >> 4) & 0x01;
        QC1 = (data[index + 1] >> 3) & 0x01;
        QD4 = (data[index + 1] >> 2) & 0x01;
        QD2 = (data[index + 1] >> 1) & 0x01;
        QD1 = (data[index + 1]) & 0x01;

        Mode3ACodeConfidenceIndicator = QA4 + "" + QA2 + "" + QA1 + "" +
                QB4 + "" + QB2 + "" + QB1 + "" +
                QC4 + "" + QC2 + "" + QC1 + "" +
                QD4 + "" + QD2 + "" + QD1;
    }

    @Override
    public String toString() {
        return Mode3ACodeConfidenceIndicator;
    }
}
