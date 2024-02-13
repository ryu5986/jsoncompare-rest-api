package org.jsoncompare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jsonIdx;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition = "longtext")
    private String leftData;

    @Column(nullable = false, columnDefinition = "longtext")
    private String rightData;

    @Builder
    public Record(String leftData, String rightData){
        this.leftData = leftData;
        this.rightData = rightData;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.subject = now.format(formatter);

    }

}
