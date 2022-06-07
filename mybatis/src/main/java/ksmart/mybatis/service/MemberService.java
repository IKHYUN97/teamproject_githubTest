package ksmart.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;
import ksmart.mybatis.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	
	// DI (의존성 주입)
	// 1. 필드주입방식
	/**
	@Autowired
	private MemberMapper memberMapper;
	 * 
	 */
	
	// 2. setter 메소드 주입방식
	/**
	@Autowired
	private MemberMapper memberMapper;
	
	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	 * 
	 */
	
	// 3. 생성자 메소드 주입방식
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	
	
	
	
	public List<Member> getSearchMemberList(String searchKey,String searchValue){
		List<Member> searchMemberList = memberMapper.getSearchMemberList(searchKey, searchValue);
		return searchMemberList;
	}
	/*회원전체정보조회*/
	public List<Member> getMemberInfoList(){
		List<Member> memberInfoList = memberMapper.getMemberInfoList();
		return memberInfoList;
	}
	
	/**
	 * 판매자 정보 가져오기
	 */
	
	public List<Member> getSellerInfoList(){
		List<Member> sellerInfoList = memberMapper.getSellerInfoList();
		return sellerInfoList;
	}
	
	/**
	 * 회원탈퇴
	 */
	public boolean removeMember(String memberId, String memberPw) {
		
		boolean memberCheck = false;
		
		Member member = memberMapper.getMemberInfoById(memberId);
		
		if(member != null) {
			String memberPwCheck = member.getMemberPw();
			String memberLevel = member.getMemberLevel();
			
			if(memberPw.equals(memberPwCheck)) {
				memberCheck = true;
				//삭제 로직
				//등급별로 삭제
				//판매자
				if("2".equals(memberLevel)) {
					//1.tb_order (상품코드에 연관된 튜플삭제) 
					memberMapper.removeOrderByGCode(memberId);
					//2.tb_goods (판매자 등록한 상품 목록 삭제)
					memberMapper.removeGoodsById(memberId);
				}
				//구매자
				if("3".equals(memberLevel)) {
					//1. tb_order (구매자 구매한 주문내역 삭제)
					memberMapper.removeOrderById(memberId);
				}					
				//1. tb_login (회원이 로그한 이력 삭제)
				memberMapper.removeLoginHistoryById(memberId);
				//2. tb_member (회원 탈퇴)
				memberMapper.removeMemberById(memberId);
			}
			
		}
		
		return memberCheck;
	}
	
	/**
	 * 회원수정
	 */
	public int modifyMember(Member member) {
		
		int result = memberMapper.modifyMember(member);
		
		return result;
	}
	
	/**
	 * 회원 상세정보
	 */
	public Member getMemberInfoById(String memberId) {
		
		Member member = memberMapper.getMemberInfoById(memberId);
		
		return member; 
	}
	
	/**
	 * 회원가입
	 */
	public int addMember(Member member) {
		
		int result = memberMapper.addMember(member);
		
		return result;
	}
	
	/**
	 * 회원 등급 목록 조회
	 */
	public List<MemberLevel> getMemberLevelList(){
		
		List<MemberLevel> memberLevelList = memberMapper.getMemberLevelList();
		
		return memberLevelList;
	}
	
	
	/**
	 * 회원목록조회
	 * @return 회원목록(List<Member>)
	 */
	public List<Member> getMemberList(){
		
		List<Member> memberList = memberMapper.getMemberList();
		
		/**
		 * 관리자 :1, 판매자:2, 구매자:3
		 */
		if(memberList != null) {
			//향상된  for문
			for(Member member : memberList) {
				String memberLevel = member.getMemberLevel();
				if(memberLevel != null) {
					if("1".equals(memberLevel)) {
						member.setMemberLevel("관리자");
					}else if("2".equals(memberLevel)) {
						member.setMemberLevel("판매자");						
					}else if("3".equals(memberLevel)) {
						member.setMemberLevel("구매자");
					}else {
						member.setMemberLevel("일반회원");						
					}
				}
			}
		}
		
		return memberList;
	}
}
