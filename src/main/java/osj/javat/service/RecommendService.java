package osj.javat.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import osj.javat.model.ResultVO;
import osj.javat.util.UriBuilderUtil;

@Service
public class RecommendService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public ResultVO resultBooks(String startDt, int page, int size) {
		URI uri = UriBuilderUtil.buildSearchUri(startDt, page, size);
		
		System.out.println("request URI : " + uri);
		
		return fetchSearchResults(uri);
	}
	
	private ResultVO fetchSearchResults(URI uri) {
        try {
            String response = restTemplate.getForObject(uri, String.class);
            System.out.println("API Response: " + response);
            ResultVO result = objectMapper.readValue(response, ResultVO.class);
            System.out.println("result : " + result);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
