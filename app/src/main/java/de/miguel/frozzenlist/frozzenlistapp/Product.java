package de.miguel.frozzenlist.frozzenlistapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

/**
 =================================================================================================
 @author Miguel Gutierrez, project FrozzenList
 @version 1.0Beta
 @param: Object initialize Product: Attributs: name,(variable)ProductID,FrozzenDate:Expirationdate
 to set date memory.
 @link Tray
 ================================================================================================
 */
public class Product {

    private String name;
    private double amount;
    private int pieces;
    private int durability;
    LocalDate frozzenDate;
    LocalDate frozzenDateAfter;


    //Instance

    public Product(String name, double amount, int pieces,  int durability) {
        this.name = name;
        this.amount=amount;
        this.pieces=pieces;
        this.frozzenDate= frozzenDate.now();
        this.durability=durability;

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
    public double amoutSum(){
        return amount= amount*(double)pieces;
    }
    public void setDurability(){
        this.durability=durability;
    }
    public int getDurability() {
        return durability;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDate setFrozzenDateAfter(){
        frozzenDateAfter = frozzenDate.plusMonths(durability);
        return frozzenDateAfter;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", ProductID="   +"]";
    }


}
