package de.bentzin.hangar.api;

import retrofit2.Retrofit;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class HangarJavaAPI {

    public HangarJavaAPI() {

    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();


    }

}
