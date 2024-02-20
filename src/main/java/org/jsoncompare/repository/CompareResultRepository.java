package org.jsoncompare.repository;

import org.jsoncompare.entity.CompareResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompareResultRepository extends JpaRepository<CompareResult, Long> {

    CompareResult findByEncryptKey(String encryptKey);
}
