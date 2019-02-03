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
        employees.put(1001,new Employee(1001,"E-AA","aa@163.com",1,new Department(101,"DD-AA")));
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
