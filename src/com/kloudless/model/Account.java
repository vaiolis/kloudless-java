package com.kloudless.model;

import java.util.Map;

import com.kloudless.exception.APIConnectionException;
import com.kloudless.exception.APIException;
import com.kloudless.exception.AuthenticationException;
import com.kloudless.exception.InvalidRequestException;
import com.kloudless.net.APIResourceMixin;
import com.kloudless.net.KloudlessResponse;

public class Account extends APIResourceMixin {

	String id;
	String account;
	Boolean active;
	String service;
	String created;
	String modified;

	public static AccountCollection all(Map<String, Object> params)
			throws APIException, AuthenticationException,
			InvalidRequestException, APIConnectionException {
		return all(classURL(Account.class), params, AccountCollection.class, null);
	}

	public static Account retrieve(String id, Map<String, Object> params)
			throws APIException, AuthenticationException,
			InvalidRequestException, APIConnectionException {
		return retrieve(instanceURL(Account.class, id), params, Account.class, null);
	}

	// TODO: figure out how to return a null response for a 204 DELETED response
	public static KloudlessResponse delete(String id, Map<String, Object> params) throws APIException,
			AuthenticationException, InvalidRequestException,
			APIConnectionException {
		return delete(instanceURL(Account.class, id), params, null);
	}
}
