package com.visitormanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visitormanagement.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
	List<Visitor> findAll();
	
}
