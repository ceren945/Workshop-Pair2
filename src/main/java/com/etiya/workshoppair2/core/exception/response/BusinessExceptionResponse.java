package com.etiya.workshoppair2.core.exception.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessExceptionResponse {
    private String message;

}