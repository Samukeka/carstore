package br.com.carstore.servlet;

import  br.com.carstore.model.Car;
import  br.com.carstore.dao.CarDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet  {


    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String carName = httpServletRequest.getParameter("car-name");
        System.out.println(carName);
        Car car = new Car(carName);

        new CarDao().createCar(car);
        httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest, httpServletResponse);
    }
}
