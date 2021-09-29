package test;

import bean.I001_020_TargetReportDescriptor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void test02() {

        String a = "test commit";
        System.out.println("alter username commit");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()) + "提交");// new Date()为获取当前系统时间
        System.out.println("idea push commit");
        System.out.println("third commit");

    }
}
