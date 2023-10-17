package com.santander.user.repository.features;

import com.santander.user.models.features.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturesRepository extends JpaRepository<Feature,Long> {
}
