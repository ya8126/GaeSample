package jp.itacademy.gae_sample.controller.book;

import jp.itacademy.gae_sample.model.Book;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Validators v= new Validators(request);
        
        v.add("title", v.required());
        v.add("author", v.required());
        v.add("price", v.required(), v.integerType());
        
        if(!v.validate()){
            return forward("index.jsp");
        }
        
        String title = asString("title");
        String name = asString("author");
        int price = asInteger("price");
        
        Book book = new Book();
        book.setTitle(title);
        book.setName(name);
        book.setPrice(price);
        Datastore.put(book);
        
        response.setStatus(303);
        response.setHeader("Location", "list");
        
        return forward("create.jsp");
    }
}
