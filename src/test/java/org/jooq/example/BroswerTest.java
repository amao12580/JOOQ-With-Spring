package org.jooq.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/9/29
 * Time:15:00
 * <p>
 * fastJson  解析魅族浏览器书签jaon文件，输出via浏览可导入的结构，整理为jaon文件
 */
public class BroswerTest {
    @Test
    public void readJSONFromFile() throws FileNotFoundException {
        String fullPath = "C:\\Users\\Administrator\\Desktop\\bookmarks3.json";
        JSONReader jsonReader = new JSONReader(new FileReader(new File(fullPath)));
        MeizuBookmark meizuBookmark = jsonReader.readObject(MeizuBookmark.class);
        jsonReader.close();
        System.out.println("meizuBookmark:" + JSON.toJSONString(meizuBookmark));
        if (meizuBookmark == null || meizuBookmark.getRECORDS() == null || meizuBookmark.getRECORDS().isEmpty()) {
            System.out.println("解码失败，或源文件没有书签");
            return;
        }
        int index = 0;
        int seq = 0;
        System.out.println("完成解码，开始解析书签.");
        List<ViaBookmark> results=new ArrayList<>();
        for (MeizuBookmark.item item : meizuBookmark.getRECORDS()) {
            index++;
            System.out.println("第" + index + "条书签：" + JSON.toJSONString(item));
            if(item.getTitle()==null||item.getTitle().isEmpty()||item.getUrl()==null||item.getUrl().isEmpty()){
                System.out.println("数据不完整，跳过处理.");
                continue;
            }
            results.add(new ViaBookmark(item.getTitle(),item.getUrl(),seq));
            seq++;
        }
        System.out.println("viaBookmark:");
        for(ViaBookmark viaBookmark:results){
            System.out.println(JSON.toJSONString(viaBookmark));
        }
        System.out.println("完成解析书签.");
    }
}
