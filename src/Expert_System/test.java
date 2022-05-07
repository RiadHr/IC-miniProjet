package Expert_System;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


// Class
class test{


    public static void remplir_Regle(ArrayList<Regle>tab,FileReader fr) throws IOException {
        int i= fr.read();
        String str="";
        Regle r;

        do{
            if(str.contains("\r") && str.length()>2){
                r=new Regle();
                r.Decomposer_Regle(str);
                tab.add(r);
                str="";
            }
            else{
                str+=(char)i;
            }
        }while((i=fr.read())!=-1);
    }


    public static void Chainage_Avant(Fait f,ArrayList<Regle>r){
        int cpt,size_regle=r.size(),size_fait=f.fait.size(),size_action,size_permise;


        do{
            for (int i=0;i<size_regle;i++){
                size_permise=r.get(i).Permise.size();
                size_action=r.get(i).Action.size();
                ArrayList<Boolean>b=new ArrayList<>();
                cpt=0;

                for (int j=0;j<size_fait;j++){

                    if(r.get(i).Permise.contains(f.fait.get(j))){
                        b.add(true);
                        cpt++;

                        if(b.size()==size_permise){
                            for (int w=0;w<size_action;w++){
                                if(!f.fait.contains(r.get(i).Action.get(w))) {
                                    f.fait.add(r.get(i).Action.get(w));
                                    size_fait++;
                                }
                            }
                            System.out.println("================== Regle est desactive =================");
                            r.get(i).Print_Regle();
                            System.out.println("\n");
                            r.remove(r.get(i));
                            size_regle--;
                            j=size_fait;
                        }
                    }
                }
            }
        }while(size_regle!=0);
    }


    public static ArrayList<Regle>Chercher_Regle(char action,ArrayList<Regle>tab){
        ArrayList<Regle>t=new ArrayList<>();
        for (Regle r: tab) {
            if(r.Action.contains(action)){
                t.add(r);
            }
        }
        return t;
     }


    public static boolean Chainage_Arriere(ArrayList<Regle>tab,Fait f,char c) {


        if (f.fait.contains(c)) {
            System.out.println("la action prouver est "+c);
            return true;
        }
        else {
            ArrayList<Regle> t = Chercher_Regle(c, tab);
            for (Regle r : t) {
                boolean b = true;
                for (char s : r.Permise) {
                    b &= Chainage_Arriere(tab, f, s);
                    if (!b) {
                        break;
                    }
                }
                if (!b) {
                    continue;
                }
                else {
                    f.fait.add(c);
                    System.out.println("la action prouver est "+c);
                    return true;
                }
            }
        }
       return false;
    }








    public static void Print_Regle(ArrayList<Regle>tab){
        int j=0;
        for (Regle r: tab) {
            System.out.println("la regle numero "+j+" est=====================================");
            j++;
            r.Print_Regle();
        }
    }




    // Main driver method ==============================================================================================
    public static void main(String[] args) throws IOException {

            //declaration des variables ================================================================================
            FileReader fr = new FileReader("C:\\Users\\Riad\\Desktop\\ic_mini_Projet\\src\\Expert_System\\BaseRegle.txt");
            int nombre_fait;
            int n;


            //remplir la liste des fait ================================================================================
            Fait fait = new Fait();
            Scanner reader = new Scanner(System.in);


            System.out.println("entrer le nombre des fait");
            nombre_fait=reader.nextInt();
            fait.Remplir_Fait(nombre_fait);

            // Remplir la liste des regle ==============================================================================
            ArrayList<Regle>r = new ArrayList<>();
            remplir_Regle(r,fr);
            Print_Regle(r);

            //Choisir le type de chainage ==============================================================================
            System.out.println("entrer un nombre=====================\n"+
                               "1 pour chainage avant\n"+
                               "2 pour chainage arriere\n");
            n=reader.nextInt();

            if(n==1) {
                Chainage_Avant(fait, r);
                fait.Afficher_Fait();
            }
            else if(n==2){
                char c;
                System.out.println("entrer le fait que vous voulez le prouver");
                c=reader.next().charAt(0);
                Chainage_Arriere(r,fait,c);
                fait.Afficher_Fait();
            }
      }
}




























//        int cpt=0;
//        do{
//            for (Regle r1:r){
//                for (char f1:f.fait) {
//                    if(r1.Permise.contains(f1)){
//                        cpt++;
//                        if(cpt== f.fait.size()){
//                            for (int i=0;i<r1.Action.size();i++){
//                                f.fait.add(r1.Action.get(i));
//                            }
//                            r.remove(r1);
//                            cpt=0;
//                        }
//
//                    }
//                }
//            }
//        }while(r.size()!=0);