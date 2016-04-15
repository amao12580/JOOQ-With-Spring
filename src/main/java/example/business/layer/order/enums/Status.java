package example.business.layer.order.enums;


import lombok.Getter;

public enum Status {
    CREATE(0,"创建");

    @Getter
    int value;
    String desc;

    Status(int value,String desc){
        this.value=value;
        this.desc=desc;
    }
}