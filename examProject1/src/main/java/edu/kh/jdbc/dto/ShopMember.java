package edu.kh.jdbc.dto;

public class ShopMember {

	// 필드
	private String memberId;
	private String memberPw;
	private String phone;
	private String gender;

	//  생성자
	public ShopMember() {}
	
	
	public ShopMember(String memberId, String memberPw, String phone, String gender ) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phone = phone;
		this.gender = gender;
	}
	
	//getter/setter 문제 없음)
	public String getMemberId() { return memberId;}
	public void SetMemberId(String memberId) { this.memberId = memberId;}
	public String getMemberPw() { return memberPw;}
	public void SetMemberPw(String memberPw) { this.memberPw = memberPw;}
	public String getPhone() { return phone;}
	public void SetPhone(String phone) { this.phone = phone;}
	public String getGender() { return gender;}
	public void SetGender(String gender) { this.gender = gender;}

	@Override
	public String toString() {
		return memberId + ", " + memberPw +", " + phone + ", " + gender;
	}

}
