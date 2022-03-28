package levan.jeriashvili.findcountrybyphone;

import levan.jeriashvili.findcountrybyphone.controller.GetCountryController;
import levan.jeriashvili.findcountrybyphone.service.FindCountryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class GetCountryControllerTest {


    private static final String ENDPOINT = "http://localhost:8080/get-country/";
    private static final String PHONE_NUMBER = "15234758962";

    private MockMvc mvc;

    @InjectMocks
    private GetCountryController getCountryController;

    @Mock
    FindCountryService findCountryService;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(getCountryController).build();
    }

    @Test
    public void testEndpopint() throws Exception {
        mvc.perform(get(ENDPOINT + PHONE_NUMBER)).andExpect(status().isOk());
    }


}
