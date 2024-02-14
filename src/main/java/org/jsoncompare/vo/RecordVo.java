package org.jsoncompare.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoncompare.entity.Record;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecordVo {

    private long jsonIdx;
    private String subject;
    private String leftData;
    private String rightData;
    private String encryptKey;

    public Record toEntity(){
        return Record.builder().leftData(leftData).rightData(rightData).encryptKey(encryptKey).build();
    }

    public RecordVo(Record record){
        this.jsonIdx = record.getJsonIdx();
        this.subject = record.getSubject();
        this.leftData = record.getLeftData();
        this.rightData = record.getRightData();
        this.encryptKey = record.getEncryptKey();
    }
}
