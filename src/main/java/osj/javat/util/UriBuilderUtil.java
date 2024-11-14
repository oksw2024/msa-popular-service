package osj.javat.util;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

public class UriBuilderUtil {
	private static final String API_URL = "https://data4library.kr/api/loanItemSrch";
    private static final String AUTH_KEY = "246bc9a1a2ea4ba78b5ada1b16a0ba7e43537ef40b0427f80013629f7b593a86";
    
    public static URI buildSearchUri(String startDt, int page, int size) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(API_URL)
                .queryParam("authKey", AUTH_KEY)
                .queryParam("pageSize", size)
                .queryParam("pageNo", page + 1)
                .queryParam("format", "json")
                .queryParam("startDt", startDt);

        return uriBuilder.encode().build().toUri();
    }
}
