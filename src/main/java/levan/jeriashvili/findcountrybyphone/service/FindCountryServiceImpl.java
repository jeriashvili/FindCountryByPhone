package levan.jeriashvili.findcountrybyphone.service;

import levan.jeriashvili.findcountrybyphone.model.CodeAndCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FindCountryServiceImpl implements FindCountryService {

    private final WikiDataRetrieverService wikiDataRetrieverService;

    @Autowired
    public FindCountryServiceImpl(WikiDataRetrieverService wikiDataRetrieverService) {
        this.wikiDataRetrieverService = wikiDataRetrieverService;
    }


    @Override
    public CodeAndCountryResponse findCountry(String phoneNum) throws Exception {
        Map<String, String> countryCode = wikiDataRetrieverService.getData();
        for (int i = 7; i > 0; i--) {
            if (countryCode.containsKey(phoneNum.substring(0, i))) {
                return new CodeAndCountryResponse(0, countryCode.get(phoneNum.substring(0, i)));
            }
        }
        return new CodeAndCountryResponse(1, "No such country");
    }
}
