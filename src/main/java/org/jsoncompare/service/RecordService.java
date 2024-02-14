package org.jsoncompare.service;

import lombok.RequiredArgsConstructor;
import org.jsoncompare.entity.Record;
import org.jsoncompare.repository.RecordRepository;
import org.jsoncompare.vo.RecordVo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    public final RecordRepository recordRepository;

    public List<Record> getRecordList(){

        Sort sort = Sort.by(Sort.Direction.DESC, "jsonIdx");
        return recordRepository.findAll(sort);
    }

    public Record getRecord(long jsonIdx){
        return recordRepository.findById(jsonIdx)
                .orElseThrow(() -> new IllegalArgumentException("not fount: " + jsonIdx));
    }

    public Record insertRecord(RecordVo recordVo){
        return recordRepository.save(recordVo.toEntity());
    }

    public void deleteRecord(long jsonIdx){
        recordRepository.deleteById(jsonIdx);
    }

    public Record getRecordByEncryptKey(String encryptKey){
        return recordRepository.findByEncryptKey(encryptKey);
    }
}
