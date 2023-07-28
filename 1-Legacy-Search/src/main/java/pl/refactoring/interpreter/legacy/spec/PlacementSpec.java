package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.EstatePlacement;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.SpecDecorator;

public class PlacementSpec extends SpecDecorator {
    private EstatePlacement placement;
    private boolean shouldAvoid;
    public PlacementSpec( EstatePlacement placement, boolean shouldAvoid) {
        this.placement = placement;
        this.shouldAvoid = shouldAvoid;
    }

    public PlacementSpec(Spec spec, EstatePlacement placement, boolean shouldAvoid) {
        super(spec);
        this.placement = placement;
        this.shouldAvoid = shouldAvoid;
    }

    private boolean check(EstatePlacement inputPlacement, boolean shouldAvoid){
        if(shouldAvoid){
            return !inputPlacement.equals(placement);
        }else{
            return inputPlacement.equals(placement);
        }
    }
    public boolean check(RealEstate estate) {
        return super.check(estate) && check(estate.getPlacement(), shouldAvoid);
    }
}
