package edu.hunau.utils;

import edu.hunau.model.User;

public class UserDesensitizationUtil {
    public static User desensitize(User user){
        user.setPassword(null);
        user.setTel(null);
        user.setEmail(null);
        user.setCreatTime(null);
        user.setUpdateTime(null);
        return user;
    }


}
