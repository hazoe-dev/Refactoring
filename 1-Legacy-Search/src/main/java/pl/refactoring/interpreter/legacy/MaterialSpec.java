package pl.refactoring.interpreter.legacy;

public class MaterialSpec extends SpecDecorator {

    private EstateMaterial material;

    public MaterialSpec(Spec spec,EstateMaterial material) {
        super(spec);
        this.material = material;
    }

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public boolean check(RealEstate estate) {
        return estate.getMaterial().equals(material);
    }
}