package org.example.web_lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web_lab4.DAO.DatabaseDAO;
import org.example.web_lab4.model.Car;
import org.example.web_lab4.model.Customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private DatabaseDAO databaseDAO;

    @Override
    public void init() throws ServletException {
        String dbUrl = "jdbc:postgresql://localhost:5432/Web_Lab4";
        String dbUser = "postgres";
        String dbPassword = "postgres";

        databaseDAO = new DatabaseDAO(dbUrl, dbUser, dbPassword);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "addCar" -> databaseDAO.addCar(
                        request.getParameter("name"),
                        request.getParameter("brand"),
                        new BigDecimal(request.getParameter("price"))
                );
                case "addCustomer" -> databaseDAO.addCustomer(
                        request.getParameter("name"),
                        request.getParameter("email")
                );
                case "updateCar" -> databaseDAO.updateCar(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("brand"),
                        new BigDecimal(request.getParameter("price"))
                );
                case "updateCustomer" -> databaseDAO.updateCustomer(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("email")
                );
                case "deleteCar" -> databaseDAO.deleteCar(Integer.parseInt(request.getParameter("id")));
                case "deleteCustomer" -> databaseDAO.deleteCustomer(Integer.parseInt(request.getParameter("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Car> cars = databaseDAO.fetchCars();
            List<Customer> customers = databaseDAO.fetchCustomers();

            request.setAttribute("cars", cars);
            request.setAttribute("customers", customers);

            request.getRequestDispatcher("read.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
