package id.co.miniproject.ecomm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.miniproject.ecomm.model.ErrorSchema;
import lombok.*;


@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private ErrorSchema errorSchema;
    @JsonIgnore
    private T objectSchema;
}
