package jp.itacademy.gae_sample.controller.ds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.itacademy.gae_sample.model.Credential;
import jp.itacademy.gae_sample.model.Dept;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class CreateSampleController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Employee employee;
        Dept dept;
        Credential credential;
        List<Object> models = new ArrayList<Object>();
        
        credential = new Credential();
        credential.setKey(Datastore.createKey(Credential.class, 1));
        credential.setName("ïÅí ñ∆ãñ");
        models.add(credential);
        
        credential = new Credential();
        credential.setKey(Datastore.createKey(Credential.class, 2));
        credential.setName("äÓñ{èÓïÒãZèpé“");
        models.add(credential);

        credential = new Credential();
        credential.setKey(Datastore.createKey(Credential.class, 3));
        credential.setName("É^ÉRåüíË");
        models.add(credential);

        dept = new Dept();
        dept.setKey(Datastore.createKey(Dept.class, 1));
        dept.setName("âcã∆");
        models.add(dept);

        dept = new Dept();
        dept.setKey(Datastore.createKey(Dept.class, 2));
        dept.setName("äJî≠");
        models.add(dept);

        employee = new Employee();
        employee.setName("é–í{ëæòY");
        employee.setHireDate(newDate(2012, 3, 1));
        employee.setDeptid(1);
        employee.setSalary(200000);
        employee.setCredentialIds(Arrays.asList(1L, 2L));
        models.add(employee);
        
        employee = new Employee();
        employee.setName("é–í{éüòY");
        employee.setHireDate(newDate(1999, 9, 9));
        employee.setDeptid(2);
        employee.setSalary(300000);
        employee.setCredentialIds(Arrays.asList(2L, 3L));
        models.add(employee);
        
        Datastore.put(models);
        
        return forward("createSample.jsp");
    }
    
    public static Date newDate(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        
        return cal.getTime();
    }
}
