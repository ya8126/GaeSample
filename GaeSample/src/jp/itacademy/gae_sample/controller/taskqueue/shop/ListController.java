package jp.itacademy.gae_sample.controller.taskqueue.shop;

import java.util.List;

import jp.itacademy.gae_sample.model.Shop;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<Shop> shops = Datastore.query(Shop.class).asList();
        requestScope("shops", shops);
        return forward("list.jsp");
    }
}
