
package Morph_Frame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.nutch.analysis.unl.ta.Analyser;


public class Morph_Analyzer_Tool {
     public static void main(String args[]) throws IOException

    {
        String str = "", an3 = "",an;
        BufferedReader inputfile = new BufferedReader(new FileReader("F:\\Project\\fyp project\\Morphological-Analyzer-For-Tamil-master\\src\\Morph_Frame\\input.txt"));
        String temp="";
        StringBuffer sb= new StringBuffer();
         while ((temp = inputfile.readLine()) != null) {
        
        String tempsplit[]=temp.split(" ");
        
        for(String strrr:tempsplit){
         ArrayList rs = new Analyser().onlineDictAnalyser(strrr);
          an3 = rs.get(2).toString();
                String an2 =rs.get(3).toString();
                String an1 =rs.get(1).toString();
                String an4 =rs.get(0).toString();
                
//                System.out.println("ans "+an3.toString());
//                System.out.println("two "+an2);
//                System.out.println("three "+an1);
//                System.out.println("four "+ an4);
                sb.append(strrr+"##"+an1+"##"+an2+"@@");
                
        }
         }
         System.out.println(sb.toString());
         BufferedWriter op2 = new BufferedWriter(new FileWriter(new File("F:\\Project\\fyp project\\Morphological-Analyzer-For-Tamil-master\\src\\Morph_Frame\\output.txt")));
         String out = sb.toString().replace(sb.toString().substring(sb.toString().length()-2), "");
         op2.write(out);
         op2.close();
     
}
}