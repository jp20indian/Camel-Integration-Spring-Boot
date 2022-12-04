package com.example.camel.microservicea.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
	
	@Override
	public void configure() throws Exception{
		//time
		//from("timer:active-mq-time?period=1000")
		//.transform().constant("My message for Active MQ")
		//.log("${body}")
		//.to("activemq:my-active-mq-queue");
		
		from("file:files/json")
		.log("${body}")
		.to("activemq:my-active-mq-queue");
		
	}

}
