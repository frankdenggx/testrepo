package edu.frank;


import java.nio.charset.Charset; 
import java.util.*; 

/** 
* JRE 
* 
* @author Administrator 2009-11-28 17:48:42 
*/ 
public class JVMInfoToolkit { 
        public static void main(String[] args) { 
                System.out.println("JRE" + System.getProperty("java.version")); 
                System.out.println("JVM" + Charset.defaultCharset()); 
                System.out.println("JRE\n" + genJVMCharset()); 
                System.out.println("JVM\n" + genJVMProperties()); 

        } 

        /** 
         * JVM:[...] 
         * 
         * @return  
         */ 
        public static String genJVMCharset() { 
                StringBuilder sb = new StringBuilder(); 
                SortedMap<String, Charset> map = Charset.availableCharsets(); 
                for (Map.Entry<String, Charset> entry : map.entrySet()) { 
                        sb.append(entry.getKey()).append(":").append(entry.getValue().aliases()).append("\n"); 
                } 
                return sb.toString(); 
        } 

        /** 
         * JVM, 
         * 
         * @return  
         */ 
        public static String genJVMProperties() { 
                StringBuilder sb = new StringBuilder(); 
                Properties props = System.getProperties(); 
                List<String> keylist = new ArrayList<String>(); 
                for (Object o : props.keySet()) { 
                        keylist.add(o.toString()); 
                } 
                Collections.sort(keylist, String.CASE_INSENSITIVE_ORDER); 
                for (String s : keylist) { 
                        sb.append(s).append("=").append(props.get(s)).append("\n"); 
                } 
                return sb.toString(); 
        } 
}