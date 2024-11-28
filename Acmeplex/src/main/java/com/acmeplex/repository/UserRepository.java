package com.acmeplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acmeplex.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
	User findByUsername(String username);


}
