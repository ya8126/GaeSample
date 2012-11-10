package jp.itacademy.gae_sample.controller.greeting;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ReplyControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/greeting/reply");
        ReplyController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/greeting/reply.jsp"));
    }
}
