package com.frame.util;

import java.util.List;

public class ListToString {
    public static String listToString(List list) {
        if(list==null||list.size()==0)return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
