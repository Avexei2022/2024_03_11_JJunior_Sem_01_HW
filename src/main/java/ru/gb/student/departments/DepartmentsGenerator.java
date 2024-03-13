package ru.gb.student.departments;

public class DepartmentsGenerator {
    public DepartmentsList createDepartments(int amount) {
        DepartmentsList departmentList = new DepartmentsList();
        for (int i = 0; i < amount; i++) {
            departmentList.addDepartment(new Department("Department №" + (i + 1)));
        }
        return departmentList;
    }
}
