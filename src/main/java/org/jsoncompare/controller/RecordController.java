package org.jsoncompare.controller;

import lombok.RequiredArgsConstructor;
import org.jsoncompare.entity.Record;
import org.jsoncompare.service.RecordService;
import org.jsoncompare.vo.RecordVo;
import org.jsoncompare.vo.ResponseVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    /**
     * 암호화 키로 1개 가져오기
     * @param encryptKey
     * @return
     */
    @GetMapping("/api/record/{encryptKey}")
    public ResponseVo<RecordVo> getRecordByEncryptKey(@PathVariable String encryptKey) {
        Record record = recordService.getRecordByEncryptKey(encryptKey);

        RecordVo res = null;

        if(record != null){
            res = new RecordVo(record);
        }

        return new ResponseVo<>("", res);
    }

    /**
     * 기록한 데이터 저장하기
     * @param recordVo
     * @return
     */
    @PostMapping("/api/record")
    public ResponseVo<?> insertRecord(@RequestBody RecordVo recordVo) {

        Record record = recordService.insertRecord(recordVo);
        String msg = "";

        if (record != null) {
            msg = "json data 저장 완료";
        } else {
            msg = "json data 저장 실패";
        }

        return new ResponseVo<>(msg);
    }

}
