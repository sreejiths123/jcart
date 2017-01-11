/**
 * 
 */
package com.labs.lawcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.Role;

/**
 * @author Siva
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByName(String name);

}
