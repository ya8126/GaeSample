package jp.itacademy.gae_sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EmployeeTest extends AppEngineTestCase {

    private Employee model = new Employee();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
