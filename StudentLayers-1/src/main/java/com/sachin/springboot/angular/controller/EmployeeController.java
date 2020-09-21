package com.sachin.springboot.angular.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sachin.springboot.angular.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	private List<Employee> employees = createList();

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}
	
	@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Employee employee, 
    										UriComponentsBuilder ucBuilder,
    										BindingResult result ) throws ValidationException {
		if( result.hasErrors() ) {
			throw new ValidationException( "Employee has errors, cannot save employee...");
		}
 
		saveEmployee(employee);
        System.out.println("An Employee with name " + employee.getName() + " saved");
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	private void saveEmployee(Employee employee) {
		employees.add( employee );
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
//		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
//		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

}
