package pl.refactoring.interpreter.legacy;

public class PlacementSpec implements Spec{
    private EstatePlacement placement;
    private boolean shouldAvoid;

    public PlacementSpec(EstatePlacement placement, boolean shouldAvoid) {
        this.placement = placement;
        this.shouldAvoid = shouldAvoid;
    }

    public boolean check(RealEstate estate) {
        return estate.getPlacement().equals(placement) && shouldAvoid;
    }
}
