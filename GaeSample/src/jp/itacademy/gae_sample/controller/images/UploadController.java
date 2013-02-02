package jp.itacademy.gae_sample.controller.images;

import jp.itacademy.gae_sample.model.ImageFile;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;


public class UploadController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        FileItem file =requestScope("imageFile");
        
        int resize = 100;
        try{
            resize = asInteger("resize");
            
        }catch(Exception e){
            
        }
        
        Image image = ImagesServiceFactory.makeImage(file.getData());
        int w = image.getWidth() * resize / 100;
        int h = image.getHeight() * resize / 100;
        Transform transform = ImagesServiceFactory.makeResize(w, h);
        image = ImagesServiceFactory.getImagesService().applyTransform(transform, image);
        
        ImageFile imageFile = new ImageFile();
        imageFile.setFileName(file.getFileName());
        imageFile.setContentType(file.getContentType());
        imageFile.setData(image.getImageData());
        Datastore.put(imageFile);
        
        requestScope("imageFile", imageFile);

        return forward("upload.jsp");
    }
}
