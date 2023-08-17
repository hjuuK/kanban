package models.works;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Work {
    private long workNo;
    private String gid = UUID.randomUUID().toString(); // 입력값이 없으면 랜덤하게 유니크 아이디를 만들도록 기본값 설정
    private long userNo;
    private String userNm;
    private Status status = Status.READY; // 기본값
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
