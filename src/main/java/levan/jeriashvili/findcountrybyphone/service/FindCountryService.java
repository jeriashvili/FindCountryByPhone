package levan.jeriashvili.findcountrybyphone.service;

import levan.jeriashvili.findcountrybyphone.model.CodeAndCountryResponse;

public interface FindCountryService {

    CodeAndCountryResponse findCountry(String phoneNum) throws Exception;
}
