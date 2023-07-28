package pl.refactoring.interpreter.legacy.spec;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.SpecDecorator;

/**
 * @author tqvu
 */
public class BelowAreaSpec extends SpecDecorator {
    public float getMaxBuildingArea() {
        return maxBuildingArea;
    }

    private float maxBuildingArea;

    public BelowAreaSpec(Spec spec, float maxBuildingArea) {
        super(spec);
        this.maxBuildingArea = maxBuildingArea;
    }

    public BelowAreaSpec(float maxBuildingArea) {
        this.maxBuildingArea = maxBuildingArea;
    }

    @Override
    public boolean check(RealEstate estate) {
        return super.check(estate) && estate.getBuildingArea() < maxBuildingArea;
    }
}
