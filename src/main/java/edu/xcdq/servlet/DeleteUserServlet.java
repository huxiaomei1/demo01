package edu.xcdq.servlet;

import edu.xcdq.bean.User;
import edu.xcdq.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId(1);
        userDao.delete(user);
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);




    }

}
