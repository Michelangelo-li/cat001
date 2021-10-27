package bean;

import lombok.Data;

import java.util.ArrayList;

@Data
public class I001_130_RadarPlotCharacteristics {

    private int Additional_information;
    private ArrayList<Integer> Additional_informationList;
    public  static int length;

    public I001_130_RadarPlotCharacteristics(int[] data, int index) {
        Additional_informationList = new ArrayList<>();
        int currentIndex = index;
        int oByte = 0;
        do {
            length += 1;
            oByte = data[currentIndex];
            Additional_information = oByte >> 1;
            Additional_informationList.add(Additional_information);
            currentIndex += 1;
        } while ((oByte & 0x01) == 1);
    }


    @Override
    public String toString() {
        return Additional_informationList.toString();
    }
}
