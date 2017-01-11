/**
 * 
 */
package com.labs.lawcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.Permission;

/**
 * @author Siva
 *
 */
public interface PermissionRepository   extends JpaRepository<Permission, Integer>
{

}
