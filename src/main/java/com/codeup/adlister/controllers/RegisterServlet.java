package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //ensure that only new usernames are registered.
        boolean emailDoesNotExist = false;
        boolean fieldsNotNull = false;
        boolean fieldsNotEmpty = false;
        if(username != null && email != null && password != null){
            fieldsNotNull = true;
        }
        if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            fieldsNotEmpty = true;
        }
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information

        if(fieldsNotNull && fieldsNotEmpty){
            //create a user with usersDao
            User userToCreate = new User(username, email, password);
            DaoFactory.getUsersDao().insert(userToCreate);
        }
        // TODO: if a user was successfully created, send them to their profile
        response.sendRedirect("/profile");
    }
}
