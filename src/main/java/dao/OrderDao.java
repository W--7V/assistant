package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, String>{

}
