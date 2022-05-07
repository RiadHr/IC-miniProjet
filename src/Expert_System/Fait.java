package Expert_System;



import java.util.ArrayList;
import java.util.Scanner;

public class Fait {
    ArrayList<Character>fait;

    public Fait(){
        this.fait=new ArrayList<>();
    }

    public void Remplir_Fait(int n){
        char chr;

        for(int j=0; j < n ; j++){
            System.out.println("entrer un fait");
            Scanner reader = new Scanner(System.in);
            chr=reader.next().charAt(0);
            this.fait.add(chr);
        }

    }


    public void Afficher_Fait(){
        int j=0;
        for (char f: fait) {
            System.out.println("le fait numero "+j+" = "+f);
            j++;
        }
    }
}
