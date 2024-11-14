package osj.javat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVO {
	private String startDt;
	
	public RequestVO() {
	}
	
	@JsonProperty("pageNo")
    private int pageNo;

    @JsonProperty("pageSize")
    private int pageSize;
}
