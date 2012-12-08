package jp.itacademy.gae_sample.controller.ds.employee;

import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class UpdateNameController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        v.add("name", v.required());
        if (!v.validate()){
            System.out.println("validation error: "+ errors);
            return null;
        }
        
        long id = asLong("id");
        String name = asString("name");
        
        Key key = Datastore.createKey(Employee.class, id);
        Transaction tx = Datastore.beginTransaction();
        try{
            Employee e = Datastore.get(tx, Employee.class, key);
            e.setName(name);
            Datastore.put(tx, e);
            tx.commit();
        } finally{
            if (tx.isActive()){
                tx.rollback();
            }
        }
   
        return forward("updateName.jsp");
    }
}
