package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.RealEstate;

public class BasicSpec implements Spec {
    @Override
    public boolean check(RealEstate estate) {
        return true;
    }
}
