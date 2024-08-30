package edu.kh.jdbc.dao;

import java.io.IOException;

import edu.kh.jdbc.dto.User;
import edu.kh.jdbc.service.UserService;
import edu.kh.jdbc.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// 전달 받은 파라미터 얻어오기
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			int userNo 
				= Integer.parseInt(req.getParameter("userNo"));
			
			// 파라미터를 user 객체에 세팅
			User user = new User();
			user.setUserPw(userPw);
			user.setUserName(userName);
			user.setUserNo(userNo);
			
			UserService service = new UserServiceImpl();
			
			int result = service.updateUser(user);
			
			// 결과에 따라 메시지 지정
			
			String message = null;
			
			if(result > 0) message = "수정 성공";
			else 		   message = "수정 실패";
			
			// session에 message 세팅
			req.getSession().setAttribute("message", message);
			
			// 사용자 목록 리다이렉트
			
			resp.sendRedirect("/selectUser?userNo=" + userNo );
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
