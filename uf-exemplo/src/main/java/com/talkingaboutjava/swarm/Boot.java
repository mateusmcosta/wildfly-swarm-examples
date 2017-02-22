package com.talkingaboutjava.swarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Boot {

	public static void main(String[] args) throws Exception {

		Swarm swarm = new Swarm(args);

		swarm.fraction(datasourceWithH2());

		swarm.start();

		JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

		ClassLoader classLoader = Boot.class.getClassLoader();
		deployment.addModule("com.h2database.h2");
		deployment.addAsWebInfResource(classLoader.getResource("beans.xml"), "beans.xml");
		deployment.addAsWebInfResource(classLoader.getResource("persistence.xml"), "classes/META-INF/persistence.xml");
		deployment.addAsWebInfResource(classLoader.getResource("load.sql"), "classes/META-INF/load.sql");
		deployment.addPackages(true, "com.talkingaboutjava");
		

		deployment.addAllDependencies();

		swarm.deploy(deployment);
	}

	private static DatasourcesFraction datasourceWithH2() {
		return new DatasourcesFraction().jdbcDriver("h2", (d) -> {
			d.driverClassName("org.h2.Driver");
			d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
			d.driverModuleName("com.h2database.h2");
		}).dataSource("ExampleDS", (ds) -> {
			ds.driverName("h2");
			ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
			ds.userName("sa");
			ds.password("sa");
		});
	}
}
