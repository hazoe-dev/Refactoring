package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.SpecDecorator;

public class MaterialSpec extends SpecDecorator {

    private EstateMaterial material;

    public MaterialSpec(Spec spec, EstateMaterial material) {
        super(spec);
        this.material = material;
    }

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public boolean check(RealEstate estate) {
        return super.check(estate) && estate.getMaterial().equals(material);
    }
}