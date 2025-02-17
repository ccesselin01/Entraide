/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.trelange.calcul;

/**
 *
 * @author tomrelange
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Mur
{
    
    Coin debut, fin ;
    int idMur ;
    static int next_mur;
    Revetement revetement_mur;
    double hauteur ;
    private static Map<Integer, Mur> murMap = new HashMap<>() ;


    public Mur(Coin debut, Coin fin, Revetement revetement,double hauteur ) 
    {
        this.debut = debut;
        this.fin = fin;
        this.idMur = next_mur++;
        this.revetement_mur = revetement;
        
        this.hauteur = hauteur;
        murMap.put(this.idMur, this);
        System.out.println("Mur ajouté avec succes");
        
        
    }
    
    public static Mur getMur(int idMur) {
        return murMap.get(idMur) ;
    }
    
    public double longueur() {
        return Math.sqrt(Math.pow((debut.getX()-fin.getX()),2)+Math.pow(debut.getY()-fin.getY(), 2));
    }
    
    public double surface() {
        
        return this.longueur()*this.hauteur;
    }

    public Coin getDebut() {
        return debut;
    }

    public Coin getFin() {
        return fin;
    }

    public int getIdMur() {
        return idMur;
    }

    public Revetement getRevetement_mur() {
        return revetement_mur;
    }

    public static Map<Integer, Mur> getmurMap() {
        return murMap;
    }
    
    

    @Override
    public String toString() {
        return "Mur " + idMur + " " +  debut + " " + fin + " " + revetement_mur.getId() + " " + hauteur ;
    }

       
    
    
    public double devis_Mur (){
        double devis_mur= this.surface()*this.revetement_mur.prixunitaire;
        return devis_mur;
        
    }
}
