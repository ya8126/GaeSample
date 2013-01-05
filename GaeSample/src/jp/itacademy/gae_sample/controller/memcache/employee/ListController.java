package jp.itacademy.gae_sample.controller.memcache.employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.itacademy.gae_sample.model.Dept;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<Employee> employees = Datastore.query(Employee.class).asList();
        
        Set<Key> deptKeys = new HashSet<Key>();
        for (Employee e : employees){
            deptKeys.add(e.getDeptKey());
        }
        
        Map<Object, Object> deptMap = Memcache.getAll(deptKeys);
        
        for(Iterator<Key> i = deptKeys.iterator(); i.hasNext();){
            if(deptMap.containsKey(i.next())){
                i.remove();
            }
        }
        
        if(!deptKeys.isEmpty()){
            Map<Key, Dept> map = Datastore.getAsMap(Dept.class, deptKeys);
            deptMap.putAll(map);
            Memcache.putAll(new HashMap<Object, Object>(map));
        }
        
        for (Employee e : employees){
            e.setDept((Dept)deptMap.get(e.getDeptKey()));
        }
        
        requestScope("employees", employees);
        return forward("list.jsp");
    }
}
