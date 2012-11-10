package jp.itacademy.gae_sample.controller.uranai;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ResultControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/uranai/result");
        ResultController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/uranai/result.jsp"));
    }
}
