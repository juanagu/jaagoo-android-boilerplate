package co.jagu.common.base;


import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class BaseViewModelTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
