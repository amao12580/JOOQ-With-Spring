package example.business.layer.order.bo;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderBo {
    int uid;
    long amout;
    int status;
    long order_time;
}
