package osj.javat.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import osj.javat.model.ResultVO;
import osj.javat.service.RecommendService;

@RestController
@RequestMapping("/api/recommend")
public class RecommendController {
	
	private RecommendService recommendService;
	
	public RecommendController(RecommendService recommendService) {
		this.recommendService = recommendService;
	}
	
	@GetMapping("/popular")
	public ResultVO recommendBooks(
			@RequestParam(value = "startDt", required = false) String startDt,
			@RequestParam(value = "pageNo", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int size) {
		if (startDt == null || startDt.isEmpty()) {
			LocalDate defaultDay = LocalDate.now().minusDays(30);
			startDt = defaultDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return recommendService.resultBooks(startDt, page, size);
	}
	
}
