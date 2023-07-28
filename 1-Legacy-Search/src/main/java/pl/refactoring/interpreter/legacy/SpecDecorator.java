package pl.refactoring.interpreter.legacy;

import pl.refactoring.interpreter.legacy.spec.BasicSpec;
import pl.refactoring.interpreter.legacy.spec.Spec;

public class SpecDecorator implements Spec {
    Spec wrappee;

    public SpecDecorator() {
        wrappee = new BasicSpec();
    }
    public SpecDecorator(Spec wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public boolean check(RealEstate estate) {
        return wrappee.check(estate) ;
    }
}
