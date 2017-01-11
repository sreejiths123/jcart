/**
 * 
 */
package com.labs.lawcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
