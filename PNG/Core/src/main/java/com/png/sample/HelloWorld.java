package com.png.sample;

public class HelloWorld {

			
		   private String message;

		   public void setMessage(String message){
		      this.message  = message;
		   }

		   public void getMessage(){
		      System.out.println("Your Message (HelloWorld) : " + message);
		   }

		   public void init(){
		      System.out.println("HelloWorld Bean is going through init.");
		   }

		   public void destroy(){
		      System.out.println("HelloWorld Bean will destroy now.");
		   }
		
}
