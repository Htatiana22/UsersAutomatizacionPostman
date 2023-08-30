package com.postman.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DeleteData {
    private  static ArrayList<Map<String, String>> dataDelete= new ArrayList<>();

    public static ArrayList<Map<String, String>> extractTo(){
        try {
            dataDelete= Excel.leerDatosDeHojaDeExcel("src/main/resources/DataExcel/ApiUserData.xlsx","DeleteDataUser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataDelete;

    }
}

