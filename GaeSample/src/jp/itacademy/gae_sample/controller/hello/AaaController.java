package jp.itacademy.gae_sample.controller.hello;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AaaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("aaa.jsp");
    }
}
