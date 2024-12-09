package org.example.web_lab4.DAO;

import org.example.web_lab4.model.Car;
import org.example.web_lab4.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO {
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public DatabaseDAO(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public List<Car> fetchCars() throws SQLException {
        String sql = "SELECT id, name, brand, price FROM car";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                cars.add(new Car(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getBigDecimal("price")));
            }
            return cars;
        }
    }

    public List<Customer> fetchCustomers() throws SQLException {
        String sql = "SELECT id, name, email FROM customer";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
            return customers;
        }
    }

    public void addCar(String name, String brand, BigDecimal price) throws SQLException {
        String sql = "INSERT INTO car (name, brand, price) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, brand);
            stmt.setBigDecimal(3, price);
            stmt.executeUpdate();
        }
    }

    public void addCustomer(String name, String email) throws SQLException {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }

    public void updateCar(int id, String name, String brand, BigDecimal price) throws SQLException {
        String sql = "UPDATE car SET name = ?, brand = ?, price = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, brand);
            stmt.setBigDecimal(3, price);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void updateCustomer(int id, String name, String email) throws SQLException {
        String sql = "UPDATE customer SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void deleteCar(int id) throws SQLException {
        String sql = "DELETE FROM car WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
