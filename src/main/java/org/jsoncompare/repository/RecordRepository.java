package org.jsoncompare.repository;

import org.jsoncompare.entity.Record;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    Record findByEncryptKey(String encryptKey);
}
