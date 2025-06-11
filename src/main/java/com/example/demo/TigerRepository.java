package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TigerRepository extends JpaRepository<tiger,Long> {
    List<tiger> getTigersByHabitatRegion(String habitatRegion);

    @Query(value = "SELECT * From tigers t where t.subspecies = ?1" , nativeQuery = true)
    List<tiger> getTigersBySubspecies(String subspecies);

    @Query(value = "SELECT * FROM tigers t WHERE t.name LIKE %?1%", nativeQuery = true)
    List<tiger> getTigersByName(String name);
}

