package com.kyussfia.demo.repository;

import com.kyussfia.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	@SuppressWarnings("unused")
	Role findByName(String role);
}
