package with_cococare.use_pure_sql.model.dao;

import cococare.database.CCDatabase;
import cococare.database.CCDatabaseDao;
import with_cococare.use_pure_sql.console.Main;
import with_cococare.use_pure_sql.model.obj.Employee;

public class EmployeeDao extends CCDatabaseDao {

    @Override
    protected CCDatabase getCCDatabase() {
        return Main.DATABASE;
    }

    @Override
    protected Class getEntity() {
        return Employee.class;
    }
}