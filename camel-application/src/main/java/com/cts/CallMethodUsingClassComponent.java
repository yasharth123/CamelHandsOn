package com.cts;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CallMethodUsingClassComponent {
	
	public static void main(String[] args) throws Exception {
		

		CamelContext camel = new DefaultCamelContext();
		
		camel.addRoutes(new MyRouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("direct:abc")
				.to("class:com.cts.MyService?method=display");
				
			}
		});
		
		camel.start();
		
		ProducerTemplate producer = camel.createProducerTemplate();
		producer.sendBody("direct:abc","Hello Guys from Apache camel");
		
	}

}
