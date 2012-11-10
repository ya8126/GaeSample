package jp.itacademy.gae_sample.controller.bmi;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class CalcController extends Controller {

    @Override
    public Navigation run() throws Exception {
        double weight = asDouble("weight");
        double height = asDouble("height");
        double bmi = weight * 10000 / height / height;
        requestScope("bmi", bmi);
        return forward("calc.jsp");
    }
}
