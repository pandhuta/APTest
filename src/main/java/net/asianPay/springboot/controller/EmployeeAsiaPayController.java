package net.asianPay.springboot.controller;


import net.asianPay.springboot.entity.EmployeeAsiaPay;
import net.asianPay.springboot.exception.ResourceNotFoundException;
import net.asianPay.springboot.repository.EmployeeAsiaPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("http://dummy.restapiexample.com/api/v1/employees")
public class EmployeeAsiaPayController {

    @Autowired
    EmployeeAsiaPayRepository employeeAsiaPayRepository;

    @GetMapping
    public List<EmployeeAsiaPay> getAllEmployee() {
        return this.employeeAsiaPayRepository.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeAsiaPay getEmployeeById(@PathVariable(value = "id") long employeeId) {
        return this.employeeAsiaPayRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + employeeId));
    }

    @PostMapping("/create")
    public EmployeeAsiaPay employeeGlobal(@RequestBody EmployeeAsiaPay employeeAsiaPay) {
        return this.employeeAsiaPayRepository.save(employeeAsiaPay);
    }

    @PutMapping("/update/{id}")
    public EmployeeAsiaPay employeeGlobal(@RequestBody EmployeeAsiaPay payChanged, @PathVariable ("id") long employeeId) {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        java.util.Date utilDate = new java.util.Date();

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        EmployeeAsiaPay existingEmployee = this.employeeAsiaPayRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + employeeId));
        existingEmployee.setName(payChanged.getName());
        existingEmployee.setAge(payChanged.getAge());
        existingEmployee.setCompany(payChanged.getCompany());
        existingEmployee.setBranch(payChanged.getBranch());
        existingEmployee.setCreateAt(date);
        return this.employeeAsiaPayRepository.save(existingEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeAsiaPay> deleteEmployee(@PathVariable ("id") long EmployeeId){
        EmployeeAsiaPay existingEmployee = this.employeeAsiaPayRepository.findById(EmployeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + EmployeeId));
        this.employeeAsiaPayRepository.delete(existingEmployee);
        return ResponseEntity.ok().build();
    }
}
