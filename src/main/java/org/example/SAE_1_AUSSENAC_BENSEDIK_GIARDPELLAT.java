package org.example;

import java.util.Scanner;

public class SAE_1_AUSSENAC_BENSEDIK_GIARDPELLAT{

    //FONCTIONS UTILITAIRES
    //AUSSENAC Thomas
    public static String afficherTabDouble(double[][] toujoursRatioCypris){
        String retour="";
        for(int i=0;i<toujoursRatioCypris.length;i++){
            for(int j=0;j<toujoursRatioCypris[0].length;j++)
                retour+=toujoursRatioCypris[i][j]+" | ";
            retour +="\n";
        }
        return retour;
    }

    public static int saisieInt(int min, int max, String message){
        Scanner scanner=new Scanner(System.in);
        System.out.println(message);
        int nb=scanner.nextInt();
        while(nb<min || nb>max){
            System.out.println(message);
            nb=scanner.nextInt();
        }
        return nb;
    }
    //AUSSENAC Thomas

    public static int saisieIntMin(int min, String message){
        Scanner scanner=new Scanner(System.in);
        System.out.println(message);
        int nb=scanner.nextInt();
        while(nb<min){
            System.out.println(message);
            nb=scanner.nextInt();
        }
        return nb;
    }


    //FONCTIONS EPREUVE
    //BENSEDIK Cypris

    public static int[][] saisieNbParticipants(){
        return new int[saisieInt(0,50,"Combien y a t'il de participants dans la course ? [0;50]")][2];
    }
    //GIARD--PERLLAT

    public static int saisieTailleCourse(){
        return saisieIntMin(0,"Quelle est la longueur de la piste ?");
    }

    public static int saisieNbObstacle(int longueurPiste){
        return saisieInt(0,longueurPiste/5, "Combien y a t'il d'obstacles ? [0;"+longueurPiste/5+"]");
    }

    public static int saisieNbBarres(int nbObstacles){
        return saisieInt(nbObstacles*2,nbObstacles*4,"Combien y a t'il de barres au total ? ["+nbObstacles*2+";"+nbObstacles*4+"]");
    }



    //FONCTIONS MANCHE 1

    public static void saisieTemps(int[][] tabTemps){

    }

    public static void saisieRefusChute(int[][] tabTemps,int nbBarres){
        for(int i=0;i<tabTemps.length;i++){
            if(saisieIntMin(0,"Combien de refus a-t'il subit ?")>2)
                tabTemps[i][1]=1;
            if(saisieIntMin(0,"Combien de fois est-il tombé ?")<0)
                tabTemps[i][1]=1;
        }
    }







    public static void main(String[] args){
        //SAISIE POUR EPREUVE
        int[][] tabTemps=saisieNbParticipants();
        int longueurPiste=saisieTailleCourse();
        int nbObstacles=saisieNbObstacle(longueurPiste);
        int nbBarres=saisieNbBarres(nbObstacles);

        //SAISIE MANCHE 1


    }
}