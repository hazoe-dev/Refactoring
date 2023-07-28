package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.EstateType;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.SpecDecorator;
import pl.refactoring.interpreter.legacy.spec.Spec;

public class TypeSpec extends SpecDecorator {
    private EstateType type;

    public TypeSpec(EstateType type) {
        this.type = type;
    }

    public TypeSpec(Spec spec, EstateType type) {
        super(spec);
        this.type = type;
    }

    public boolean check(RealEstate estate) {
        return super.check(estate) && estate.getType().equals(type);
    }
}
