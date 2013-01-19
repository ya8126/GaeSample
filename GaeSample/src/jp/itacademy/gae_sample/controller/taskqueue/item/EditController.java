package jp.itacademy.gae_sample.controller.taskqueue.item;

import jp.itacademy.gae_sample.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;

public class EditController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        if (!v.validate()){
            return redirect("/task/queue/item/list");
        }
        
        Key key = Datastore.createKey(Item.class, asLong("id"));
        Item item = Datastore.getOrNull(Item.class, key);
        if (item == null){
            return redirect("/taskqueue/item/list");
        }
        
        requestScope("id", item.getKey().getId());
        requestScope("name", item.getName());
        requestScope("price", item.getPrice());
        
        return forward("edit.jsp");
    }
}
