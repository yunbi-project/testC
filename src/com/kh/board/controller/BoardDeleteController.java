package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.bo")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭세 성공시 list페이지로 이동
		
		BoardService bService = new BoardService();
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		Attachment at = bService.selectAttachment(boardNo);

		int result = bService.deleteBoard(boardNo);
		
		if(result > 0) {
			
			if(at !=null) {
				String savePath = request.getSession().getServletContext().getRealPath("/"+at.getFilePath());
				
				new File("/"+at.getFilePath()+at.getChangeName()).delete();
			}
			request.getSession().setAttribute("alertMsg", "성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}else {
			request.setAttribute("errorMsg", "게시글 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
