package pl.refactoring.interpreter.legacy;

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
