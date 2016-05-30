package example.business.layer.user.service.impl;

import example.business.layer.user.service.UserService;
import example.dao.layer.rdbms.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    /**
     * 更新用户的订单量
     *
     * @param userId   用户Id
     * @param orderNum 需要增加的订单数
     * @return 处理结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateOrderSum(int userId, int orderNum) {

        return userDao.updateOrderSum(userId, orderNum);
    }
}
