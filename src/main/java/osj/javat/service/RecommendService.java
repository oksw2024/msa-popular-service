package osj.javat.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
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
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
	public ResultVO resultBooks(String startDt, int page, int size) {
		URI uri = UriBuilderUtil.buildSearchUri(startDt, page, size);
		
		System.out.println("request URI : " + uri);
		
		return fetchSearchResults(uri);
	}
	
	public ResultVO newSearchBooks() {
		URI uri = UriBuilderUtil.buildSearchUri2();
		
		System.out.println("request URI : " + uri);
		
		return fetchSearchResults(uri);
	}
	
	private ResultVO fetchSearchResults(URI uri) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("recommendApiCircuitBreaker");
		
		return circuitBreaker.run(() -> {
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
		}, throwable -> fallbackMethod(throwable));
    }
	
	private ResultVO fallbackMethod(Throwable throwable) {
		ResultVO fallbackResult = new ResultVO();
		fallbackResult.setResponse(null);
		return fallbackResult;
	}
}
