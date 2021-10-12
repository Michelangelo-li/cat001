package bean;


import lombok.Data;

// TODO: 2021/10/8 二进制负数问题
@Data
public class I001_042_CalculatedPositionInCartesianCo_ordinates {
    private double X_Component;
    private double Y_Component;

    public static int length = 4;

    private double ratio = 64.0;

    public I001_042_CalculatedPositionInCartesianCo_ordinates(int[] data, int index) {
        X_Component = (data[index] << 8 | data[index + 1]) / ratio;
        Y_Component = (data[index + 2] << 8 | data[index + 3]) / ratio;
    }

    @Override
    public String toString() {
        return X_Component + "," + Y_Component;
    }
}
