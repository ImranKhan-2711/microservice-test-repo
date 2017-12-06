package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/*@Query("Select new com.veridian.dynamics.dto.UserDto(um.userMasterId as id, um.userId as username, "
			+ " um.contactMaster.firstName as firstName, um.contactMaster.lastName as lastName,um.password as password)"
			+ " from UserMaster um where um.price =:price")*/
	@Query("Select (p.id as id, p.name as name, "
			+ " p.price as price)"
			+ " from Product p where p.price =:price")
	public List<Product> findAllProductsForPrice(@Param("price") Double price);
}
