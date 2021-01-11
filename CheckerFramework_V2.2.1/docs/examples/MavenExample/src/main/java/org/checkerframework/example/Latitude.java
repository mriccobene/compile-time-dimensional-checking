package org.checkerframework.example;

import com.sun.javafx.geom.transform.BaseTransform;
import org.checkerframework.checker.units.qual.Angle;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({Angle.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface Latitude {
}
