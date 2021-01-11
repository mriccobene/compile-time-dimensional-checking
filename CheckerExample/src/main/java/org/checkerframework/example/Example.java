package org.checkerframework.example;

import org.checkerframework.checker.units.UnitsTools;
import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.mPERs;
import org.checkerframework.checker.units.qual.s;
import org.checkerframework.custom.units.Latitude;
import org.checkerframework.custom.units.Longitude;

import java.util.HashMap;
import java.util.Map;

/**
 * If you run:
 *
 * <pre>mvn compile</pre>
 *
 * The build for this project should fail with some warnings on incorrect unit of measure usage
 * see comments
 *
 */
public class Example {

    public static void geoprocessing(@Latitude double lat, @Longitude double lon) {
        // ...
    }

    public static void main(final String[] args) {
        // We define some variables with unit of measure attached with annotations
        @m int meters = 5;                      // Warning: @UnknownUnits, required @m | correct assignment: @m int meters = 5 * UnitsTools.s
        @s int secs = 2 * UnitsTools.s;         // Ok

        // Here the cheker correcly checks the unit of measure of speed
        @mPERs int speed = meters / secs;       // Ok

        // We define some variables with unit of measure attached with annotations
        @SuppressWarnings("Latitude") @Latitude double lat = 0.0;       // Ok, @SuppressWarnings suppress @UnknownUnits warning
        @SuppressWarnings("Longitude") @Longitude double lon = 0.0;     // Ok

        // Here the dev inadvertently reversed the arguments and we got a warning
        geoprocessing(lon, lat);    // Warning: found @Longitude required @Latitude and viceversa

        // We can even attach a unit of measure annotation to the key of a map ...
        Map<@Latitude Double,String> m = new HashMap<>();

        // ... and the checker check new element addition:
        m.put(lat,"ok");            // Ok
        m.put(lon,"wrong!");        // Warning: found @Longitude required @Latitude

    }

}
