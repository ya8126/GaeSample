package jp.itacademy.gae_sample.controller.greeting;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ReplyController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("reply.jsp");
    }
}
