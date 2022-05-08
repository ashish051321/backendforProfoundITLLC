package com.profounditllc.backendforwebsite.models.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ServerResponse {
	private String message;
    private Object data;
}
