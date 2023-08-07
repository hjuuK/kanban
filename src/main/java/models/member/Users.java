package models.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Users {
    private long userNo; // 회원번호
    private String userId; // 아이디
    private String userPw; // 비밀번호
    private String userNm; // 사용자명
    private String email; // 이메일
    private String mobile; // 전화번호
    private LocalDateTime regDt; // 가입일자
    private LocalDateTime modDt; // 수정일자
}
