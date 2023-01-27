package de.bentzin.hangar.api.service;

import de.bentzin.hangar.api.base.HangarAPIVersion;
import de.bentzin.hangar.api.base.HangarInstance;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.List;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public interface HangarAPIService {

    //checkers
    boolean supportsVersion(HangarAPIVersion version);

    boolean supportsInstance(HangarInstance hangarInstance);

    default boolean supports(HangarAPIVersion version, HangarInstance hangarInstance) {
        return supportsInstance(hangarInstance) && supportsVersion(version);
    }

    void setupRetrofit(Retrofit retrofit);

    //now to Retrofit

    Call<List<RequestBody>> getAuthors(int limit, int offset);

    Call<ResponseBody> getAuthors();
}
