package jp.itacademy.gae_sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AddressBookTest extends AppEngineTestCase {

    private Address model = new Address();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
