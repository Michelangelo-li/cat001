package bean;


import lombok.Data;

@Data
public class Extent020 {
    private int TST;
    private String DS1_DS2;
    private int ME;
    private int MI;


    public Extent020(int value) {
        TST = value >> 7 & 0X01;
        DS1_DS2 = (value >> 6 & 0X01) + "" + (value >> 5 & 0X01);
        ME = value >> 4 & 0X01;
        MI = value >> 3 & 0X01;
    }

    @Override
    public String toString() {
        return TST + "," + DS1_DS2 + "," + ME + "," + MI;
    }
}
