package com.example.camel.microservicea.routes.a;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyFirstTimerRoute extends RouteBuilder {
	
	@Autowired
	GetCurrentTimeBean getCurrentTimeBean;
	
	@Autowired
	SimpleLoggingProcessComponent loggingComponent;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		//queue
		//transformtion
		//database
		
		//timer
		//transformation
		//log
		//from("timer:first-timer")//queue
		//.log("${body}")//log msg body
		//by default if NO transform, body is NULL
		//.transform().constant("My constant message")//body is constant message
		//.log("${body}")//log msg body
		//.transform().constant("Current time = "+LocalDateTime.now())// body is local date time
		//.log("${body}")//log msg body
		//.bean(getCurrentTimeBean)//calling function by creating bean
		//.log("${body}")//log msg body
		//.bean(loggingComponent)//Processing the message without changing the body using bean()
		//.process(new SimpleLoggingProcessor())//Processing the message without changing the body using processsor
		//.to("log:first-timer");//database
		//.log("${body}");//log msg body
	}

}

@Component
class GetCurrentTimeBean{
	public String getCurrentTime() {
		return "Time now is "+LocalDateTime.now();
	}
}

@Component
class SimpleLoggingProcessComponent{
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessComponent.class);
	
	public void process(String message){
		logger.info("SimpleLoggingProcessComponent {}",message);
	}
}

class SimpleLoggingProcessor implements Processor{
	private Logger logger=LoggerFactory.getLogger(SimpleLoggingProcessComponent.class);
	@Override
	public void process(Exchange exchange) {
		logger.info("SimpleLoggingProcessor {}",exchange.getMessage().getBody());
	}
}
