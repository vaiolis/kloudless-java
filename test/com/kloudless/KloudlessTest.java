package com.kloudless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kloudless.exception.KloudlessException;
import com.kloudless.model.Account;
import com.kloudless.model.AccountCollection;
import com.kloudless.model.File;
import com.kloudless.model.Folder;
import com.kloudless.model.Link;
import com.kloudless.model.LinkCollection;
import com.kloudless.model.MetadataCollection;
import com.kloudless.net.KloudlessResponse;

public class KloudlessTest {

	static Map<String, Object> defaultAccountParams = new HashMap<String, Object>();
	static Map<String, Object> defaultFileParams = new HashMap<String, Object>();
	static Map<String, Object> defaultFolderParams = new HashMap<String, Object>();
	static Map<String, Object> defaultLinkParams = new HashMap<String, Object>();
	static Gson GSON = new GsonBuilder().create();
	
	@BeforeClass
	public static void setUp() {
		Kloudless.apiKey = "INSERT API KEY HERE";

		defaultAccountParams.put("accountId", "1");

		defaultFileParams.put("fileId", "f9ab32==");

		defaultFolderParams.put("folderId", "fe134cd==");

		defaultLinkParams.put("linkId", "xve1q3rgb3");
	}

	// Begin Account Tests	
	@Test
	public void testAccountAll() throws KloudlessException {
		AccountCollection accounts = Account.all(null);
		System.out.println(accounts);
	}

	@Test
	public void testAccountRetrieve() throws KloudlessException {
		Account account = Account.retrieve("1", null);
		System.out.println(account);
	}

	@Test
	public void testAccountDelete() throws KloudlessException {
		// TODO: figure out how to test delete an account
	}

	// Begin Folder Tests
	@Test
	public void testFolderContents() throws KloudlessException {
		MetadataCollection contents = Folder.contents("root", "4", null);
		System.out.println(contents);
	}
	
	@Test
	public void testFolderRetrieve() throws KloudlessException {
		Folder folderInfo = Folder.retrieve("fL2E=", "4", null);
		System.out.println(folderInfo);
	}

	@Test
	public void testFolderSave() throws KloudlessException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", "a");
		Folder folderInfo = Folder.save("fL2E=", "4", params);
		System.out.println(folderInfo);
	}

	@Test
	public void testFolderCreate() throws KloudlessException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", "new new folder");
		params.put("parent_id", "root");
		Folder folderInfo = Folder.create("4", params);
		System.out.println(folderInfo);
	}

	@Test
	public void testFolderDelete() throws KloudlessException {
		// TODO: figure out how to test delete a folder
	}
	

	// Begin File Tests
	@Test
	// TODO: test
	public void testFileContents() throws KloudlessException, IOException {
		KloudlessResponse response = File.contents("fL3N1cHBvcnQtc2FsZXNmb3JjZS5wbmc\u003d", "4", null);
		String contents = response.getResponseBody();
		System.out.println(contents);
	}

	@Test
	public void testFileRetrieve() throws KloudlessException {
		File fileInfo = File.retrieve("fL3Rlc3QgKDE2KS50eHQ\u003d", "4", null);
		System.out.println(fileInfo);
	}

	@Test
	public void testFileSave() throws KloudlessException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name", "test (16).txt");
		File fileInfo = File.save("fL3Rlc3QgKDE2KS50eHQ\u003d", "4", params);
		System.out.println(fileInfo);
	}

	@Test
	// TODO: test
	public void testFileCreate() throws KloudlessException, IOException {
		
		String text = "Hello, World!";
		String path = "/tmp/new.txt";
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		writer.println(text);
		writer.close();		
		java.io.File f = new java.io.File(path);
		Scanner scanner = new Scanner(f);
		String contents = scanner.next();
		scanner.close();
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		HashMap<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("name",  "testtesttest.txt");
		metadata.put("parent_id", "root");
		params.put("metadata", GSON.toJson(metadata));
		params.put("file", contents.getBytes());
		
		System.out.println(params);
		
		File fileInfo = File.create("4", params);
		System.out.println(fileInfo);
	}
	
	@Test
	public void testFileDelete() throws KloudlessException {
		// TODO: figure out how to test delete a file
	}

	// Begin Link Tests
	@Test
	public void testLinkAll() throws KloudlessException {
		LinkCollection links = Link.all("2", null);
		System.out.println(links);
	}
	
	@Test
	public void testLinkRetrieve() throws KloudlessException {
		Link linkInfo = Link.retrieve("iywSjUZMos2_M_HTHpJU", "2", null);
		System.out.println(linkInfo);
	}
	
	@Test
	public void testLinkSave() throws KloudlessException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("active", false);
		Link linkInfo = Link.save("iywSjUZMos2_M_HTHpJU", "2", params);
		System.out.println(linkInfo);
	}

	@Test
	public void testLinkCreate() throws KloudlessException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("file_id", "fL3Rlc3QtZHJvcGJveC5wbmc\u003d");
		Link linkInfo = Link.create("4", params);
		System.out.println(linkInfo);
	}
	
	@Test
	public void testLinkDelete() throws KloudlessException {
		// TODO: figure out how to test delete a file
	}

}