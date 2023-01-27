package de.bentzin.hangar.api.service.v1;

import de.bentzin.hangar.api.base.HangarAPIVersion;
import de.bentzin.hangar.api.base.HangarInstance;
import de.bentzin.hangar.api.service.HangarAPIService;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public interface HangarAPIServiceV1 extends HangarAPIService {

    @Override
    default boolean supportsVersion(@NotNull HangarAPIVersion version) {
        return version.urlIdentifier().equals("v1/");
    }

    @Override
    default boolean supportsInstance(HangarInstance hangarInstance) {
        return true;
    }

    @Override
    @GET("authors?limit={limit}&offset={offset}")
    Call<List<RequestBody>> getAuthors(@Path("limit") int limit, @Path("limit") int offset);

    @Override
    @GET("authors?limit=99999999&offset=0")
    Call<ResponseBody> getAuthors();
}
