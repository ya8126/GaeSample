package jp.itacademy.gae_sample.controller.addressBook;

import java.util.List;

import jp.itacademy.gae_sample.model.Address;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<Address> addressBook = Datastore.query(Address.class).asList();
        requestScope("addressBook", addressBook);
        return forward("list.jsp");
    }
}
