package com.wen.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 21up on 2020/9/20
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        String test []={"com.wen.annotation.Member"};
        for (String className:test){
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable==null){
                System.out.println("No dbtable annotations in class"+className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length()<1){
                tableName = cl.getName().toLowerCase();
            }
            List<String> cloumDefs=new ArrayList<String>();
            for (Field field:cl.getDeclaredFields()){
                String cloumName=null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length<1){
                    continue;
                }
                if (anns[0] instanceof SQLInteger){
                    SQLInteger sInt= (SQLInteger) anns[0];
                    if (sInt.name().length()<1){
                        cloumName=field.getName().toLowerCase();
                    }else {
                        cloumName=sInt.name();
                    }
                    cloumDefs.add(cloumName+" Int "+getConstrains(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString){
                    SQLString sString= (SQLString) anns[0];
                    if (sString.name().length()<1){
                        cloumName=field.getName().toUpperCase();
                    }else {
                        cloumName=sString.name();
                    }
                    cloumDefs.add(cloumName+" VARCHAR( "+sString.value()+")"+getConstrains(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String cloumDef:cloumDefs){
                    createCommand.append("\n    "+cloumDef+",");
                }
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table CreationSQL for "+className+" is :\n"+tableCreate);
            }
        }
    }
    private static String getConstrains(Constraints con) {
        String constraint="";
        if (!con.allowNull()){
            constraint+=" NOT NULL";
        }
        if (con.primaryKey()){
            constraint+=" Primary Key";
        }
        if (con.unique()){
            constraint+=" UNIQUE";
        }
        return constraint;
    }
}
