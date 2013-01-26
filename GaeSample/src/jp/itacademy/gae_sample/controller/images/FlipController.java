package jp.itacademy.gae_sample.controller.images;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.appengine.api.images.ImagesService.OutputEncoding;

public class FlipController extends AbstractImagesController {

    @Override
    public Navigation run() throws Exception {
    
        Validators v = new Validators(request);
        v.add("direction",v.required());
        if (!v.validate()){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        
        String direction = asString("direction");
        
        Image image = ImagesServiceFactory.makeImage(loadImage("/images/gae.png"));
        Transform transform;
        
        if (direction.equals("horizontal")){
            transform = ImagesServiceFactory.makeHorizontalFlip();
        }else{
            if (direction.equals("vertical")){
                transform = ImagesServiceFactory.makeVerticalFlip();
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }
        }
 
        ImagesService service = ImagesServiceFactory.getImagesService();
        service.applyTransform(transform, image, OutputEncoding.PNG);
        
        return binary(image.getImageData(), "image/png");        
    }
}
