package osj.javat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVO {
	@JsonProperty("request")
    private RequestVO request;
	
	@JsonProperty("docs")
    private List<DocWrapperVO> docs;
}
