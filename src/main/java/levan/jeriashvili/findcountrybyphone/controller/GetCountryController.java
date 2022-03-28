package levan.jeriashvili.findcountrybyphone.controller;


import levan.jeriashvili.findcountrybyphone.model.CodeAndCountryResponse;
import levan.jeriashvili.findcountrybyphone.service.FindCountryService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetCountryController.class);

    @Autowired
    private FindCountryService findCountryService;


    @GetMapping(path = "get-country/{phone-number}")
    public CodeAndCountryResponse getCountry(@PathVariable(value = "phone-number") String phoneNumber) {
        try {
            return findCountryService.findCountry(phoneNumber);
        } catch (Exception e) {
            LOGGER.error("error occurred ", e);
        }
        return null;
    }

}
