package jp.itacademy.gae_sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SaleItemTest extends AppEngineTestCase {

    private SaleItem model = new SaleItem();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
