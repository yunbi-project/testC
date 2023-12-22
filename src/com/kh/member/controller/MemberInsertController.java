package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/enroll.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/member/memberEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1) 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
//		2) 요청시 전달값을 뽑아서 변수 및 객체에 기록하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("eamil");
		String address = request.getParameter("address");
		String[] interestArr = request.getParameterValues("interest");
		
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
//		매개변수 있는 생성자를 이용해서 Member 객체 만들어보기
		Member m = new Member(userId, userPwd, userName, phone, email, address, interest);
		
//		회원가입 요청 처리
		int result = new MemberService().insertMember(m);
		
//		처리결과(result)를 가지고 사용자가 보게될 응답화면 지정
		if(result > 0) {	// 회원가입 정상처리됨
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다");
			
			response.sendRedirect(request.getContextPath());
		} else {	// 회원가입 실패
			request.setAttribute("errorMsg", "회원가입에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}
}