package bean;


import decoder.CommonUtil;
import lombok.Data;

// TODO: 2021/10/8 二进制负数问题
@Data
public class I001_042_CalculatedPositionInCartesianCo_ordinates {
    private double X_Component;
    private double Y_Component;

    public static int length = 4;

    private double ratio = 64.0;

    public I001_042_CalculatedPositionInCartesianCo_ordinates(int[] data, int index) {
        String s1 = CommonUtil.intToStringBinary(data[index]);
        String s2 = CommonUtil.intToStringBinary(data[index+1]);
        String s3 = CommonUtil.intToStringBinary(data[index+2]);
        String s4 = CommonUtil.intToStringBinary(data[index+3]);

        StringBuilder X = new StringBuilder();
        StringBuilder Y = new StringBuilder();
        X.append(s1).append(s2);
        Y.append(s3).append(s4);
        System.out.println("X"+X);
        System.out.println("Y"+Y);

        X_Component= CommonUtil.stringBinaryToDecimal(X.toString())/ ratio;
        Y_Component= CommonUtil.stringBinaryToDecimal(Y.toString())/ ratio;
//        X_Component = (data[index] << 8 | data[index + 1]) / ratio;
//        Y_Component = (data[index + 2] << 8 | data[index + 3]) / ratio;
    }

    @Override
    public String toString() {
        return X_Component + "," + Y_Component;
    }
}
