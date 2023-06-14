package com.ibm.ecommerce.dao;

import com.ibm.ecommerce.entity.OrderDetail;
import com.ibm.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
    public List<OrderDetail> findByUser(User user);

    public List<OrderDetail> findByOrderStatus(String status);
}
