package bean;


import decoder.CommonUtil;
import lombok.Data;


// TODO: 2021/10/8 二进制负数问题
@Data
public class I001_090_ModeCCodeInBinaryRepresentation {
    private int V;
    private int G;
    private long ModeC_HEIGHT;

    //(LSB) = 1/4 FL = 25 ft
    private int lsb = 25;
    public static int length = 2;

    public I001_090_ModeCCodeInBinaryRepresentation(int[] data, int index) {
        V = (data[index] >> 7) & 0x01;
        G = (data[index] >> 6) & 0x01;
        StringBuilder ModeC = new StringBuilder();
        ModeC.append(data[index] >> 5 & 0x01).append(data[index] >> 4 & 0x01).append(data[index] >> 3 & 0x01)
                .append(data[index] >> 2 & 0x01).append(data[index] >> 1 & 0x01).append(data[index] & 0x01)
                .append(CommonUtil.intToStringBinary(data[index + 1]));
        ModeC_HEIGHT = CommonUtil.stringBinaryToDecimal(ModeC.toString());

    }

    @Override
    public String toString() {
        return V + "," + G + "," + ModeC_HEIGHT;
    }
}
