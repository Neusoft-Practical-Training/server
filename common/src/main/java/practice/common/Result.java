package practice.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 500;

    private Integer code;
    private String message;
    private Object data;
}