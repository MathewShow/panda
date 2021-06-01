package com.animal.panda.utils;

import com.animal.panda.pojo.Pig;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

    public static final int[] KEY = {1, 2, 3, 4};

    public static void main(String[] args) {

        /*System.out.println(0x12);
        System.out.println(00000001);*/


        //mathTest();

        /*String deviceData = "800001012386A72B16B625AC2420F07343DF7960ECEE8812FFA81D10D7A79E05030081";
        deviceData = deviceData.substring(10,deviceData.length()-2);
        deviceData = decryptData(deviceData, KEY);
        System.out.println(deviceData);*/

        //testBase64();


        //jsoToObject("");


        jsonArray("");



    }

    private static void jsonArray(String data){
        data = "{\n" +
                "\t\"notifyType\": \"deviceDatasChanged\",\n" +
                "\t\"requestId\": null,\n" +
                "\t\"deviceId\": \"c2a028ff-d651-48d1-841b-8beb2c142864\",\n" +
                "\t\"gatewayId\": \"c2a028ff-d651-48d1-841b-8beb2c142864\",\n" +
                "\t\"services\": [{\n" +
                "\t\t\"serviceId\": \"Status\",\n" +
                "\t\t\"serviceType\": \"Status\",\n" +
                "\t\t\"data\": {\n" +
                "\t\t\t\"FrequencyChannel\": 202,\n" +
                "\t\t\t\"DeviceType\": \"电信-移远\",\n" +
                "\t\t\t\"Version\": \"V1.60\",\n" +
                "\t\t\t\"SeriesNumber\": 15,\n" +
                "\t\t\t\"PastNumber\": 0,\n" +
                "\t\t\t\"DefenseStatus\": \"已设防\",\n" +
                "\t\t\t\"WellLidStatus\": \"复位\",\n" +
                "\t\t\t\"VoltageStatus\": \"正常\",\n" +
                "\t\t\t\"VoltageValue\": \"3.2V\",\n" +
                "\t\t\t\"SignalStatus\": \"正常\",\n" +
                "\t\t\t\"SignalValue\": \"15\",\n" +
                "\t\t\t\"WaterStauts\": \"正常\",\n" +
                "\t\t\t\"WaterValue\": \"1.0M\",\n" +
                "\t\t\t\"TempStauts\": \"正常\",\n" +
                "\t\t\t\"TempValue\": \"25℃\",\n" +
                "\t\t\t\"SNR\": \"0dBm\",\n" +
                "\t\t\t\"Time\": \"2019-08-20 14:42\"\n" +
                "\t\t},\n" +
                "\t\t\"eventTime\": \"20190820T064234Z\"\n" +
                "\t}],\n" +
                "\t\"appId\": \"yofEpynkKUC2oyvDIm2ujLEc_xMa\",\n" +
                "\t\"customFields\": []\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(data);
        String services = jsonObject.getString("services");
        System.out.println(services);
        JSONArray jsonArray = JSONArray.fromObject(services);
        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
        System.out.println(jsonArray);
        System.out.println("jsonObject1>>>>>>"+jsonObject1);
        String o = jsonArray.getString(0);
        System.out.println(o);
        JSONObject jsonObject2 = JSONObject.fromObject(o);
        System.out.println(jsonObject2.getString("serviceId"));
        String data1 = jsonObject2.getString("data");
        JSONObject jsonObject3 = JSONObject.fromObject(data1);
        System.out.println(jsonObject3.getString("Time"));

    }


    /**
     * 测试json转换
     * @param data
     */
    private static void jsoToObject(String data){

        data = "{ \"FrequencyChannel\": 198, \n" +
                "\"DeviceType\": \"电信-移远\", \n" +
                "\"Version\": \"V1.60\", \n" +
                "\"SeriesNumber\": 11,\n" +
                " \"PastNumber\": 0, \n" +
                " \"DefenseStatus\": \"已设防\", \n" +
                " \"WellLidStatus\": \"打开\",\n" +
                "  \"VoltageStatus\": \"正常\",\n" +
                "  \"VoltageValue\": \"3.2V\",\n" +
                "   \"SignalStatus\": \"正常\", \n" +
                "  \"SignalValue\": \"16\",\n" +
                "   \"WaterStauts\": \"正常\", \n" +
                "  \"WaterValue\": \"1.0M\", \n" +
                "  \"TempStauts\": \"正常\",\n" +
                "   \"TempValue\": \"25℃\", \n" +
                "   \"SNR\": \"85dBm\", \n" +
                "   \"Time\": \"2019-08-19 09:44\" }";

        JSONObject jsonObject = JSONObject.fromObject(data);


        System.out.println(jsonObject.getString("FrequencyChannel"));
        System.out.println(jsonObject.getString("DefenseStatus"));
        System.out.println(jsonObject.getString("WellLidStatus"));//井盖状态
        System.out.println(jsonObject.getString("VoltageStatus"));
        System.out.println(jsonObject.getString("SignalValue"));
        if (jsonObject.containsKey("charge")){
            System.out.println("charge>>>>> "+jsonObject.getString("charge"));
        }


    }

    /**
     * 测试char与int转换
     */
    public static void testBase64(){
        int n1 = 0;
        int n2 = 32;
        int n3 = 8;
        int n4 = 2;

        char c1 = (char)n1;

        char c = '0';
        System.out.println((int)c);
        System.out.println((int)'M');

        System.out.println((char)48);

        System.out.println((char)n1);
        System.out.println((char)n2);
        System.out.println((char)n3);
        System.out.println((char)n4);

    }

    public static void mathTest(){
        int num = (int) (Math.random() * 10);
        System.out.println(num);
    }

    public void beanUtilsTest(){
        Pig pig1 = new Pig();
        pig1.setName("旺财");
        pig1.setAge(123);
        pig1.setDesc("小猪");
        Pig pig2 = new Pig();
        BeanUtils.copyProperties(pig1,pig2);
        System.out.println(pig1.toString());
        System.out.println(pig2.toString());
    }

    public void simpleDateFormatTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));//2019-08-05 14:56:23

        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        System.out.println(sdf.format(new Date()));//2019-08-05 02:56:23 下午

        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");//
        System.out.println(sdf.format(new Date()));//2019-08-05 03:10:32 下午

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        System.out.println(sdf.format(new Date()));//2019-08-05 15:10:32:186

        sdf = new SimpleDateFormat("yyyy-MM-dd 一年中的第D天");
        System.out.println(sdf.format(new Date()));//2019-08-05 一年中的第217天

        sdf = new SimpleDateFormat("yyyy-MM-dd E");
        System.out.println(sdf.format(new Date()));//2019-08-05 星期一

        sdf = new SimpleDateFormat("yyyy-MM-dd M月中的第W个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 8月中的第2个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd M月中的第F个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 8月中的第1个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd 一年中的第w个星期");
        System.out.println(sdf.format(new Date()));//2019-08-05 一年中的第32个星期

        sdf = new SimpleDateFormat("yyyy-MM-dd z");
        System.out.println(sdf.format(new Date()));//2019-08-05 CST
    }

    /**
     * 解密
     *
     * @param value：加密的数据
     * @param k：加密的key
     * @return
     */
    public static String decryptData(String value, int[] k) {
        int[] intArray = stringToIntArray(value);
        // 将加密数据解密
        int[] v = decrypt(intArray, k);
        StringBuilder valueData = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            String hex = Integer.toHexString(v[i]);
            int length = hex.length();
            int c = 8 - length;
            if (length < 8) {
                for (int j = 0; j < c; j++) {
                    hex = "0" + hex;
                }
            }
            // 拼接成16进制数据
            valueData.append(hex);
        }
        String result = valueData.toString();
        return result;
    }



    /**
     * 字符串转int数组
     *
     * @param value
     * @return
     */
    public static int[] stringToIntArray(String value) {
        int len = value.length() / 8;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // 将字符串截取8位
            String subStr = value.substring(i * 8, (i + 1) * 8);
            try {
                // 将每条数据转为Long型
                Long parseLong = Long.parseLong(subStr, 16);
                // 加入数组
                result[i] = parseLong.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 解密
     *
     * @param v：输出数组；
     * @param k：加密的key
     * @return
     */
    public static int[] decrypt(int[] v, int[] k) {
        int n = v.length;
        int z = v[n - 1], y = v[0], sum, e, DELTA = 0x9e3779b9;
        int p;
        int q;
        q = 6 + 52 / n;
        sum = q * DELTA;
        while (sum != 0) {
            e = (sum >> 2) & 3;
            for (p = n - 1; p > 0; p--) {
                z = v[(p - 1)];
                y = v[p] -= (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4) ^ (sum ^ y) + (k[(p & 3 ^ e)] ^ z);
            }
            z = v[(n - 1)];
            y = v[0] -= (z >> 5 ^ y << 2) + (y >> 3 ^ z << 4) ^ (sum ^ y) + (k[(p & 3 ^ e)] ^ z);
            sum -= DELTA;
        }
        return v;
    }

}
