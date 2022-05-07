package Expert_System;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Regle {
    ArrayList<Character>Permise;
    ArrayList<Character>Action;

    public Regle(){
        this.Permise = new ArrayList<>();
        this.Action = new ArrayList<>();
    }

    //permet de decomposer la regle quelle a ete lu depuis le fichier des regles en partie permise et partie action
    public void Decomposer_Regle(String str) throws IOException {
        String permise,action;
        char c;

            if(str.contains("\r")){
                permise=str.substring(0,str.indexOf(">")-1);
                action=str.substring(str.indexOf(">")+1,str.indexOf("\r"));
                action=action.trim();

                while(permise.length()!=0){
                    if(permise.length()==1){
                        c=permise.charAt(0);
                        if(!this.Permise.contains(c)) {
                            this.Permise.add(c);
                        }
                        permise="";
                    }
                    else {
                        c = permise.charAt(permise.indexOf(",") - 1);
                        if(!this.Permise.contains(c)) {
                            this.Permise.add(c);
                        }
                        permise = permise.substring(permise.indexOf(",") + 1, permise.length());
                    }
                }

                while(action.length()!=0){
                    if(action.length()==1){
                        c = action.charAt(0);
                        if(!this.Action.contains(c)) {
                            this.Action.add(c);
                        }
                        action ="";
                        str="";
                    }
                    else {
                        c = action.charAt(action.indexOf(",") - 1);
                        if(!this.Action.contains(c)) {
                            this.Action.add(c);
                        }
                        action = action.substring(action.indexOf(",") + 1, action.length());
                    }
                }
            }
    }




    //afficher la partie permise ordone et partie action
    public void Print_Regle(){
        int j=0;
        for (char p:this.Permise) {
            System.out.println("l permise numero "+j+" = "+p);
            j++;
        }
        j=0;
        for (char r:this.Action) {
            System.out.println("l action numero "+j+" = "+r);
            j++;
        }

    }
}
























//    public void remplir_Regle(FileReader fr) throws IOException {
//        int i;
//        String str="",permise,action;
//        char c;
//        while ((i = fr.read()) != -1) {
//            if(str.contains("\r")){
//                permise=str.substring(0,str.indexOf(">")-1);
//                action=str.substring(str.indexOf(">")+1,str.indexOf("\r"));
//                action=action.trim();
//
//                while(permise.length()!=0){
//                    if(permise.length()==1){
//                        c=permise.charAt(0);
//                        if(!this.Permise.contains(c)) {
//                            this.Permise.add(c);
//                        }
//                        permise="";
//                    }
//                    else {
//                        c = permise.charAt(permise.indexOf(",") - 1);
//                        if(!this.Permise.contains(c)) {
//                            this.Permise.add(c);
//                        }
//                        permise = permise.substring(permise.indexOf(",") + 1, permise.length());
//                    }
//                }
//
//                while(action.length()!=0){
//                    if(action.length()==1){
//                        c = action.charAt(0);
//                        if(!this.Action.contains(c)) {
//                            this.Action.add(c);
//                        }
//                        action ="";
//                        str="";
//                    }
//                    else {
//                        c = action.charAt(action.indexOf(",") - 1);
//                        if(this.Action.contains(c)) {
//                            this.Action.add(c);
//                        }
//                        action = action.substring(action.indexOf(",") + 1, action.length());
//                    }
//                }
//            }
//            else{
//                str+=(char)i;
//            }
//        }
//        fr.close();
//    }