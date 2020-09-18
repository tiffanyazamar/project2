package com.revature;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
	private static final Logger logger = LogManager.getLogger(Example.class);
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC813ac8e4b0f7510309f0f3e364131842";
  public static final String AUTH_TOKEN = "ca79862811243d32f36405050eb8f105";

  public static void main(String[] args) {
	  logger.info("Test Logger");
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+15719992107"),
        new PhoneNumber("+18507903359"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    System.out.println(message.getSid());
  }
}