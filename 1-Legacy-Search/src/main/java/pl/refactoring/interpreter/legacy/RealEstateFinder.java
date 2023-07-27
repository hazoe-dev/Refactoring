package pl.refactoring.interpreter.legacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea) {
        Spec spec = new BelowAreaSpec( maxBuildingArea);
        return bySpec(spec);
    }

    private List<RealEstate> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::check)
                .collect(Collectors.toList());
    }


    public List<RealEstate> byMaterial(EstateMaterial material) {
        MaterialSpec materialSpec = new MaterialSpec( material);
        return bySpec(materialSpec);
    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea) {
        Spec combinedSpec = new MaterialSpec(new BelowAreaSpec(maxBuildingArea),material);
        return bySpec(combinedSpec);
    }

    public List<RealEstate> byPlacement(EstatePlacement placement) {
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Spec placementSpec = new PlacementSpec(placement);
        for (RealEstate estate : repository) {
            if (placementSpec.check(estate))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement) {
        List<RealEstate> foundRealEstates = new ArrayList<>();
        Spec placementSpec = new PlacementSpec(placement);
        for (RealEstate estate : repository) {
            if (!placementSpec.check(estate))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea) {
        List<RealEstate> foundRealEstates = new ArrayList<>();

        for (RealEstate estate : repository) {
            if (estate.getBuildingArea() >= minArea && estate.getBuildingArea() <= maxArea)
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byType(EstateType type) {
        Spec typeSpec = new TypeSpec(type);
        List<RealEstate> foundRealEstates = new ArrayList<>();

        for (RealEstate estate : repository) {
            if (typeSpec.check(estate))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }

    public List<RealEstate> byVerySpecificCriteria(EstateType type, EstatePlacement placement, EstateMaterial material) {
        Spec typeSpec = new TypeSpec(type);
        Spec placementSpec = new PlacementSpec(placement);

        List<RealEstate> foundRealEstates = new ArrayList<>();
        MaterialSpec materialSpec = new MaterialSpec(material);
        for (RealEstate estate : repository) {
            if (typeSpec.check(estate) && placementSpec.check(estate) && materialSpec.check(estate))
                foundRealEstates.add(estate);
        }
        return foundRealEstates;
    }




}
