package levan.jeriashvili.findcountrybyphone;

import levan.jeriashvili.findcountrybyphone.service.FindCountryServiceImpl;
import levan.jeriashvili.findcountrybyphone.service.WikiDataRetrieverService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class FindCountryServiceTest {

    private static final String PHONE_NUMBER = "59345965123";

    @InjectMocks
    FindCountryServiceImpl findCountryService;

    @Mock
    WikiDataRetrieverService wikiDataRetrieverService;

    @Before
    public void setup() throws Exception {
        Map<String, String> countryAndCode = new HashMap<>();
        countryAndCode.put("995", "Georgia");
        when(wikiDataRetrieverService.getData()).thenReturn(countryAndCode);
    }

    @Test
    public void testDetermineServiceNotNullCheck() throws Exception{
        assertNotNull(findCountryService.findCountry(PHONE_NUMBER));
    }

    @Test
    public void testDetermineServiceResponse() throws Exception {
        assertEquals(findCountryService.findCountry(PHONE_NUMBER).getCountry(), "Ecuador");
    }




}
