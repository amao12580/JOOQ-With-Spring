package org.jooq.example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/9/29
 * Time:15:03
 */
@lombok.Data
public class MeizuBookmark {
    List<item> RECORDS;
    @lombok.Data
    class item{
        String title;
        String url;
    }
}
