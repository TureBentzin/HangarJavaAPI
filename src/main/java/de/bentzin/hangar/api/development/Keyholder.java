package de.bentzin.hangar.api.development;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.security.Key;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public interface Keyholder {
    String key = "your key goes here (at least for this phase of testing)";
    String key();

    @Contract(pure = true)
    static @NotNull Keyholder testHolder() {
        return () -> key;
    }
}
