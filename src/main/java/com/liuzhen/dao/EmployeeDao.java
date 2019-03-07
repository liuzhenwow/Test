package com.liuzhen.dao;

import com.liuzhen.entities.Department;
import com.liuzhen.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer,Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees =new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"E-AA","aa@163.com",1,new Department(101,"DD-AA"),"1990-01-09"));
        employees.put(1002,new Employee(1002,"E-BB","aa@163.com",1,new Department(102,"DD-BB"),"1990-01-09"));
        employees.put(1003,new Employee(1003,"E-CC","aa@163.com",1,new Department(103,"DD-CC"),"1990-01-09"));
        employees.put(1004,new Employee(1004,"E-DD","aa@163.com",1,new Department(104,"DD-DD"),"1990-01-09"));
        employees.put(1005,new Employee(1005,"E-EE","aa@163.com",1,new Department(105,"DD-EE"),"1990-01-09"));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){return employees.values();}

    public Employee get(Integer id ){return employees.get(id);}

    public void delete(Integer id ){employees.remove(id);}
}
