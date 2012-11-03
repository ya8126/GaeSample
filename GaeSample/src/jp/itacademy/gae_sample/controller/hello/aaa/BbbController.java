package jp.itacademy.gae_sample.controller.hello.aaa;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class BbbController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("bbb.jsp");
    }
}
