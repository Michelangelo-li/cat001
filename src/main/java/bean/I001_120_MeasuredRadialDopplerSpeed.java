package bean;


import decoder.CommonUtil;
import lombok.Data;

@Data
public class I001_120_MeasuredRadialDopplerSpeed {
    public static int length = 1;
    //bit-1 (LSB) = 2^(-14+f) NM/s
    //A default quantisation unit of 14.062 5 kt and a maximum of +/- 1 800 kt is obtained for a value of f = 6.
    private double groundSpeed;
    private double lsb = 14.0625;

    public I001_120_MeasuredRadialDopplerSpeed(int[] data, int index) {
        String s = CommonUtil.intToStringBinary(data[index]);
        groundSpeed = CommonUtil.stringBinaryToDecimal(s) * lsb;
    }

    @Override
    public String toString() {
        return groundSpeed+"";
    }
}