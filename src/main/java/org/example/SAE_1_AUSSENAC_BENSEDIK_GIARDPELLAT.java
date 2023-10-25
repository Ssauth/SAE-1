package org.example;

import java.util.Scanner;

public class SAE_1_AUSSENAC_BENSEDIK_GIARDPELLAT{

    //FONCTIONS UTILITAIRES

    //Cette fonction permet d'afficher le contenue d'un tableau d'entier sous forme d'un String (servait pour les tests)
    //Il prend en paramètre un tableau d'entier
    // AUSSENAC Thomas
    public static String afficherTabInt(int[][] toujoursRatioCypris){
        String retour="";
        for(int i=0;i<toujoursRatioCypris.length;i++){
            for(int j=0;j<toujoursRatioCypris[0].length;j++)
                retour+=toujoursRatioCypris[i][j]+" | ";
            retour +="\n";
        }
        return retour;
    }
    //Cette fonction permet une saisie controlé avec un minimum et un maximum accompagner d'un String pour demander une donnée précise à l'utilisateur
    //Paramètres : entier minimum, entier maximum et une chaine de caractère pour le message affiché
    // AUSSENAC Thomas
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
    //Cette fonction permet une saisie controlé avec un minimum accompagner d'un String pour demander une donnée précise à l'utilisateur
    //Paramètres : entier minimum et une chaine de caractère pour le message affiché
    // AUSSENAC Thomas
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

    //Cette méthode demande la saisie d'un entier entre 0 et 50 puis renvoi un tableau à double entrée de taille [n][2]
    //Cette méthode n'a pas de paramètres et renvoie un tableau d'entier
    //BENSEDIK Cypris
    public static int[][] saisieNbParticipants(){
        return new int[saisieInt(0,50,"Combien y a t'il de participants dans la course ? [0;50]")][2];
    }


    //GIARD--PERLLAT

    public static int saisieTailleCourse(){
        return saisieIntMin(0,"Quelle est la longueur de la piste ?");
    }

    // AUSSENAC Thomas
    public static int saisieNbObstacle(int longueurPiste){
        return saisieInt(0,longueurPiste/5, "Combien y a t'il d'obstacles ? [0;"+longueurPiste/5+"]");
    }

    public static int saisieNbBarres(int nbObstacles){
        return saisieInt(nbObstacles*2,nbObstacles*4,"Combien y a t'il de barres au total ? ["+nbObstacles*2+";"+nbObstacles*4+"]");
    }




    //FONCTIONS MANCHES

    // AUSSENAC Thomas
    public static void saisieRefusChute(int[][] tabTemps, int nbManche){
        for(int i=0;i<tabTemps.length;i++){
            if(tabTemps[i][1]==0){
                if(saisieIntMin(0, "Lors de la "+(nbManche==1 ? "première " : "seconde ")+"manche, combien de refus le numéro "+i+" a-t'il subit ?")>2)
                    tabTemps[i][1]=1;
                if(saisieIntMin(0, "Lors de la "+(nbManche==1 ? "première " : "seconde ")+"manche, combien de fois le numéro "+i+" est-il tombé ?")<0)
                    tabTemps[i][1]=1;
            }
        }
    }

    // AUSSENAC Thomas
    public static void saisieNbBarresTombes(int[][] tabTemps,int nbBarres, int nbManche){
        for(int i=0;i<tabTemps.length;i++)
            if(tabTemps[i][1]==0){
                tabTemps[i][0]+=saisieInt(0, nbBarres, "Lors de la "+(nbManche==1 ? "première " : "seconde ")+"manche, combien de barres le numéro"+i+" a-t'il fait tombé ?")*8000;
            }
    }

    // AUSSENAC Thomas
    public static void saisieTemps(int[][] tabTemps, int longueurPiste, int nbManche){
        int tempsManche;
        for(int i=0;i<tabTemps.length;i++){
            if(tabTemps[i][1]==0){
                tabTemps[i][0]+=saisieIntMin(0, "Lors de la "+(nbManche==1 ? "première " : "seconde ")+"manche ,quel temps le numéro "+i+"a t'il fait ? (en millisecondes");
                if((longueurPiste<600 && tabTemps[i][0]>120000) || (longueurPiste>=600 && tabTemps[i][0]>180000))
                    tabTemps[i][1]=1;
            }
        }
    }


    // AUSSENAC Thomas
    public static void afficheResultatsManche1(int[][] tabTemps){
        for(int i=0;i<tabTemps.length;i++){
            System.out.println("Le numéro "+i+" a éffectué un temps de "+tabTemps[i][0]+" et "+(tabTemps[i][1]==1 ? "est éliminé." : "passe à la deuxième manche !"));
        }
    }

    //PODIUM


    // AUSSENAC Thomas
    public static void afficherPodium(int[][] tabTemps){
        int nb1 = 360001,nb2 = 360001,nb3 = 360001, compteur=0;
        String retour="A la première place ce trouve : ";
        for(int i=0;i<tabTemps.length;i++){
            if(tabTemps[i][0]<nb3){
                if(tabTemps[i][0]<nb2){
                    if(tabTemps[i][0]<nb1){
                        nb3=nb2;
                        nb2=nb1;
                        nb1=tabTemps[i][0];
                    }else {
                        nb3=nb2;
                        nb2=tabTemps[i][0];
                    }
                }else {
                    nb3=tabTemps[i][0];
                }
            }
        }

        //Gestion des cas d'égalités
        for(int i=0;i<tabTemps.length;i++){
            if(tabTemps[i][0]==nb1){
                retour+=i+" ";
                compteur++;
            }
        }
        if(compteur<3){
            retour+="\nA la seconde place ce trouve : ";
            for(int i=0;i<tabTemps.length;i++){
                if(tabTemps[i][0]==nb2){
                    retour+=i+" ";
                    compteur++;
                }
            }
        }
        if(compteur<3){
            retour+="\nA la troisième place ce trouve : ";
            for(int i=0;i<tabTemps.length;i++){
                if(tabTemps[i][0]==nb3){
                    retour+=i+" ";
                }
            }
        }
        System.out.println(retour);
    }







    public static void main(String[] args){
        //SAISIE POUR EPREUVE
        int[][] tabTemps=saisieNbParticipants();
        int longueurPiste=saisieTailleCourse();
        int nbObstacles=saisieNbObstacle(longueurPiste);
        int nbBarres=saisieNbBarres(nbObstacles);

        //SAISIE MANCHE 1
        System.out.println("Début de la première mannche.");
        saisieTemps(tabTemps, longueurPiste,1);
        saisieRefusChute(tabTemps,1);
        saisieNbBarresTombes(tabTemps, nbBarres,1);

        //AFFICHAGE RESULTATS MANCHE 1
        afficheResultatsManche1(tabTemps);

        //SAISIE MANCHE 2
        System.out.println("Début de la seconde mannche.");
        saisieTemps(tabTemps, longueurPiste,2);
        saisieRefusChute(tabTemps,2);
        saisieNbBarresTombes(tabTemps, nbBarres,2);

        //AFFICHAGE PODIUM
        afficherPodium(tabTemps);










    }
}