package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.RealEstate;

/**
 * @author tqvu
 */
public interface Spec {
    boolean check(RealEstate estate);
}
