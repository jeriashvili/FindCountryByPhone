package levan.jeriashvili.findcountrybyphone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodeAndCountryResponse {

    private int code;
    private String country;
}
