package com.vitta.doctorprescription.core.service.dto;

import lombok.*;
import org.springframework.http.ResponseEntity;
import com.vitta.doctorprescription.core.service.enums.ResponseStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultResponse {

    private Object response;

    private ResponseStatus status;

    public DefaultResponse(ResponseStatus status) {

        this.status = status;

    }

    public DefaultResponse(Object response, ResponseStatus status) {

        this.response = response;
        this.status = status;

    }

    public static DefaultResponse withErrorMessage(String message, ResponseStatus status) {

        ErrorMessage errorMessage = new ErrorMessage(message);
        return new DefaultResponse(errorMessage, status);

    }

    public boolean hasError() {

        return this.status != null && this.status.getStatus().isError();

    }

    public ResponseEntity buildResponse() {

        return response == null
            ? new ResponseEntity(status.getStatus())
            : new ResponseEntity<>(response, status.getStatus());

    }

}
