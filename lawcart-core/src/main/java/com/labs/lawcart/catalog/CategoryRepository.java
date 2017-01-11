/**
 * 
 */
package com.labs.lawcart.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lawcart.entities.Category;

/**
 * @author Siva
 *
 */
public interface CategoryRepository  extends JpaRepository<Category, Integer>{

	Category getByName(String name);

}
