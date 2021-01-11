package org.checkerframework.custom.units;

import org.checkerframework.checker.units.qual.Angle;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({Angle.class})                                       // todo: Angle o degree?
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface Latitude {
}
