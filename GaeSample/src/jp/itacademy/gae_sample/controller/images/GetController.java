package jp.itacademy.gae_sample.controller.images;

import javax.servlet.http.HttpServletResponse;

import jp.itacademy.gae_sample.model.ImageFile;


import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;


public class GetController extends AbstractImagesController {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        if (!v.validate()){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        
        long id = asLong("id");
        Key key = Datastore.createKey(ImageFile.class, id);
        ImageFile file = Datastore.getOrNull(ImageFile.class, key);
        if (file == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        return binary(file.getData(), file.getContentType());
    }
}
