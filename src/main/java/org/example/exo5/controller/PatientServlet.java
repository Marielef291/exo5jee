package org.example.exo5.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo5.Repository.PatientRepository;
import org.example.exo5.entity.Patient;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="patientServlet", value="/patient/*")
public class PatientServlet extends HttpServlet {
    private PatientRepository patientRepository;

    @Override
    public void init() throws ServletException {
        patientRepository = new PatientRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        switch (action){
            case "list":
                // methode pour afficher la liste des chiens
                showAll(req,resp);
                break;
            case "addForm":
                // afficher la page avec le formulaire
//                showForm(req,resp);
                break;
            case "add":
                // post d'un nouveau chien
                add(req,resp);
                break;
            case "detail":
                // methode pour afficher le detail d'un chien
//                showDetails(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients",patientRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/patient/list.jsp").forward(req,resp);
    }

//    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/patient/add.jsp").forward(req,resp);
//    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //L'ajout ne se fait pas, certainement mauvaise action au niveua du formulaire
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));

        System.out.println(firstName + " " + lastName + " " + dateOfBirth);
        patientRepository.createOrUpdate(Patient.builder().firstName(firstName).lastName(lastName).dateOfBirth(dateOfBirth).build());

        System.out.println("Patient added to the repository");

        resp.sendRedirect("list");

    }

}
