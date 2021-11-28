package edu.xcdq.servlet;

import edu.xcdq.bean.User;
import edu.xcdq.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUserCode("userCode");
        user.setUserName("userName");
        user.setUserPassword("userPassword");
        user.setPhone("phone");
        user.setAddress("address");
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }
}
