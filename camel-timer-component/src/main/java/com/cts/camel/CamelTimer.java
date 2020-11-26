package com.cts.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;



public class CamelTimer {
	
	public static void main(String[] args) throws Exception {
		
		MyBean mybean=new MyBean();
		SimpleRegistry registry=new SimpleRegistry();
		registry.bind("bean1", MyBean.class ,  mybean);
		
		CamelContext camel=new DefaultCamelContext(registry);
		
 camel.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("timer:mytimer?period=1000").setBody(simple("Hello from camel at ${header.firedTime}"))
				.to("stream:out")
				.to("bean:bean1?method=sayHello");
				
				
			}
		});
                  camel.start();
 
                  Thread.sleep(2000);
 
                  camel.stop();
	}

}
