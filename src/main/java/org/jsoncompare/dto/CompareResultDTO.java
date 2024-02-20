package org.jsoncompare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoncompare.entity.CompareResult;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompareResultDTO {

    private long resultIdx;
    private String leftData;
    private String rightData;
    private String encryptKey;

    public CompareResult toEntity(){

        return CompareResult.builder().leftData(leftData).rightData(rightData).encryptKey(encryptKey).build();

    }

    public CompareResultDTO(CompareResult compareResult){

        this.resultIdx = compareResult.getResultIdx();
        this.leftData = compareResult.getLeftData();
        this.rightData = compareResult.getRightData();
        this.encryptKey = compareResult.getEncryptKey();

    }
}
