package jp.itacademy.gae_sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ShopTest extends AppEngineTestCase {

    private Shop model = new Shop();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
