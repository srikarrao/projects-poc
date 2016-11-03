package com.designpatterns.j2ee.businessdelegate;

public class EJBService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Processing task by invoking EJB Service");
	}
}
