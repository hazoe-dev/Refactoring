package pl.refactoring.interpreter.legacy;

public class TypeSpec {
    private EstateType type;

    public TypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean check(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
