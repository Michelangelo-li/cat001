package test;

import bean.*;
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
        I001_030_Warning_ErrorConditions i001_030Warning_errorConditions = new I001_030_Warning_ErrorConditions(data, 0);
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
    public void test0170() {
        // 1111 1011 0000 0000
        int[] data = new int[]{251,128};
        I001_170_TrackStatus i001_170_trackStatus = new I001_170_TrackStatus(data, 0);
        System.out.println(i001_170_trackStatus);
    }

    @Test
    public void test02() {
        String s = CommonUtil.intToStringBinary(-6);
        System.out.println(s);
    }

    @Test
    public void test04() {
        //0000 1010
        //0011 0011 0000 1010 => 11 0011 1111 0110 =>11 0011 1111 0101=> 00 1100 0000 1010
        //  11 0011 1111 0110
        int[] data = new int[]{51, -10};
        I001_090_ModeCCodeInBinaryRepresentation i001_090_modeCCodeInBinaryRepresentation = new I001_090_ModeCCodeInBinaryRepresentation(data, 0);
        System.out.println(i001_090_modeCCodeInBinaryRepresentation);
    }

    @Test
    public void test03() {
        long i5 = CommonUtil.stringBinaryToDecimal("11001111110110");
        //1100 0000 1010
        //11 10 +10
        System.out.println(i5);
    }
}


