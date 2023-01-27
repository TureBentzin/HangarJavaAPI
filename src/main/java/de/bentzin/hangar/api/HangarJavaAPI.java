package de.bentzin.hangar.api;

import de.bentzin.hangar.api.base.HangarAPIVersion;
import de.bentzin.hangar.api.base.HangarInstance;
import de.bentzin.hangar.api.development.Keyholder;
import de.bentzin.hangar.api.service.HangarAPIService;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class HangarJavaAPI {

    private final Retrofit retrofit;
    private final HangarInstance instance;
    private final HangarAPIVersion version;

    public HangarJavaAPI(Keyholder keyholder, @NotNull HangarInstance hangarInstance, @NotNull HangarAPIVersion hangarAPIVersion) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        final String connectionURL = hangarAPIVersion.appendFromInstance(hangarInstance);

        builder.baseUrl(connectionURL);
        //builder.addConverterFactory(GsonConverterFactory.create());

        version = hangarAPIVersion;
        instance = hangarInstance;
        retrofit = builder.build();
    }

    @ApiStatus.Internal
    @ApiStatus.Experimental
    protected Retrofit getRetrofit() {
        return retrofit;
    }

    public HangarAPIService getService() {
        return retrofit.create(getVersion().recommendedService());
    }

    public HangarAPIVersion getVersion() {
        return version;
    }

    public HangarInstance getInstance() {
        return instance;
    }
}
