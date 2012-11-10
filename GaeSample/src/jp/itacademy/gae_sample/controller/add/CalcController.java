package jp.itacademy.gae_sample.controller.add;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

public class CalcController extends Controller {

    @Override
    public Navigation run() throws Exception {
        Validators v = new Validators(request);
        v.add("num1", v.required(), v.integerType());
        v.add("num2", v.required(), v.integerType());
        
        if (!v.validate()){
            return forward("index.jsp");
        }
        
        int num11 = asInteger("num1");
        int num22 = asInteger("num2");
        int result = num11 + num22;
        requestScope("result", result);
        
        return forward("calc.jsp");
    }
}
