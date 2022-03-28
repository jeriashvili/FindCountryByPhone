package levan.jeriashvili.findcountrybyphone.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Service
public class WikiDataRetrieverServiceImpl implements WikiDataRetrieverService {

    private static final String pageUrl = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

    @Override
    public Map<String, String> getData() throws Exception {
        Map<String, String> countryCode = new HashMap<>();
        try {
            final Document document = Jsoup.connect(pageUrl).get();
            for (Element table : document.select("table.wikitable.sortable")) {
                if (table.select("th").text().startsWith("Country")) {
                    for (Element row : table.select("tr")) {
                        String country = row.select("td:nth-of-type(1)").text();
                        String code = row.select("td:nth-of-type(2)").text();
                        countryCode.put(deleteUnnecessary(code), country);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return countryCode;

    }

    public static String deleteUnnecessary(String text) {
        text = text.replace(" ", "");
        text = text.replace("[notes1]", "");
        text = text.replace("+", "");
        return text;
    }
}
