/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doynekodz4;

/**
 *
 * @author yulia
 */
import java.io.*;



public class Car implements Externalizable {

    String brand;
    String model;
    int year;
    double price;
    boolean isAutomatic;
    
    private static final long serialVersionUID = 1L;
     
    public Car() {
    } 
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(brand);
        out.writeObject(model);
        out.writeInt(year);
        out.writeDouble(price);
        out.writeBoolean(isAutomatic);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        brand = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
        price = in.readDouble();
        isAutomatic = in.readBoolean();
    }
}