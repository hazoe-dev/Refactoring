package pl.refactoring.interpreter.legacy;

public class PlacementSpec {
    private EstatePlacement placement;

    public PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    public boolean check(RealEstate estate) {
        return estate.getPlacement().equals(placement);
    }
}
