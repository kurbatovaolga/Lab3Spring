package org.example.Lab3Spring.сontrollers;


//import org.example.Lab3Spring.entity.Department;

import org.example.Lab3Spring.entity.Employee;
import org.example.Lab3Spring.repos.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public List<Employee> list() {
        return employeeRepo.findAll();
    }

    @GetMapping("{id}")
    public Employee getOne(@PathVariable ("id")Employee employee) {
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        employee.setCreationDate(LocalDateTime.now());
        return employeeRepo.save(employee);
    }

    @PutMapping("{id}")
    public Employee update(
            @PathVariable ("id") Employee employeefromDb,
            @RequestBody Employee employee) {
        BeanUtils.copyProperties(employee,employeefromDb,"id");

        return employeeRepo.save(employeefromDb);

    }

    @DeleteMapping("{id}")

    public void delete (@PathVariable ("id") Employee employee) {
        employeeRepo.delete(employee);
    }
}

//    @Autowired
//    private EmployeeRepo employeeRepo;

//    @GetMapping("/")
//    public String home(
//            @RequestParam(name="title",required = false,defaultValue = "Отдел Кадров")
//                    Map<String, Object> model) {
//
//        model.put("title", "Главная страница");
//        return "home";
//    }

    //}
//    @PostMapping
//    public String add(@RequestParam int personnelNumber, @RequestParam String lastName, @RequestParam String firstName, @RequestParam String middleName,
//                      @RequestParam int age, @RequestParam Department department, Map<String, Object> model){
//       Employee employee = new Employee (personnelNumber, lastName, firstName, middleName,  age, department);
//
//       employeeRepo.save(employee);
//        Iterable<Employee> employees = employeeRepo.findAll();
//        model.put("employees", employees);
//        return "main";
//    }
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model) {
//        Iterable<Employee> employees;
//        if (filter != null && !filter.isEmpty()) {
//            employees =employeeRepo.findByLastName(filter);
//        } else {
//            employees = employeeRepo.findAll();
//        }
//        model.put("employees",employees);
//        return "main";
//    }

