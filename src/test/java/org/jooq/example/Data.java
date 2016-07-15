package org.jooq.example;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/7/15
 * Time:14:22
 */
public class Data implements Comparable {
    String title;
    int smonth;
    int sdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSmonth() {
        return smonth;
    }

    public void setSmonth(int smonth) {
        this.smonth = smonth;
    }

    public int getSdate() {
        return sdate;
    }

    public void setSdate(int sdate) {
        this.sdate = sdate;
    }

    @Override
    public int compareTo(Object o) {
        Data data = (Data) o;
        if (this.getUniqueCode() == data.getUniqueCode()) {
            return 0;
        }
        if (this.getUniqueCode() > data.getUniqueCode()) {
            return 1;
        }
        return -1;
    }

    public int getUniqueCode() {
        return this.getSmonth() * 100 + this.getSdate();
    }
}
