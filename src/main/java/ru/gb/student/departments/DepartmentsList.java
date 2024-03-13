package ru.gb.student.departments;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentsList {
    private final List<Department> departmentList = new ArrayList<>();

    public void addDepartment(Department department) {
         if (!departmentList.contains(department))
             departmentList.add(department);
    }


}
