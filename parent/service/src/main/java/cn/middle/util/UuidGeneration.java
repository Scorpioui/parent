package cn.middle.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 生成UUID <br/>
 */
public class UuidGeneration {

    public static String getUUID() {
        String str  =  UUID.randomUUID().toString();
        return str.replaceAll("-", "");
    }
    
    //返回主键  主键格式：时间戳 + 随机数
    public static String uuidSubString()  {
        String str  =  System.currentTimeMillis()+"";
        return (str.replaceAll("-", ""))+(int)(Math.random()*(90));
    }
    
    public static String returnNowDate(){
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
        return formater.format(new Date());
    }
    
    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i ++){
            System.out.println(getUUID());
        }
    }
}
