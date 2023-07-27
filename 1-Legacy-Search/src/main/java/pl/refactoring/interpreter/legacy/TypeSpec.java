package pl.refactoring.interpreter.legacy;

public class TypeSpec {
    private EstateType type;

    public TypeSpec(EstateType type) {
        this.type = type;
    }

    boolean checkType(RealEstate estate) {
        return estate.getType().equals(type);
    }
}
