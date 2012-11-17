package jp.itacademy.gae_sample.controller.user;


import java.util.List;

import jp.itacademy.gae_sample.model.User;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        List<User> users = Datastore.query(User.class).asList();
        requestScope("users", users);
        return forward("list.jsp");
    }
}
