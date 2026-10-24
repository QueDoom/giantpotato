package net.quedoom.giant_potato.util.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks important distinctions between {@link MachineComponent}s. For example if the Slot Component is inputting or outputting
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ComparableComponentValue {
}
