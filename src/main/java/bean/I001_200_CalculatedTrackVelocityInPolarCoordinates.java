package bean;


import lombok.Data;

@Data
public class I001_200_CalculatedTrackVelocityInPolarCoordinates {
    private double CALCULATED_GROUNDSPEED;
    private double CALCULATED_HEADING;

    public static int length = 4;

    //bit-17 (LSB) = (2-14) NM/s = 0.22 kt
    //bit-1 (LSB) = 360°/(216) = 0.005 5°
    private double lsb1 = 0.22;
    private double lsb2 = 0.0055;

    public I001_200_CalculatedTrackVelocityInPolarCoordinates(int[] data, int index) {
        CALCULATED_GROUNDSPEED = (data[index] << 8 | data[index + 1]) * lsb1;
        CALCULATED_HEADING = (data[index + 2] << 8 | data[index + 3]) * lsb2;
    }

    @Override
    public String toString() {
        return CALCULATED_GROUNDSPEED + "," + CALCULATED_HEADING;
    }
}
