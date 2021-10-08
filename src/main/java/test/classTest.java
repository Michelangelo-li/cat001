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
    public void test030(){
        int[] data = new int[]{87,65};
        new I001_030Warning_ErrorConditions(data,0);
    }

    @Test
    public void test02() {
        int i = 1;
        int j = i++;
        ++j;

        System.out.println(j);
        if ((j > ++j) && (i++ == j)) {
            //j=1  j++ = 1
            //j =2
            j += i;
        }

    }
}
