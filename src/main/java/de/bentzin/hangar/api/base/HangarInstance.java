package de.bentzin.hangar.api.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public interface HangarInstance {
    String baseURL();

    default String apiURL() {
        return baseURL() + "api/";
    }

    Type type();

    enum Type {
        STAGING, PRODUCTION, LOCAL, FORK
    }

    HangarInstance stagingInstance = new HangarInstance() {

        @Contract(pure = true)
        @Override
        public @NotNull String baseURL() {
            return "https://hangar.papermc.dev/";
        }

        @Override
        public Type type() {
            return Type.STAGING;
        }

    };
}
