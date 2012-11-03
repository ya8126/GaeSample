package jp.itacademy.gae_sample.controller.hello.aaa;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BbbControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/hello/aaa/bbb");
        BbbController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/hello/aaa/bbb.jsp"));
    }
}
