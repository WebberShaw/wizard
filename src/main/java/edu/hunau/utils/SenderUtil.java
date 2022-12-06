package edu.hunau.utils;

import org.springframework.stereotype.Component;


public interface SenderUtil {

    public static final int REGISTER_TEXT_MESSAGE_CODE=1;
    public static final int OTHER_TEXT_MESSAGE_CODE=0;
    boolean sendEmail(String to,String title,String text);

    boolean sendTextMessage(String to,int code,int type);

//    boolean sendRegisterTextMessage(String to,String code);


}
