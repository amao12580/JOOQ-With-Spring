package org.jooq.example;

import com.alibaba.fastjson.JSONReader;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/7/15
 * Time:14:04
 * <p>
 * fastJson  从文件读取  小例子
 */
public class JSONTest {
    @Test
    public void readJSONFromFile() throws FileNotFoundException {
        String fullPath = "D:\\GitHub\\JOOQ-With-Spring\\src\\test\\resource\\example.json";
        JSONReader jsonReader = new JSONReader(new FileReader(new File(fullPath)));
        jsonReader.startArray();
        List<Data> list = new ArrayList<>();
        while (jsonReader.hasNext()) {
            Data data = jsonReader.readObject(Data.class);
            if (data.getTitle().length() > 3) {
                continue;
            }
            list.add(data);
        }
        jsonReader.endArray();
        jsonReader.close();

        Collections.sort(list);
        int index = 1;
        for (Data data : list) {
            System.out.println(index + " " + data.getTitle() + "：" + data.getSmonth() + "月" + data.getSdate() + "日");
            index++;
        }
    }
}
