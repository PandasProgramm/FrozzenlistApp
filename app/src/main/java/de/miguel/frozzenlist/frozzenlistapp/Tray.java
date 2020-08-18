package de.miguel.frozzenlist.frozzenlistapp;

import java.util.ArrayList;
import java.util.HashMap;

/**  ===========================================================================
 @author Miguel Gutierrez, project FrozzenList
 @version 1.0Beta
 @param: get Key producttype to add Product, remove Product , change Product,
 producttype add manually: addProduct ,remove Product
 @link Freezer
 ===========================================================================
 */

public class Tray {

    private HashMap<String, ArrayList<Product>> producttypes = new HashMap<>();
    //Instance
    public Tray() {

        producttypes.put("Vegetables", new ArrayList<Product>());
        producttypes.put("Beef", new ArrayList<Product>());         //Meat variety
        producttypes.put("Pork", new ArrayList<Product>());
        producttypes.put("Poultry", new ArrayList<Product>());
        producttypes.put("Calf", new ArrayList<Product>());
        producttypes.put("Lamb", new ArrayList<Product>());
        producttypes.put("Vinison", new ArrayList<Product>());      //other typs
        producttypes.put("Fruit", new ArrayList<Product>());
        producttypes.put("Ice", new ArrayList<Product>());
        producttypes.put("Sauces", new ArrayList<Product>());
        producttypes.put("Meals", new ArrayList<Product>());
        producttypes.put("other", new ArrayList<Product>());
    }

    protected void producttypeAdd(String value) {
        if (!producttypes.containsKey(value)) {
            producttypes.put(value, new ArrayList<Product>());
        }
        else{
            //Toast
        }
    }

    public String getHashList(Product product) {
        for (int i = 0; i < producttypes.size(); i++) {
            return producttypes.toString();
        }return null;
    }
    public void addProduct(Product product,String value){


        if (producttypes.containsKey(value)) {
            producttypes.get(value).add(product);
        }
        else{
            producttypeAdd(value);
            addProduct(product,value);
        }
    }
    public void removeProduct(String value, Product product) {
        if(producttypes.containsKey(value)&&producttypes.equals(product)){
            producttypes.get(value).remove(product);
        }else {
            //Toast: no product to remove
        }
    }
    public void changeProduct(String value,Product product) {
        if(producttypes.containsKey(value)&&producttypes.containsValue(product)) {
            producttypes.get(value).remove(product);
            producttypes.get(value).add(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tray tray = (Tray) o;
        return producttypes.equals(tray.producttypes);
    }
}
