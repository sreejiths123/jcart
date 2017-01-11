/**
 * 
 */
package com.labs.lawcart.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.Order;

/**
 * @author Siva
 *
 */
public interface OrderRepository  extends JpaRepository<Order, Integer>
{
	Order findByOrderNumber(String orderNumber);
}
