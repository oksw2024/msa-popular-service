package osj.javat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookVO {
	@JsonProperty("bookname")
    private String bookname;

    @JsonProperty("authors")
    private String authors;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("publication_year")
    private String publicationYear;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("bookImageURL")
    private String bookImageURL; // 책표지 URL

}
