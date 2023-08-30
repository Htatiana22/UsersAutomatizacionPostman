package com.postman.utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class UserData {
    private  static ArrayList<Map<String, String>> dataUser= new ArrayList<>();

    public static ArrayList<Map<String, String>> extractTo(){
        try {
            dataUser= Excel.leerDatosDeHojaDeExcel("src/main/resources/DataExcel/ApiUserData.xlsx","DataUser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataUser;

    }
}
