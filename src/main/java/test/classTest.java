package test;

import bean.I001_020_TargetReportDescriptor;
import bean.I001_030Warning_ErrorConditions;
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
        System.out.println(i001_030Warning_errorConditions.toString());
    }

    @Test
    public void test02() {
        int i = 1;
        int j = i++;
        ++j;

        System.out.println(j);
        if ((j > ++j) && (i++ == j)) {

        }

    }

    @Test
    public void test03() {

        int i1 = BinaryToDecimal("1111");
        System.out.println(i1);

    }

    // 任意二进制数转换为十进制数 包括正负二进制数
    public static int BinaryToDecimal(String binaryNumber) {
        String firstNum = binaryNumber.substring(0, 1);
        int num = Integer.parseInt(binaryNumber);

        int decimal = 0;
        int p = 0;
        //首位为0 则为正数
        if (Integer.parseInt(firstNum) == 0) {
            while (true) {
                if (num == 0) {
                    break;
                } else {
                    //111
                    int temp = num % 10; //1
                    decimal += temp * Math.pow(2, p);
                    num = num / 10;
                    p++;
                }
            }
            // 首位为1 则为负数
        } else {
            //取得反码
            num -= 1;
            //1110
            String oldNum = String.valueOf(num);
            StringBuilder newNum = new StringBuilder();
            //获取绝对值的原码

            for (int i = 0; i < oldNum.length(); i++) {
                int temp = 0;
//                System.out.println("==" + oldNum.substring(i, i));
                if (oldNum.substring(i, i) != null &&!oldNum.substring(i, i).equals("")) {
                    temp = Integer.parseInt(oldNum.substring(i, i));
                }
//                temp = Integer.parseInt(oldNum.substring(i, 1));
                if (temp == 1) {
                    newNum.append(0);
                } else {
                    newNum.append(1);
                }
            }
            System.out.println("newNum" + newNum);
            int fushu = Integer.parseInt(newNum.toString());
            System.out.println("fushu"+fushu);

            while (true) {
                if (fushu == 0) {
                    break;
                } else {
                    //111
                    int temp = fushu % 10; //1
                    decimal += temp * Math.pow(2, p);
                    fushu = fushu / 10;
                    p++;
                }
                decimal = -decimal;
            }
        }
        return decimal;
    }
}

