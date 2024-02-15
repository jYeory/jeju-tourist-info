package com.jyeory.sts.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jyeory.sts.data.entity.DomesticTourist;

@Repository
public interface IDomesticTouristRepository extends JpaRepository<DomesticTourist, Integer> {

}
