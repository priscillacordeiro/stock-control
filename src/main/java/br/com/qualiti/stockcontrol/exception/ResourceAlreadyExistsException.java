package br.com.qualiti.stockcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistsException  extends RuntimeException {
	
    private String resourceName;

    public ResourceAlreadyExistsException(String resourceName) {
        super(String.format("%s already exists", resourceName));
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

}