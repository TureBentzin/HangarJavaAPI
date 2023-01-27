package de.bentzin.hangar.api.base;

import de.bentzin.hangar.api.service.HangarAPIService;
import de.bentzin.hangar.api.service.v1.HangarAPIServiceV1;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public interface HangarAPIVersion {

    HangarAPIVersion v1 = new HangarAPIVersion() {
        @Contract(pure = true)
        @Override
        public @NotNull String name() {
            return "Version 1";
        }

        @Contract(pure = true)
        @Override
        public @NotNull String urlIdentifier() {
            return "v1/";
        }

        @Override
        public Class<? extends HangarAPIService> recommendedService() {
            return HangarAPIServiceV1.class;
        }
    };

    String name();

    String urlIdentifier();

    Class<? extends HangarAPIService> recommendedService();

    default Function<String, String> identifierAppender() {
        return s -> s + urlIdentifier();
    }

    default String append(String baseUrl) {
        return identifierAppender().apply(baseUrl);
    }

    default String appendFromInstance(@NotNull HangarInstance instance) {
        return append(instance.apiURL());
    }
}
