package test;

import bean.I001_020_TargetReportDescriptor;
import bean.I001_030Warning_ErrorConditions;
import bean.I001_042_CalculatedPositionInCartesianCo_ordinates;
import decoder.CommonUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;

@Data
public class classTest {

    @Test
    public void test1() {
        int a = 3;
        System.out.println((a >> 1) & 0x01);
    }

    @Test
    public void test020() {
        //0101 0110
        int[] data = new int[]{87, 65};
        I001_020_TargetReportDescriptor i001_020_targetReportDescriptor = new I001_020_TargetReportDescriptor(data, 0);
        System.out.println(i001_020_targetReportDescriptor);
    }

    @Test
    public void test030() {
        int[] data = new int[]{173, 29, 2};
        I001_030Warning_ErrorConditions i001_030Warning_errorConditions = new I001_030Warning_ErrorConditions(data, 0);
        System.out.println(i001_030Warning_errorConditions);
    }

    @Test
    public void test042() {
        //1111 1010 1111 1001 0000 0110
        int[] data = new int[]{1, 1, -6, 3};
        I001_042_CalculatedPositionInCartesianCo_ordinates i001_042_calculatedPositionInCartesianCo_ordinates = new I001_042_CalculatedPositionInCartesianCo_ordinates(data, 0);
        System.out.println(i001_042_calculatedPositionInCartesianCo_ordinates);
    }

    @Test
    public void test02() {
        String s = CommonUtil.intToStringBinary(-6);
        System.out.println(s);
    }

    @Test
    public void test03() {

        long i = Long.parseLong("1111101000000011");
        System.out.println(i);
//        long i5 = CommonUtil.stringBinaryToDecimal("1000000000");
//        System.out.println(i5);
//        int i6 = CommonUtil.stringBinaryToDecimal("11111010");
//
    }

}


