package sec01.ex01;

import java.util.ArrayList;
import java.util.Date; // Date 사용
// import java.text.SimpleDateFormat; // 여기서는 직접적인 포맷팅 불필요 (VO가 Date를 받으므로)
import java.util.List;

public class MemberDAO {
    private List<MemberVO> membersList;

    public MemberDAO() {
        membersList = new ArrayList<>();
        // 초기 샘플 데이터 추가 (테스트용)
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // JSP 등에서 표시할 때 필요할 수 있음
        // MemberVO 생성 시 new Date()를 직접 전달
        membersList.add(new MemberVO("hong", "1234", "홍길동", "hong@example.com", new Date()));
        membersList.add(new MemberVO("lee", "5678", "이순신", "lee@example.com", new Date()));
        System.out.println("MemberDAO 생성자 호출 및 샘플 데이터 추가 완료 (joinDate는 Date 타입)");
    }

    // 모든 회원 정보를 조회하는 메소드
    public List<MemberVO> listMembers() {
        System.out.println("DAO: listMembers() 호출됨");
        return membersList;
    }

    // 회원 정보를 추가하는 메소드
    public void addMember(MemberVO memberVO) {
        // memberVO에 이미 joinDate가 Date 객체로 설정되어 넘어온다고 가정
        // 만약 Controller에서 Date 객체를 설정하지 않았다면 여기서 설정
        if (memberVO.getJoinDate() == null) {
            memberVO.setJoinDate(new Date()); // 현재 날짜로 설정
        }
        membersList.add(memberVO);
        System.out.println("DAO: addMember() 호출됨 - " + memberVO.getId() + " 추가");
    }

    // (선택) ID로 특정 회원 정보를 조회하는 메소드
    public MemberVO findMember(String _id) {
        for (MemberVO memVO : membersList) {
            if (memVO.getId().equals(_id)) {
                return memVO;
            }
        }
        return null;
    }

    // (선택) 회원 정보를 삭제하는 메소드
    public void delMember(String _id) {
        for (int i = 0; i < membersList.size(); i++) {
            MemberVO memVO = membersList.get(i);
            if (memVO.getId().equals(_id)) {
                membersList.remove(i);
                System.out.println("DAO: delMember() 호출됨 - " + _id + " 삭제");
                break;
            }
        }
    }

    // (선택) 회원 정보를 수정하는 메소드
    public void updateMember(MemberVO memberVO) {
        for (int i = 0; i < membersList.size(); i++) {
            MemberVO memVO = membersList.get(i);
            if (memVO.getId().equals(memberVO.getId())) {
                // joinDate가 null로 넘어오지 않도록 주의 (보통 수정 폼에서 기존 값을 유지하거나 새로 설정)
                if (memberVO.getJoinDate() == null && memVO.getJoinDate() != null) {
                    memberVO.setJoinDate(memVO.getJoinDate()); // 기존 날짜 유지
                }
                membersList.set(i, memberVO);
                System.out.println("DAO: updateMember() 호출됨 - " + memberVO.getId() + " 수정");
                break;
            }
        }
    }
}