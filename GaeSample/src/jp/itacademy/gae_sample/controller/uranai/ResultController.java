package jp.itacademy.gae_sample.controller.uranai;

import java.util.Calendar;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import sun.util.resources.CalendarData;

public class ResultController extends Controller {

    @Override
    public Navigation run() throws Exception {

        int bloodType = asInteger("bloodType");
        String result = null;
        
        switch (bloodType * Calendar.getInstance().get(Calendar.DATE) % 3){
        case 0:
            result = "��g";
            break;
        case 1:
            result = "���g";
            break;            
        case 2:
            result = "��";
            break; 
        }
        requestScope("result", result);
        return forward("result.jsp");
    }
}
