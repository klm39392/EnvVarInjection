package com.klm.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;




/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {
	private static Logger logger = Logger.getLogger("A1");
	private String val;

	/**
	 * Reads next record from input
	 */
	public static void main(final String... args) {
		AbstractApplicationContext context =
	             new ClassPathXmlApplicationContext("classpath:META-INF/spring//*-context.xml");
	    final ExampleService service = context.getBean(ExampleService.class);
	    System.out.println("endpoint:" + service.getEndPoint());
	    logger.info("endpoint:" + service.getEndPoint());
	}
	
	/**
	 * Reads next record from input
	 * @return 
	 */
	@Value("#{props.endpoint}")
	public  void setEndPoint(String val) {		
	   this.val = val;
	}
	
	public  String getEndPoint() {				
		   return StringUtils.replace(val, "<hostname>", System.getProperty("localhost") );
		}
	
    
}
