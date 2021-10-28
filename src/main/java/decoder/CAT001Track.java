package decoder;


import bean.*;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CAT001Track {
    I001_010_DataSourceIdentifier i001_010_dataSourceIdentifier;
    I001_020_TargetReportDescriptor i001_020_targetReportDescriptor;
    I001_030_Warning_ErrorConditions i001_030_Warning_errorConditions;
    I001_040_MeasuredPositionInPolarCoordinates i001_040_measuredPositionInPolarCoordinates;
    I001_042_CalculatedPositionInCartesianCo_ordinates i001_042_calculatedPositionInCartesianCo_ordinates;
    I001_050_Mode_2CodeInOctalRepresentation i001_050_mode_2CodeInOctalRepresentation;
    I001_060_Mode2CodeConfidenceIndicator i001_060_mode2CodeConfidenceIndicator;
    I001_070_Mode3ACodeInOctalRepresentation i001_070_mode3ACodeInOctalRepresentation;
    I001_080_Mode3ACodeConfidenceIndicator i001_080_mode3ACodeConfidenceIndicator;
    I001_090_ModeCCodeInBinaryRepresentation i001_090_modeCCodeInBinaryRepresentation;
    I001_100_ModeCCodeAndCodeConfidenceIndicator i001_100_modeCCodeAndCodeConfidenceIndicator;
    I001_120_MeasuredRadialDopplerSpeed i001_120_measuredRadialDopplerSpeed;
    I001_130_RadarPlotCharacteristics i001_130_radarPlotCharacteristics;
    I001_131_ReceivedPower i001_131_receivedPower;
    I001_141_Truncated_TimeOfDay i001_141_truncated_timeOfDay;
    I001_150_PresenceOfXPulse i001_150_presenceOfXPulse;
    I001_161_TrackPlotNumber i001_161_trackPlotNumber;
    I001_170_TrackStatus i001_170_trackStatus;
    I001_200_CalculatedTrackVelocityInPolarCoordinates i001_200_calculatedTrackVelocityInPolarCoordinates;
    I001_210_TrackQuality i001_210_trackQuality;

    // 指定字段不序列化
    @JSONField(serialize = false)
    private ArrayList<Integer> plotExistedItems = new ArrayList<>();

    // 指定字段不序列化
    @JSONField(serialize = false)
    private ArrayList<Integer> trackExistedItems = new ArrayList<>();

    @JSONField(serialize = false)
    public static int length;

    //false为plot
    private boolean flag = false;

    public CAT001Track(int[] data, int index) {
        // currentIndex = 3  254
        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 0;


        //data[currentIndex] = f6 = 1111 0110
//        int temCurIndex = currentIndex;
//        int temOByte = 0;
//        do {
//            temOByte = data[temCurIndex];
//            if ((temOByte & 0x01) == 1) {
//                temCurIndex += 1;
//            }
//
//        } while ((temOByte & 0x01) == 0x01);
//        temOByte = data[temCurIndex + 1];

        int temOByte = getTemCurIndex(data, index);

        if ((temOByte >> 7 & 0x01) == 0) {
            flag = true;
            do {
                // obyte = 254 1111 1110
                oByte = data[currentIndex];
                //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；00000001=0x01
                for (int i = 7; i >= 1; i--) {
                    //其中对应的位为1
                    // oByte >> 7 = 1
                    if (((oByte >> i) & 0x01) == 0x01) {
                        //existedItems add 10
                        plotExistedItems.add(CAT001PlotUAP.plotUAP[itemIndex]);
                    }
                    itemIndex += 1;
                }
                // currentIndex = 4
                currentIndex += 1;
            } while ((oByte & 0x01) == 0x01);

            for (int item : plotExistedItems) {
                switch (item) {
                    case 10:
                        // currentIndex = 4
                        i001_010_dataSourceIdentifier = new I001_010_DataSourceIdentifier(data, currentIndex);
                        currentIndex += I001_010_DataSourceIdentifier.length;
                        break;
                    case 20:
                        i001_020_targetReportDescriptor = new I001_020_TargetReportDescriptor(data, currentIndex);
                        currentIndex += I001_020_TargetReportDescriptor.length;
                        break;
                    case 40:
                        i001_040_measuredPositionInPolarCoordinates = new I001_040_MeasuredPositionInPolarCoordinates(data, currentIndex);
                        currentIndex += I001_040_MeasuredPositionInPolarCoordinates.length;
                        break;
                    case 70:
                        i001_070_mode3ACodeInOctalRepresentation = new I001_070_Mode3ACodeInOctalRepresentation(data, currentIndex);
                        currentIndex += I001_070_Mode3ACodeInOctalRepresentation.length;
                        break;
                    case 90:
                        i001_090_modeCCodeInBinaryRepresentation = new I001_090_ModeCCodeInBinaryRepresentation(data, currentIndex);
                        currentIndex += I001_090_ModeCCodeInBinaryRepresentation.length;
                        break;
                    case 130:
                        i001_130_radarPlotCharacteristics = new I001_130_RadarPlotCharacteristics(data, currentIndex);
                        currentIndex += I001_130_RadarPlotCharacteristics.length;
                        break;
                    case 141:
                        i001_141_truncated_timeOfDay = new I001_141_Truncated_TimeOfDay(data, currentIndex);
                        currentIndex += I001_141_Truncated_TimeOfDay.length;
                        break;
                    case 50:
                        i001_050_mode_2CodeInOctalRepresentation = new I001_050_Mode_2CodeInOctalRepresentation(data, currentIndex);
                        currentIndex += I001_050_Mode_2CodeInOctalRepresentation.length;
                        break;
                    case 120:
                        i001_120_measuredRadialDopplerSpeed = new I001_120_MeasuredRadialDopplerSpeed(data, currentIndex);
                        currentIndex += I001_120_MeasuredRadialDopplerSpeed.length;
                        break;
                    case 131:
                        i001_131_receivedPower = new I001_131_ReceivedPower(data, currentIndex);
                        currentIndex += I001_131_ReceivedPower.length;
                        break;
                    case 80:
                        i001_080_mode3ACodeConfidenceIndicator = new I001_080_Mode3ACodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_080_Mode3ACodeConfidenceIndicator.length;
                        break;
                    case 100:
                        i001_100_modeCCodeAndCodeConfidenceIndicator = new I001_100_ModeCCodeAndCodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_100_ModeCCodeAndCodeConfidenceIndicator.length;
                        break;
                    case 60:
                        i001_060_mode2CodeConfidenceIndicator = new I001_060_Mode2CodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_060_Mode2CodeConfidenceIndicator.length;
                        break;
                    case 30:
                        i001_030_Warning_errorConditions = new I001_030_Warning_ErrorConditions(data, currentIndex);
                        currentIndex += I001_030_Warning_ErrorConditions.length;
                        break;
                    case 150:
                        i001_150_presenceOfXPulse = new I001_150_PresenceOfXPulse(data, currentIndex);
                        currentIndex += I001_150_PresenceOfXPulse.length;
                        break;

                    case -1:
                        currentIndex += data[currentIndex];
                        break;
                    case -2:
                        while ((data[currentIndex] & 0x01) == 0x01) {
                            currentIndex += 1;
                        }
                        currentIndex += 1;
                        break;
                    default:
                        // 10 20
                        if (item <= -3 && item >= -100) {
                            currentIndex += (data[currentIndex] * (-2 - item) + 1);
                        } else if (item < -100) {
                            currentIndex += (-100 - item);
                        }
                        break;
                }
            }

        } else {

            do {
                // obyte = 254 1111 1110
                oByte = data[currentIndex];
                //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；00000001=0x01
                for (int i = 7; i >= 1; i--) {
                    //其中对应的位为1
                    // oByte >> 7 = 1
                    if (((oByte >> i) & 0x01) == 0x01) {
                        //existedItems add 10
                        trackExistedItems.add(CAT001TrackUAP.trackUAP[itemIndex]);
                    }
                    itemIndex += 1;
                }
                // currentIndex = 4
                currentIndex += 1;
            } while ((oByte & 0x01) == 0x01);

            for (int item : trackExistedItems) {
                switch (item) {
                    case 10:
                        // currentIndex = 4
                        i001_010_dataSourceIdentifier = new I001_010_DataSourceIdentifier(data, currentIndex);
                        currentIndex += I001_010_DataSourceIdentifier.length;
                        break;
                    case 20:
                        i001_020_targetReportDescriptor = new I001_020_TargetReportDescriptor(data, currentIndex);
                        currentIndex += I001_020_TargetReportDescriptor.length;
                        break;
                    case 161:
                        i001_161_trackPlotNumber = new I001_161_TrackPlotNumber(data, currentIndex);
                        currentIndex += I001_161_TrackPlotNumber.length;
                        break;
                    case 40:
                        i001_040_measuredPositionInPolarCoordinates = new I001_040_MeasuredPositionInPolarCoordinates(data, currentIndex);
                        currentIndex += I001_040_MeasuredPositionInPolarCoordinates.length;
                        break;
                    case 42:
                        i001_042_calculatedPositionInCartesianCo_ordinates = new I001_042_CalculatedPositionInCartesianCo_ordinates(data, currentIndex);
                        currentIndex += I001_042_CalculatedPositionInCartesianCo_ordinates.length;
                        break;
                    case 200:
                        i001_200_calculatedTrackVelocityInPolarCoordinates = new I001_200_CalculatedTrackVelocityInPolarCoordinates(data, currentIndex);
                        currentIndex += I001_200_CalculatedTrackVelocityInPolarCoordinates.length;
                        break;
                    case 70:
                        i001_070_mode3ACodeInOctalRepresentation = new I001_070_Mode3ACodeInOctalRepresentation(data, currentIndex);
                        currentIndex += I001_070_Mode3ACodeInOctalRepresentation.length;
                        break;
                    case 90:
                        i001_090_modeCCodeInBinaryRepresentation = new I001_090_ModeCCodeInBinaryRepresentation(data, currentIndex);
                        currentIndex += I001_090_ModeCCodeInBinaryRepresentation.length;
                        break;
                    case 141:
                        i001_141_truncated_timeOfDay = new I001_141_Truncated_TimeOfDay(data, currentIndex);
                        currentIndex += I001_141_Truncated_TimeOfDay.length;
                        break;
                    case 130:
                        i001_130_radarPlotCharacteristics = new I001_130_RadarPlotCharacteristics(data, currentIndex);
                        currentIndex += I001_130_RadarPlotCharacteristics.length;
                        break;
                    case 131:
                        i001_131_receivedPower = new I001_131_ReceivedPower(data, currentIndex);
                        currentIndex += I001_131_ReceivedPower.length;
                        break;
                    case 120:
                        i001_120_measuredRadialDopplerSpeed = new I001_120_MeasuredRadialDopplerSpeed(data, currentIndex);
                        currentIndex += I001_120_MeasuredRadialDopplerSpeed.length;
                        break;
                    case 170:
                        i001_170_trackStatus = new I001_170_TrackStatus(data, currentIndex);
                        currentIndex += I001_170_TrackStatus.length;
                        break;
                    case 210:
                        i001_210_trackQuality = new I001_210_TrackQuality(data, currentIndex);
                        currentIndex += I001_210_TrackQuality.length;
                        break;
                    case 50:
                        i001_050_mode_2CodeInOctalRepresentation = new I001_050_Mode_2CodeInOctalRepresentation(data, currentIndex);
                        currentIndex += I001_050_Mode_2CodeInOctalRepresentation.length;
                        break;
                    case 80:
                        i001_080_mode3ACodeConfidenceIndicator = new I001_080_Mode3ACodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_080_Mode3ACodeConfidenceIndicator.length;
                        break;
                    case 100:
                        i001_100_modeCCodeAndCodeConfidenceIndicator = new I001_100_ModeCCodeAndCodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_100_ModeCCodeAndCodeConfidenceIndicator.length;
                        break;
                    case 60:
                        i001_060_mode2CodeConfidenceIndicator = new I001_060_Mode2CodeConfidenceIndicator(data, currentIndex);
                        currentIndex += I001_060_Mode2CodeConfidenceIndicator.length;
                        break;

                    case -1:
                        currentIndex += data[currentIndex];
                        break;
                    case -2:
                        while ((data[currentIndex] & 0x01) == 0x01) {
                            currentIndex += 1;
                        }
                        currentIndex += 1;
                        break;
                    default:
                        // 10 20
                        if (item <= -3 && item >= -100) {
                            currentIndex += (data[currentIndex] * (-2 - item) + 1);
                        } else if (item < -100) {
                            currentIndex += (-100 - item);
                        }
                        break;
                }
            }
        }
        length = currentIndex - index;
    }

    public int getTemCurIndex(int[] data, int currentIndex) {
        int temCurIndex = currentIndex;
        int temOByte = 0;
        do {
            temOByte = data[temCurIndex];
            if ((temOByte & 0x01) == 1) {
                temCurIndex += 1;
            }

        } while ((temOByte & 0x01) == 0x01);
        temOByte = data[temCurIndex + 1];

        return temOByte;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(2048);
        if (flag) {
            return stringBuilder.append(i001_010_dataSourceIdentifier)
                    .append(",").append(i001_020_targetReportDescriptor)
                    .append(",").append(i001_040_measuredPositionInPolarCoordinates)
                    .append(",").append(i001_070_mode3ACodeInOctalRepresentation)
                    .append(",").append(i001_090_modeCCodeInBinaryRepresentation)
                    .append(",").append(i001_130_radarPlotCharacteristics)
                    .append(",").append(i001_141_truncated_timeOfDay)
                    .append(",").append(i001_050_mode_2CodeInOctalRepresentation)
                    .append(",").append(i001_120_measuredRadialDopplerSpeed)
                    .append(",").append(i001_131_receivedPower)
                    .append(",").append(i001_080_mode3ACodeConfidenceIndicator)
                    .append(",").append(i001_100_modeCCodeAndCodeConfidenceIndicator)
                    .append(",").append(i001_060_mode2CodeConfidenceIndicator)
                    .append(",").append(i001_030_Warning_errorConditions)
                    .append(",").append(i001_150_presenceOfXPulse)
                    .toString();
        } else {
            return stringBuilder.append(i001_010_dataSourceIdentifier)
                    .append(",").append(i001_020_targetReportDescriptor)
                    .append(",").append(i001_161_trackPlotNumber)
                    .append(",").append(i001_040_measuredPositionInPolarCoordinates)
                    .append(",").append(i001_042_calculatedPositionInCartesianCo_ordinates)
                    .append(",").append(i001_200_calculatedTrackVelocityInPolarCoordinates)
                    .append(",").append(i001_070_mode3ACodeInOctalRepresentation)
                    .append(",").append(i001_090_modeCCodeInBinaryRepresentation)
                    .append(",").append(i001_141_truncated_timeOfDay)
                    .append(",").append(i001_130_radarPlotCharacteristics)
                    .append(",").append(i001_131_receivedPower)
                    .append(",").append(i001_120_measuredRadialDopplerSpeed)
                    .append(",").append(i001_170_trackStatus)
                    .append(",").append(i001_210_trackQuality)
                    .append(",").append(i001_050_mode_2CodeInOctalRepresentation)
                    .append(",").append(i001_080_mode3ACodeConfidenceIndicator)
                    .append(",").append(i001_100_modeCCodeAndCodeConfidenceIndicator)
                    .append(",").append(i001_060_mode2CodeConfidenceIndicator)
                    .append(",").append(i001_030_Warning_errorConditions)
                    .toString();
        }
    }
}
