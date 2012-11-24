package jp.itacademy.gae_sample.controller.book;

import java.util.List;

import jp.itacademy.gae_sample.model.Book;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        List<Book> books = Datastore.query(Book.class).asList();
        requestScope("books", books);
        return forward("list.jsp");
    }
}
