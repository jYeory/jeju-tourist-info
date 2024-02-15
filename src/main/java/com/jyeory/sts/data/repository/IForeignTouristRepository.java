package com.jyeory.sts.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jyeory.sts.data.entity.ForeignTourist;

@Repository
public interface IForeignTouristRepository extends JpaRepository<ForeignTourist, Integer> {

}
