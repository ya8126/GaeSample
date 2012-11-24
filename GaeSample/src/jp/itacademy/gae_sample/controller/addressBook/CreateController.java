package jp.itacademy.gae_sample.controller.addressBook;

import jp.itacademy.gae_sample.model.Address;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        requestScope("create");
        
        Validators v = new Validators(request);
        
        v.add("name", v.required());
        v.add("zip", v.regexp("[0-9]{3}-[0-9]{4}"));
        v.add("addr1", v.required());
        v.add("tel", v.required());
        
        if(!v.validate()){
            return forward("index.jsp");
        }
        
        String name = asString("name");
        String zip = asString("zip");
        String addr1 = asString("addr1");
        String addr2 = asString("addr2");
        String tel = asString("tel");
        String email = asString("email");
        
        Address address = new Address();
        address.setName(name);
        address.setZip(zip);
        address.setAddr1(addr1);
        address.setAddr2(addr2);
        address.setTel(tel);
        address.setEmail(email);
        
        Datastore.put(address);
        
        requestScope("create", name);
        
        return forward("index.jsp");
    }
}
