package org.jsoncompare.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jsoncompare.entity.CompareResult;
import org.jsoncompare.repository.CompareResultRepository;
import org.jsoncompare.dto.CompareResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompareResultService {

    public final CompareResultRepository compareResultRepository;

    @Transactional
    public CompareResult insertCompareResult(CompareResultDTO compareResultDTO){
        return compareResultRepository.save(compareResultDTO.toEntity());
    }


    public CompareResult getCompareResultByEncryptKey(String encryptKey){
        return compareResultRepository.findByEncryptKey(encryptKey);
    }
}
