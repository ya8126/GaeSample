package jp.itacademy.gae_sample.controller.taskqueue.item;

import jp.itacademy.gae_sample.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

public class UpdateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        v.add("name", v.required());
        v.add("price", v.required(), v.integerType());
        if (!v.validate()){
            return forward("edit.jsp");
        }

        Key key = Datastore.createKey(Item.class, asLong("id"));
        
        Transaction tx = Datastore.beginTransaction();
        try{
            Item item = Datastore.getOrNull(Item.class, key);
            if (item == null){
                return redirect("/taskqueue/item/list");
            }
        
            item.setName(asString("name"));
            item.setPrice(asInteger("price"));
            Datastore.put(item);
            
            long timestamp = System.currentTimeMillis();
            Queue queue = QueueFactory.getDefaultQueue();
            queue.add(tx, TaskOptions.Builder
                .withUrl("/task/itemUpdate")
                .param("id", String.valueOf(key.getId()))
                .param("timestamp", String.valueOf(timestamp)));
            
            tx.commit();
            
        }finally{
            if (tx.isActive()){
                tx.rollback();
            }
        }
                
        return redirect("/taskqueue/item/list");
    }
}
