package bean;

import decoder.CommonUtil;
import lombok.Data;

@Data
public class I001_131_ReceivedPower {
    private long Power;
    // lsb = 1 dBm
    private int lsb = 1;
    public static int length = 1;

    public I001_131_ReceivedPower(int[] data, int index) {
        String s1 = CommonUtil.intToStringBinary(data[index]);
        Power = CommonUtil.stringBinaryToDecimal(s1);
    }

    @Override
    public String toString(){
        return Power+"";
    }
}
