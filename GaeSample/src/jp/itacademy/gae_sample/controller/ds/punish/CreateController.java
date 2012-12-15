package jp.itacademy.gae_sample.controller.ds.punish;

import java.util.Date;

import jp.itacademy.gae_sample.model.Employee;
import jp.itacademy.gae_sample.model.Punishment;

import org.apache.tools.ant.types.RedirectorElement;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Validators v = new Validators(request);
        v.add("employeeId", v.required(), v.longType());
        v.add("desc", v.required());
        if (!v.validate()){
            return redirect("/ds/employee/all");
        }
        
        long employeeId = asLong("employeeId");
        String desc = asString("desc");
        
        Key employeeKey = Datastore.createKey(Employee.class, employeeId);
        
        Key punishmentKey = Datastore.allocateId(employeeKey, Punishment.class);
        
        Transaction tx = Datastore.beginTransaction();
        try{
            Employee employee =
                    Datastore.getOrNull(Employee.class, employeeKey);
            if (employee == null){
                return redirect("/ds/employee/all");
            }
            
            int count = employee.getPunishmentCount();
            employee.setPunishmentCount(count + 1);
            
            Punishment punish = new Punishment();
            punish.setKey(punishmentKey);
            punish.setDesc(desc);
            punish.setDate(new Date());
            
            Datastore.put(employee, punish);
            tx .commit();
        }finally{
            if (tx.isActive()){
                tx.rollback();
            }
        }
        
        return forward("create.jsp");
    }
}