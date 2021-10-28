package decoder;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CAT001Data {

    public static final int CAT001_ID = 1;

//    @Getter
//    @Setter
//    private long receiveTime;

    @Getter
    @Setter
    private CAT001Track[] cat001Tracks;


    @Getter
    @Setter
    @JSONField(serialize = false)

    private List<CAT001Track> cat001TracksList;



    public CAT001Data(int[] data, int startIndex, int dataLength) throws Exception {
        int currentIndex = startIndex;

        if (data[currentIndex] != CAT001_ID) {
            throw new Exception("不是ASTERIX-CAT001格式数据");
        }

        // UAP中的lenth 为int数组的第二位和第三位的和
//        System.out.println("length"+((data[currentIndex + 1] << 8) + data[currentIndex + 2]));
        int length = (data[currentIndex + 1] << 8) + data[currentIndex + 2];
//        System.out.println("lenth:"+length);
//        if (dataLength != length || data.length - startIndex < dataLength) {
//            throw new Exception("ASTERIX-CAT062数据长度错误");
//        }

        currentIndex += 3;
        cat001TracksList = new ArrayList();


        //startIndex=0
        //3
        //


        while (currentIndex - startIndex < length) {

            // int[] data currentIndex = 3
            CAT001Track track = new CAT001Track(data, currentIndex);

            cat001TracksList.add(track);
            currentIndex += CAT001Track.length;
        }


        if (currentIndex - startIndex != length) {

            throw new Exception("ASTERIX CAT048数据解析错误。");
        }
        this.cat001Tracks = cat001TracksList.toArray(new CAT001Track[]{});

//        this.receiveTime = receiveTime;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(4096);
//        stringBuilder.append(receiveTime);

        for (CAT001Track track : cat001TracksList) {
//            stringBuilder.append("#").append(track.toString());
            stringBuilder.append(track.toString());
        }
        return stringBuilder.toString();
    }

}
