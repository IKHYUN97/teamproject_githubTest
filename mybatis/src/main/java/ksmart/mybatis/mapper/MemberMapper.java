package ksmart.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;

@Mapper
public interface MemberMapper {
	//회원목록조회(복잡한결과맵핑 has one: association)
	public List<Member> getMemberInfoList();
	
	//판매자 목록조회(복잡한 결과맵핑 has many관계 : collection)
	public List<Member> getSellerInfoList();
	
	
	//회원검색
	public List<Member> getSearchMemberList(String searchKey,String searchValue);

	//tb_order (상품코드에 연관된 튜플삭제) join - 판매자
	public int removeOrderByGCode(String memberId);
	
	//tb_goods (판매자 등록한 상품 목록 삭제) - 판매자
	public int removeGoodsById(String memberId);
	
	//tb_order (구매자 구매한 주문내역 삭제) - 구매자
	public int removeOrderById(String memberId);
	
	//tb_login (회원이 로그인한 이력 삭제) - 회원
	public int removeLoginHistoryById(String memberId);
	
	//tb_member (회원 탈퇴) - 회원
	public int removeMemberById(String memberId);
	
	// 회원 수정
	public int modifyMember(Member member);
	
	// 회원 상세정보 조회
	public Member getMemberInfoById(String memberId);
	
	// 회원 등록
	public int addMember(Member member);

	// 회원목록조회
	public List<Member> getMemberList();
	
	// 회원등급 조회
	public List<MemberLevel> getMemberLevelList();
	
}
