package bean;

import lombok.Data;

@Data
public class I001_040_MeasuredPositionInPolarCoordinates {
    private double RHO;
    private double THETA;

    private static double ratio1 = 128.0;
    private static double ratio2 = 0.0055;

    public static int length = 4;


    public I001_040_MeasuredPositionInPolarCoordinates(int[] data, int index) {
        RHO = (data[index] << 8 | data[index + 1]) / ratio1;
        THETA = (data[index + 2] << 8 | data[index + 3]) * ratio2;
    }

    @Override
    public String toString() {
        return RHO + "," + THETA;
    }

}
