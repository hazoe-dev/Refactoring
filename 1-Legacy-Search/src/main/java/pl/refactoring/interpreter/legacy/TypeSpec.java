package pl.refactoring.interpreter.legacy;

public class TypeSpec {
    static boolean checkType(EstateType type, RealEstate estate) {
        return estate.getType().equals(type);
    }
}
