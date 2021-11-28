package edu.xcdq.servlet;

import edu.xcdq.bean.User;
import edu.xcdq.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectUserServlet", value = "/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> users = userDao.getNewsList();
            request.setAttribute("users" , users);
            request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
        }
    }

