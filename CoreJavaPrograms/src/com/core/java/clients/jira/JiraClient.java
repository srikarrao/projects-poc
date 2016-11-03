/*package com.core.java.clients.jira;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;
import com.atlassian.jira.rest.client.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

import java.net.URI;

*//**
 * Entry-point invoked when the jar is executed.
 *//*
public class JiraClient {
	private static final String JIRA_URL = "http://localhost:2990/jira";
	private static final String JIRA_ADMIN_USERNAME = "admin";
	private static final String JIRA_ADMIN_PASSWORD = "admin";

	public static void main(String[] args) throws Exception {
		// Print usage instructions
		StringBuilder intro = new StringBuilder();
		intro.append("**********************************************************************************************\r\n");
		intro.append("* JIRA Java REST Client ('JRJC') example.                                                    *\r\n");
		intro.append("* NOTE: Start JIRA using the Atlassian Plugin SDK before running this example.               *\r\n");
		intro.append("* (for example, use 'atlas-run-standalone --product jira --version 6.0 --data-version 6.0'.) *\r\n");
		intro.append("**********************************************************************************************\r\n");
		System.out.println(intro.toString());

		// Construct the JRJC client
		System.out.println(String.format(
				"Logging in to %s with username '%s' and password '%s'",
				JIRA_URL, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		URI uri = new URI(JIRA_URL);
		JiraRestClient client = factory.createWithBasicHttpAuthentication(uri,
				JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);

		// Invoke the JRJC Client
		Promise<User> promise = client.getUserClient().getUser("admin");
		User user = promise.claim();

		// Print the result
		System.out.println(String.format(
				"Your admin user's email address is: %s\r\n",
				user.getEmailAddress()));

		// Done
		System.out.println("Example complete. Now exiting.");
		System.exit(0);
	}
}*/