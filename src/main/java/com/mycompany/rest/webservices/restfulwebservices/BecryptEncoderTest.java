package com.mycompany.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BecryptEncoderTest
{

  public static void main(String[] args) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPass=encoder.encode("password");
    System.out.println(encodedPass);
  }

}
