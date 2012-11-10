package jp.itacademy.gae_sample.controller.subtract;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CalcControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/subtract/calc");
        CalcController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/subtract/calc.jsp"));
    }
}
