package jp.itacademy.gae_sample.controller.taskqueue.item;

import java.util.List;

import jp.itacademy.gae_sample.model.Item;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<Item> items = Datastore.query(Item.class).asList();
        requestScope("items", items);
        
        return forward("list.jsp");
    }
}
