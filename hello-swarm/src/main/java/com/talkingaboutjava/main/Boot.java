package com.talkingaboutjava.main;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Boot {
	//
	static String driverModule;

	public static void main(String[] args) throws Exception {

		Swarm swarm = new Swarm();


		swarm.start();
		JAXRSArchive appDeployment = ShrinkWrap.create(JAXRSArchive.class);
		appDeployment.addResource(MyResource.class);

		// Deploy your app
		swarm.deploy(appDeployment);

	}
}
