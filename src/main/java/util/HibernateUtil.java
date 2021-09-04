package util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Details.Info;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {
		// load configuration
		/*
		 * StandardServiceRegistry sServiceRegistry = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml") .build();
		 * 
		 * Metadata meta = new
		 * MetadataSources(sServiceRegistry).getMetadataBuilder().build();
		 * 
		 * sessionFactory = meta.getSessionFactoryBuilder().build();
		 * 
		 * return sessionFactory;
		 */

		SessionFactory sessionFactory = new Configuration().configure()
				/* .addResource("EProduct.hbm.xml") */
				.addAnnotatedClass(Details.Info.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}
