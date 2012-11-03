package jp.itacademy.gae_sample.controller.add;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class CalcController extends Controller {

    @Override
    public Navigation run() throws Exception {
        int num11 = asInteger("num1");
        int num22 = asInteger("num2");
        int result = num11 + num22;
        requestScope("result", result);
        
        return forward("calc.jsp");
    }
}
