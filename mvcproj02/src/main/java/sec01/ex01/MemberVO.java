package sec01.ex01;

import java.util.Date; // Date 클래스 import

public class MemberVO {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date joinDate; // 타입을 Date로 변경

    // 기본 생성자
    public MemberVO() {
        System.out.println("MemberVO 기본 생성자 호출");
    }

    // Date 타입을 받는 생성자로 변경
    public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate; // Date 타입이므로 직접 할당
        System.out.println("MemberVO(String*4, Date) 생성자 호출 - ID: " + id + ", JoinDate: " + joinDate);
    }

    // Getter 및 Setter도 Date 타입으로 변경
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getJoinDate() { // 반환 타입 Date로 변경
        return joinDate;
    }
    public void setJoinDate(Date joinDate) { // 파라미터 타입 Date로 변경
        this.joinDate = joinDate;
    }
}