package com.company.Utility;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * Created by marcos on 13/06/2015.
 */


public class DbSession {
        public static class session {
                public static void beginTransaction() {

                }
                public static void endTransaction(){
                        //Equvalente a: session.getTransaction.commit();

                }

                public static void save(){

                }

                public static void delete(){

                }
                public static void get(String clase, String id){

                }


        };
}
