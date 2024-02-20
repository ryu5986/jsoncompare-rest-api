package org.jsoncompare.controller;

import lombok.RequiredArgsConstructor;
import org.jsoncompare.entity.CompareResult;
import org.jsoncompare.service.CompareResultService;
import org.jsoncompare.dto.CompareResultDTO;
import org.jsoncompare.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompareResultController {

    private final CompareResultService compareResultService;

    /**
     * 암호화 키로 1개 가져오기
     * @param encryptKey
     * @return
     */
    @GetMapping("/api/compareresult/{encryptKey}")
    public ResponseDTO<CompareResultDTO> getCompareResultByEncryptKey(@PathVariable String encryptKey) {
        CompareResult compareResult = compareResultService.getCompareResultByEncryptKey(encryptKey);

        CompareResultDTO res = null;

        if(compareResult != null){
            res = new CompareResultDTO(compareResult);
        }

        return new ResponseDTO<>("", res);
    }

    /**
     * 기록한 데이터 저장하기
     * @param compareResultDTO
     * @return
     */
    @PostMapping("/api/compareresult")
    public ResponseDTO<?> insertRecord(@RequestBody CompareResultDTO compareResultDTO) {

        String msg = "";
        String code = "";

        try {

            CompareResult compareResult = compareResultService.insertCompareResult(compareResultDTO);

            if (compareResult != null) {
                code = "00";
            } else {
                msg = "json data 저장 실패";
                code = "01";
            }

        }catch (Exception e){
            e.printStackTrace();
            msg = "json data 저장 실패";
            code = "01";
        }

        return new ResponseDTO<>(code, msg);
    }

}
