package com.kh.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	/**
	 * 로그인 요청 서비스
	 * @param userId => 사용자가 입력한 아이디값
	 * @param userPwd => 사용자가 입력한 비밀번호값
	 * @return 사용자가 입력한 값과 일치되는 Member 객체
	 */
	public Member loginMember(String userId, String userPwd) {
//		1) 커넥션 생성
		Connection conn = getConnection();
		
//		2) 커넥션 전달
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
//		3) 커넥션 반납
		close(conn);
		
//		4) 결과값 반납
		return m;
	}

	/**
	 * 회원가입 서비스
	 * @param m => 회원가입할 회원의 정보를 담은 객체
	 * @return => 처리된 행의 갯수
	 */
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/**
	 * 회원정보 수정 서비스
	 * @param m 원래 회원 정보
	 * @return 변경된 회원정보가 반영된 회원 객체
	 */
	public Member updateMember(Member m) {
//		1) 내정보 수정
		Connection conn = getConnection();
		
//		2) 정보변경 성공시 commit + 변경된 회원정보 조회 / 실패시 rollback
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {	// 내정보 변경 성공
			commit(conn);
			
//			갱신된 회원객체 다시 조회해오기
			m = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		return m;
	}

	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int changePassword(String userId, String updatePwd) {
		int result = 0;
		
		return result;
	}

	public int idCheck(String checkId) {
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}

}