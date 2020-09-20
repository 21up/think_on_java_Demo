package com.wen.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 21up on 2020/9/20
 */
public class UseCaseTracker {
    public static void main(String[] args) {
        List<Integer> userCases=new ArrayList<Integer>();
        Collections.addAll(userCases,47,48,49,50);
        trackUseCases(userCases,PassWordUtils.class);
    }
    public  static void trackUseCases(List <Integer> useCases,Class<?> cl){
        for (Method m:cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc!=null){
                System.out.println("Found UseCase:"+uc.id()
                +"  "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i:useCases){
            System.out.println("Warning: Missing use case-"+i);
        }
    }
}
