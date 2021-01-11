package org.checkerframework.custom.units;

import org.checkerframework.checker.units.qual.Speed;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

// knot (kn) = 1 nautical mile per hour

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf({Speed.class})
public @interface kn {
}
