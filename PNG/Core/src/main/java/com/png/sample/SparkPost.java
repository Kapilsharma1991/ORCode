/**
 * 
 */
package com.png.sample;

import java.util.ArrayList;
import java.util.List;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

/**
 * @author Manish Arora
 *
 */
public class SparkPost {

    public static void main(String[] args) throws SparkPostException {
        String API_KEY = "332b6ea4a3c53e8dd8623c0380ec4af700c076c4";
        Client client = new Client(API_KEY);
        
        List<String> recipients = new ArrayList<String>(); 
        /*recipients.add("manish.arora83@gmail.com");
        recipients.add("richu3010@gmail.com");
        recipients.add("mattakunal@gmail.com ");
        recipients.add("himani.arora88@gmail.com");
        recipients.add("2kapilsharma1991@gmail.com");
        recipients.add("sausha80@gmail.com");*/
        recipients.add("rickysahota88@gmail.com");
       // recipients.add("nikhil10apr@gmail.com");

        client.sendMessage(
                "RentOrRent@rentorrent.com",
                recipients,
                "Coming Soon !!",
                "The text part of the email",
                "<b>We Are Coming Soon !!!   Please do not reply back, this mail box is not monitored yet.</b> </br> </br> <img src='http://www.rentorrent.com/icons/uc.jpg' href='www.rentorrent.com' />");

    }
}
