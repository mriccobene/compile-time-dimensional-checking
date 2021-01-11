package org.checkerframework.example;

import org.apache.commons.lang3.text.StrBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.UnitsTools;
import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.mPERs;
import org.checkerframework.checker.units.qual.s;

/**
 * If you run:
 *
 * <pre>mvn compile</pre>
 *
 * The build for this project should fail with a warning for the line:
 *
 * <pre>@NonNull Object nn = nullable;</pre>
 */
public class MavenExample {

    public static @Nullable Object nullable = null;

    public static void main(final String[] args) {
        System.out.println("Hello World!");

        StrBuilder stb = new StrBuilder();

        @NonNull Object nn = nullable; // error on this line
        System.out.println(nn);
    }

    public static void unitTest() {
        //@m int meters = 5 * UnitsTools.m;
        @m int meters = 5;
        @s int secs = 2 * UnitsTools.s;
        @mPERs int speed = meters / secs;

        @Latitude double lat = 0.0;
    }
}
