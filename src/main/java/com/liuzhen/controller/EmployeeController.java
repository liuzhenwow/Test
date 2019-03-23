package com.liuzhen.controller;

import com.liuzhen.dao.DepartmentDao;
import com.liuzhen.dao.EmployeeDao;
import com.liuzhen.entities.Department;
import com.liuzhen.entities.Employee;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@Log4j
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @GetMapping(value = "/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面前查询所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        log.info("来到员工列表页面");
        log.info(employee);
        employeeDao.save(employee);
        //redirect 重定向到一个地址
        //forward 转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id ,Model model){
        log.info(id+"员工修改");
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }

    @PutMapping("/emp")
    public String editPage(Employee employee){
        log.info(employee.getId()+"员工更新");
        log.info(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public  String deleteEmplyee(@PathVariable("id") Integer id){
        log.info(id+"员工删除");
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
