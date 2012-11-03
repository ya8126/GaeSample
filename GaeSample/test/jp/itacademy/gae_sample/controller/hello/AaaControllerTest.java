package jp.itacademy.gae_sample.controller.hello;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AaaControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/hello/aaa");
        AaaController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/hello/aaa.jsp"));
    }
}
