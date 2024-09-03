package org.example.exo5.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo5.Repository.PatientRepository;

import java.io.IOException;

@WebServlet(name="patientServlet", value="/patient/*")
public class PatientServlet extends HttpServlet {
    private PatientRepository patientRepository;

    @Override
    public void init(ServletConfig config) {
        patientRepository = new PatientRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        System.out.println("action: " + action);
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
//                add(req,resp);
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
        System.out.println("showAll");
        req.setAttribute("dogs",patientRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/patient/list.jsp").forward(req,resp);
    }

}
