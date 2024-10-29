package org.example;

import com.google.gson.Gson;
import org.example.model.Seller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        System.out.println(getBestSeller(converterJsonByObject()));
    }

    public static Seller[] converterJsonByObject() {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(
                Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("seller.json")))) {
            return gson.fromJson(reader, Seller[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Seller getBestSeller(Seller[] sellers) {
        Seller seller = new Seller("", 0.0);

        for(int i=0; i<sellers.length; i++) {
            if(sellers[i].getAmount() > seller.getAmount()) {
                seller = sellers[i];
            }
        }
        return seller;
    }
}