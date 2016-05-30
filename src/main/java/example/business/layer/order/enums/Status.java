package example.business.layer.order.enums;


import lombok.Getter;

public enum Status {
    CREATE((byte) 0, "创建");

    @Getter
    byte value;
    String desc;

    Status(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}