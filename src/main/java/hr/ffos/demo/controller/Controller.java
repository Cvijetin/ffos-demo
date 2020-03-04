package hr.ffos.demo.controller;

import hr.ffos.demo.domain.Student;
import hr.ffos.demo.repository.StudentRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//defines that this class is a controller
@org.springframework.stereotype.Controller
public class Controller {

    //student repository
    private final StudentRepository studentRepository;

    //constructor
    public Controller(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //open home(folder) and then template(index.html) when someone enters 'http://localhost:8080/'
    //path: resources/templates/home/index.html
    //HTTP method: GET -> we can use @GetMapping
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "hello/index";
    }


    //open bye(folder) and then template(index.html) when someone enters 'http://localhost:8080/bye'
    //path: resources/templates/bye/index.html
    //@RequestMapping without the 'method' definition mapps to any request(GET,POST,PUT,DELETE..)
    @RequestMapping(value = "/bye")
    public String bye(Model model){

        //get list of students and put it in the list named 'student'
        List<Student> student = studentRepository.findAll();

        //model the list of students into the variable name 'student' so we can access it on the front-end
        model.addAttribute("student", student);
        return "bye/index";
    }
}
