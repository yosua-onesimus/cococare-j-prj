package without_cococare.use_pure_sql.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import without_cococare.use_pure_sql.model.obj.Employee;

public class EmployeeDao {

    public List<Employee> getList() {
        List<Employee> employees = new ArrayList();
        ResultSet resultSet = Database.executeQuery("SELECT * FROM employees");
        try {
            while (resultSet.next()) {
                Employee employee = new Employee();
//<editor-fold desc=" expansion area ">
                employee.setId(resultSet.getLong("id"));
                employee.setCode(resultSet.getString("code"));
                employee.setName(resultSet.getString("name"));
//</editor-fold>
                employees.add(employee);
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return employees;
    }

    public Employee getById(Long id) {
        Employee employee = new Employee();
        ResultSet resultSet = Database.executeQuery("SELECT * FROM employees WHERE id = '" + id + "'");
        try {
            while (resultSet.next()) {
//<editor-fold desc=" expansion area ">
                employee.setId(resultSet.getLong("id"));
                employee.setCode(resultSet.getString("code"));
                employee.setName(resultSet.getString("name"));
//</editor-fold>
            }
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return employee;
    }

    public boolean saveOrUpdate(Employee employee) {
        if (employee.getId() == null) {
//<editor-fold desc=" expansion area ">
            return Database.executeUpdate("INSERT INTO employees (id, code, name) VALUES (0, '" + employee.getCode() + "', '" + employee.getName() + "')");
//</editor-fold>
        } else {
//<editor-fold desc=" expansion area ">
            return Database.executeUpdate("UPDATE employees SET code = '" + employee.getCode() + "', name = '" + employee.getName() + "' WHERE id = '" + employee.getId() + "'");
//</editor-fold>
        }
    }

    public boolean delete(Employee employee) {
        return Database.executeUpdate("DELETE FROM employees WHERE id = '" + employee.getId() + "'");
    }
}