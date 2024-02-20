package org.jsoncompare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompareResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resultIdx;

    @Column(nullable = false, columnDefinition = "longtext")
    private String leftData;

    @Column(nullable = false, columnDefinition = "longtext")
    private String rightData;

    @Column(unique = true, nullable = false, columnDefinition = "longtext")
    private String encryptKey;

    @Builder
    public CompareResult(String leftData, String rightData, String encryptKey){

        this.leftData = leftData;
        this.rightData = rightData;
        this.encryptKey = encryptKey;

    }

}
