package osj.javat.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
	private ResponseVO response;

    public ResponseVO getResponse() {
        return response;
    }
    public void setResponse(ResponseVO response) {
        this.response = response;
    }
}
