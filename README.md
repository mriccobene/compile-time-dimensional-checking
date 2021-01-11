
# Compile-time unit dimension checking - Example

If you have a function that process geo referenced data, it is easy to inadvertently exchange arguments confusing latitude for longitude: in Java they are of type double, defining a custom type we incur in a high friction with the rest of the language.

```java
public static void geoprocessing(double latitude, double longitude) {
    // ...
}
```

But we can define custom annotation @Longitude and @Latitude and use the [checker framework](https://checkerframework.org/) to check consistent usage:

```java
// The function with annotated parameters
public static void geoprocessing(@Latitude double lat, @Longitude double lon) {
    // ...
}

// ...

// We define some variables with unit of measure attached using annotations
@SuppressWarnings("Latitude") @Latitude double lat = 0.0;       // @SuppressWarnings suppress @UnknownUnits warning
@SuppressWarnings("Longitude") @Longitude double lon = 0.0;

// Here the dev inadvertently reversed the arguments and we got a warning
geoprocessing(lon, lat);    // Warning: found @Longitude required @Latitude and viceversa
```

Checking this code with checker framework generate this:

> Warning: found @Longitude required @Latitude

The checker framework has built in unit of measure to do other consistency checking. See the example.








