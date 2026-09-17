package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalAttributeDecimal;
import fpml.consolidated.com.CoalAttributePercentage;
import fpml.consolidated.com.CoalStandardQuality;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalStandardQualityValidator implements Validator<CoalStandardQuality> {

	private List<ComparisonResult> getComparisonResults(CoalStandardQuality o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("moisture", (CoalAttributePercentage) o.getMoisture() != null ? 1 : 0, 0, 1), 
				checkCardinality("ash", (CoalAttributePercentage) o.getAsh() != null ? 1 : 0, 0, 1), 
				checkCardinality("sulfur", (CoalAttributePercentage) o.getSulfur() != null ? 1 : 0, 0, 1), 
				checkCardinality("sO2", (CoalAttributePercentage) o.getSO2() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatile", (CoalAttributePercentage) o.getVolatile() != null ? 1 : 0, 0, 1), 
				checkCardinality("btUperLB", (CoalAttributeDecimal) o.getBtUperLB() != null ? 1 : 0, 0, 1), 
				checkCardinality("topSize", (CoalAttributeDecimal) o.getTopSize() != null ? 1 : 0, 0, 1), 
				checkCardinality("finesPassingScreen", (CoalAttributeDecimal) o.getFinesPassingScreen() != null ? 1 : 0, 0, 1), 
				checkCardinality("grindability", (CoalAttributeDecimal) o.getGrindability() != null ? 1 : 0, 0, 1), 
				checkCardinality("ashFusionTemperature", (CoalAttributeDecimal) o.getAshFusionTemperature() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialDeformation", (CoalAttributeDecimal) o.getInitialDeformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("softeningHeightWidth", (CoalAttributeDecimal) o.getSofteningHeightWidth() != null ? 1 : 0, 0, 1), 
				checkCardinality("softeningHeightHalfWidth", (CoalAttributeDecimal) o.getSofteningHeightHalfWidth() != null ? 1 : 0, 0, 1), 
				checkCardinality("fluid", (CoalAttributeDecimal) o.getFluid() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalStandardQuality o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalStandardQuality", ValidationResult.ValidationType.CARDINALITY, "CoalStandardQuality", path, "", res.getError());
				}
				return success("CoalStandardQuality", ValidationResult.ValidationType.CARDINALITY, "CoalStandardQuality", path, "");
			})
			.collect(toList());
	}

}
