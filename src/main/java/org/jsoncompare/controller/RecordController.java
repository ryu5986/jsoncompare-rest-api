package org.jsoncompare.controller;

import lombok.RequiredArgsConstructor;
import org.jsoncompare.entity.Record;
import org.jsoncompare.service.RecordService;
import org.jsoncompare.vo.AjaxVo;
import org.jsoncompare.vo.RecordVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    /**
     * 기록한 데이터 목록 가져오기
     * @return
     */
    @GetMapping("/api/record")
    public ResponseEntity<AjaxVo<List<RecordVo>>> getRecordList() {
        List<RecordVo> recordVoList = recordService.getRecordList().stream().map(RecordVo::new).toList();
        return ResponseEntity.ok().body(new AjaxVo<>("",recordVoList));
    }

    /**
     * 기록한 데이터 1개 가져오기
     * @param jsonIdx
     * @return
     */
    @GetMapping("/api/record/{jsonIdx}")
    public ResponseEntity<AjaxVo<RecordVo>> getRecord(@PathVariable long jsonIdx) {
        Record record = recordService.getRecord(jsonIdx);
        return ResponseEntity.ok().body(new AjaxVo<>("", new RecordVo(record)));
    }

    /**
     * 암호화 키로 1개 가져오기
     * @param recordVo
     * @return
     */
    @PostMapping("/api/record/encryptkey")
    public ResponseEntity<AjaxVo<RecordVo>> getRecordByEncryptKey(@RequestBody RecordVo recordVo) {
        Record record = recordService.getRecordByEncryptKey(recordVo.getEncryptKey());

        RecordVo res = null;

        if(record != null){
            res = new RecordVo(record);
        }

        return ResponseEntity.ok().body(new AjaxVo<>("", res));
    }

    /**
     * 기록한 데이터 저장하기
     * @param recordVo
     * @return
     */
    @PostMapping("/api/record")
    public ResponseEntity<AjaxVo<?>> insertRecord(@RequestBody RecordVo recordVo) {
        System.out.println("@@@@");
        System.out.println(recordVo.getEncryptKey());
        Record record = recordService.insertRecord(recordVo);
        HttpStatus status = null;
        String msg = "";

        if (record != null) {
            status = HttpStatus.CREATED;
            msg = "json data 저장 완료";
        } else {
            status = HttpStatus.NO_CONTENT;
            msg = "json data 저장 실패";
        }

        return ResponseEntity.status(status).body(new AjaxVo<>(msg));
    }

    /**
     * 기록한 데이터 삭제
     * @param jsonIdx
     * @return
     */
    @DeleteMapping("/api/record/{jsonIdx}")
    public ResponseEntity<AjaxVo<?>> deleteRecord(@PathVariable long jsonIdx) {

        HttpStatus status = null;
        String msg = "";

        Record record = recordService.getRecord(jsonIdx);

        if (record != null) {
            recordService.deleteRecord(jsonIdx);
            status = HttpStatus.OK;
            msg = "해당 json data 삭제 완료";
        } else {
            status = HttpStatus.NO_CONTENT;
            msg = "해당 json data 삭제 실패";
        }

        return ResponseEntity.status(status).body(new AjaxVo<>(msg));

    }

}
