package com.puc.tcc.service;

import java.util.concurrent.ExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class Channe1Push {

	@Inject
	@Push(channel = "channel1")
	private PushContext channel1;

	public void send(String message) {
		System.out.println("send!! " +message);
		channel1.send(message).forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		;
	}
}
