package com.cts.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("file:C:/source?noop=true")
		 .process(new FileProcessor())
		  .to("file:C:/destin?fileName=emp.json");
		
		
	}
	
	
	
	
	

}
