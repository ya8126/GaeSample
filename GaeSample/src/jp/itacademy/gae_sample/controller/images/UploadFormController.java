package jp.itacademy.gae_sample.controller.images;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class UploadFormController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("uploadForm.jsp");
    }
}
