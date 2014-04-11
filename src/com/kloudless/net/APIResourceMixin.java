package com.kloudless.net;

import java.util.Map;

import com.kloudless.exception.APIConnectionException;
import com.kloudless.exception.APIException;
import com.kloudless.exception.AuthenticationException;
import com.kloudless.exception.InvalidRequestException;

public abstract class APIResourceMixin extends APIResource {

	// List Mixin
	protected static <T> T all(String path, Map<String, Object> params,
			Class<T> clazz, String apiKey) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		KloudlessResponse response = request(RequestMethod.GET, path, params,
				apiKey);
		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		return GSON.fromJson(rBody, clazz);
	}

	// Retrieve Mixin
	protected static <T> T retrieve(String path, Map<String, Object> params,
			Class<T> clazz, String apiKey) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		KloudlessResponse response = request(RequestMethod.GET, path, params,
				apiKey);

		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		return GSON.fromJson(rBody, clazz);
	}

	// Create Mixin
	protected static <T> T create(String path, Map<String, Object> params,
			Class<T> clazz, String apiKey) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		KloudlessResponse response = request(RequestMethod.POST, path, params, apiKey);
		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		return GSON.fromJson(rBody, clazz);
	}

	// UpdatePartial Mixin
	protected static <T> T save(String path, Map<String, Object> params,
			Class<T> clazz, String apiKey) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		KloudlessResponse response = request(RequestMethod.PATCH, path, params, apiKey);
		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		return GSON.fromJson(rBody, clazz);
	}

	// Delete Mixin
	protected static KloudlessResponse delete(String path,
			Map<String, Object> params, String apiKey) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		KloudlessResponse response = request(RequestMethod.DELETE, path,
				params, apiKey);

		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		return response;
	}

}
