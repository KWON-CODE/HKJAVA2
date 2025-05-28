package sec01.ex01;

import java.sql.Date;

public class MemberVO {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date joinDate;

    public MemberVO() {
        // System.out.println("MemberVO 생성자 호출"); // 디버깅용이므로 필요시 주석 해제
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}