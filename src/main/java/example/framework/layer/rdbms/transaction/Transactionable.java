package example.framework.layer.rdbms.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface Transactionable <E>{
    @Transactional(propagation = Propagation.NESTED)
    public int add(E obj);
}
