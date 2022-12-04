package com.example.camel.microserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.example.camel.microserviceb.CurrencyExchange;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder{
	
	@Override
	public void configure() throws Exception{

		from("activemq:my-active-mq-queue")
		.log("${body}")
		.unmarshal().json(JsonLibrary.Jackson,CurrencyExchange.class)
		.to("log:received-message-from-active-mq");
	}

}
