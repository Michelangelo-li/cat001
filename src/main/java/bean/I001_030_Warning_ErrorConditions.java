package bean;


import lombok.Data;

import java.util.ArrayList;

@Data
public class I001_030_Warning_ErrorConditions {

    private  int W_EValue;
    public static int length ;
    private ArrayList<Integer> W_EValueList;

    public I001_030_Warning_ErrorConditions(int[] data, int index) {
        W_EValueList = new ArrayList<>();
        int currentIndex = index;
        int oByte = 0;
        do {
            length += 1;
            oByte = data[currentIndex];
            W_EValue = oByte >> 1;
            W_EValueList.add(W_EValue);
            currentIndex += 1;
        } while ((oByte & 0x01) == 1);
    }

    @Override
    public String toString() {
        return W_EValueList.toString();
    }
}
