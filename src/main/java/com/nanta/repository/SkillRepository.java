package com.nanta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanta.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{

}
