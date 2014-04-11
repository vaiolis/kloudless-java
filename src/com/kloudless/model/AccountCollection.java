package com.kloudless.model;

import java.util.List;


public class AccountCollection extends KloudlessCollection<Account> {
	Integer total;
	Integer count;
	Integer page;
	List<Account> objects;
}