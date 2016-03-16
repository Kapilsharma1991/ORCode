package com.png.sample;

public class MyWorld {

			
		   private String message;

		   public void setMessage(String message){
		      this.message  = message;
		   }

		   public void getMessage(){
		      System.out.println("Your Message (MyWorld ): " + message);
		   }

		   public void init(){
		      System.out.println("MyWorld Bean is going through init.");
		   }

		   public void destroy(){
		      System.out.println("MyWorld Bean will destroy now.");
		   }
		
}
