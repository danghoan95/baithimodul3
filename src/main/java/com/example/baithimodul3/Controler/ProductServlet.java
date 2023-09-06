package com.example.baithimodul3.Controler;

import com.example.baithimodul3.DAO.ClassroomDAO;
import com.example.baithimodul3.model.Classroom;
import com.example.baithimodul3.model.Student;
import com.example.baithimodul3.service.ClassRoomservice;
import com.example.baithimodul3.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private StudentService studentService;
    List<Classroom> classroomList;
    ClassRoomservice classRoomservice;
    ClassroomDAO classroomDAO ;


    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
        classRoomservice = new ClassRoomservice();
        classroomList = new ArrayList<>();
        classroomDAO =new ClassroomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
              display(request,response);
                break;
            case "create":
                getCreate(request, response);
                break;
            case "update":
                getUpdate(request, response);
                break;
            case "delete":
                getdelete(request, response);
                break;
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                postCreate(request, response);
                break;
            case "update":
                postUpdate(request, response);
                break;
            case "search":
                searchName(request, response);
                break;
    }
    }
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        RequestDispatcher rq = request.getRequestDispatcher("display.jsp");
        rq.forward(request, response);
    }

    public void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        classroomList = classroomDAO.findAll();
        request.setAttribute("classroomList", classroomList);
        RequestDispatcher rq = request.getRequestDispatcher("create.jsp");
        rq.forward(request, response);
    }

    public void postCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email =request.getParameter("email");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String address = request.getParameter("address");
        double phone = Double.parseDouble(request.getParameter("phone"));
        int class_id = Integer.parseInt(request.getParameter("classroom"));
        Student student = new Student(name, email, date,address,phone,classRoomservice.findOne(class_id));
        studentService.create(student);
        response.sendRedirect("products");

    }

    public void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findOne(id);
        request.setAttribute("student", student);
        classroomList = classRoomservice.findAll();
        request.setAttribute("classroomList", classroomList);
        RequestDispatcher rq = request.getRequestDispatcher("update.jsp");
        rq.forward(request, response);
    }

    public void postUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email =request.getParameter("email");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String address = request.getParameter("address");
        double phone = Double.parseDouble(request.getParameter("phone"));
        int class_id = Integer.parseInt(request.getParameter("classroom"));
        Student student = new Student(name, email, date,address,phone,classRoomservice.findOne(class_id) );
        student.setId(id);
        studentService.update(student);
        response.sendRedirect("products");
    }

    public void getdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("products");
    }
    public void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Student> students = studentService.searchName(name);
        request.setAttribute("students", students);
        RequestDispatcher rq = request.getRequestDispatcher("display.jsp");
        rq.forward(request, response);
}
}