package jp.itacademy.gae_sample.controller.taskqueue.shop;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ListControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/taskqueue/shop/list");
        ListController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/taskqueue/shop/list.jsp"));
    }
}
