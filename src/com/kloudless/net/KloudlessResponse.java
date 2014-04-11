package com.kloudless.net;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class KloudlessResponse {
	int responseCode;
	String responseBody;
	Map<String, List<String>> responseHeaders;
	InputStream responseStream;
	
	public KloudlessResponse(int responseCode, String responseBody) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
		this.responseHeaders = null;
	}

	public KloudlessResponse(int responseCode, String responseBody,
			Map<String, List<String>> responseHeaders) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
		this.responseHeaders = responseHeaders;
	}

	public KloudlessResponse(int responseCode, String responseBody,
			Map<String, List<String>> responseHeaders, InputStream responseStream) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
		this.responseHeaders = responseHeaders;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	public Map<String, List<String>> getResponseHeaders() {
		return responseHeaders;
	}
}
