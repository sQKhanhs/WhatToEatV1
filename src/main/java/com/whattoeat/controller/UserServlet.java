package com.whattoeat.controller;

import com.whattoeat.model.Food;
import com.whattoeat.model.User;
import com.whattoeat.service.FoodService;
import com.whattoeat.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = {"/"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;
    private FoodService foodService;

    public void init() {
        userService = new UserService();
        foodService = new FoodService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher;

        String action = request.getParameter("action");
        if (action == null) {
            try {
                String wikipage = request.getParameter("wikipage");
                String wikisearch = request.getParameter("wikisearch");
                if(wikisearch == null) {
                    int index = Integer.parseInt(wikipage);
                    List<Food> foodList = foodService.pagingFood(index);
                    request.setAttribute("listFood", foodList);
                    pagination(request, response);
                    showLoginUser(request, response);
                    dispatcher = request.getRequestDispatcher("view/wiki.jsp");
                    dispatcher.forward(request, response);
                } else if(wikipage == null) {
                    updateUnsearchFoodlist(request, response);
                    updateSearchFood(request,response);
                    int index = Integer.parseInt(wikisearch);
                    List<Food> foodList = foodService.pagingFoodSearch(index);
                    request.setAttribute("listFood", foodList);
                    paginationSearchFood(request, response);
                    showLoginUser(request, response);
                    dispatcher = request.getRequestDispatcher("view/wikisearch.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            switch (action) {
                case "signup":
                    List<User> listUser = userService.selectAllUsers();
                    request.setAttribute("listUser", listUser);
                    dispatcher = request.getRequestDispatcher("view/signup.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "main":
                    updateUserLogin(request,response);
                    dispatcher = request.getRequestDispatcher("view/main.jsp");
                    showLoginUser(request,response);
                    dispatcher.forward(request, response);
                    break;
                case "login":
                    updateUserLogout(request, response);
                    dispatcher = request.getRequestDispatcher("view/login.jsp");
                    listUser = userService.selectAllUsers();
                    request.setAttribute("listUser", listUser);
                    dispatcher.forward(request, response);
                    break;
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            try {
                String wikipage = request.getParameter("wikipage");
                String wikisearch = request.getParameter("wikisearch");
                if(wikisearch == null) {
                    int index = Integer.parseInt(wikipage);
                    List<Food> foodList = foodService.pagingFood(index);
                    request.setAttribute("listFood", foodList);
                    pagination(request, response);
                    showLoginUser(request, response);
                    dispatcher = request.getRequestDispatcher("view/wiki.jsp");
                    dispatcher.forward(request, response);
                } else if(wikipage == null) {
                    updateUnsearchFoodlist(request, response);
                    updateSearchFood(request,response);
                    int index = Integer.parseInt(wikisearch);
                    List<Food> foodList = foodService.pagingFoodSearch(index);
                    request.setAttribute("listFood", foodList);
                    paginationSearchFood(request, response);
                    showLoginUser(request, response);
                    dispatcher = request.getRequestDispatcher("view/wikisearch.jsp");
                    dispatcher.forward(request, response);
                    response.sendRedirect("view/wikisearch.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
        switch (action) {
            case "main":
                updateUserLogin(request,response);
                dispatcher = request.getRequestDispatcher("view/main.jsp");
                showLoginUser(request,response);
                dispatcher.forward(request, response);
                break;
            case "login":
                updateUserLogout(request, response);
                insertUser(request,response);
                List<User> listUser = userService.selectAllUsers();
                request.setAttribute("listUser", listUser);
                dispatcher = request.getRequestDispatcher("view/login.jsp");
                dispatcher.forward(request, response);
                break;
        }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("sent user data");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User newUser = new User(username, email, password);
        userService.insertUser(newUser);
    }
    private void updateUserLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("update user data login");
        String email = request.getParameter("email");
        User user = new User(email);
        userService.updateUserLogin(user);
    }

    private void updateUserLogout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("update user data logout");
        userService.updateUserLogout();
    }

    private void showLoginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String email = request.getParameter("username");
        User loginUser = userService.selectLoginUser(email);
        request.setAttribute("user", loginUser);
    }

    private void updateSearchFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("update food search data");
        String foodname = request.getParameter("foodname");
        if(foodname != "") {
            Food food = new Food(foodname);
            foodService.updateSearchFood(food);
        }
    }
    private void updateUnsearchFoodlist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("update food search data");
        foodService.updateUnsearchFoodList();
    }
    private void pagination(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
        int count = foodService.getTotalFood();
        int endPage = count/4;
        if(count % 4 != 0){
            endPage++;
        }
        request.setAttribute("endP", endPage);
    }
    private void paginationSearchFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int count = foodService.getTotalFoodSearch();
        int endPage = count/4;
        if(count % 4 != 0){
            endPage++;
        }
        request.setAttribute("endP", endPage);
    }
}