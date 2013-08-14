/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.test;

import com.exception.magicsnumbersws.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fpimentel
 */
public class Test {
    public static void main(String[] args){
              ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
      UserServiceImpl user = (UserServiceImpl)ctx.getBean("userService");
      System.out.println("Paso bien!");
    }
}
