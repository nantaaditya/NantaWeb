package com.nanta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
