package jp.itacademy.gae_sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class bookTest extends AppEngineTestCase {

    private Book model = new Book();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
