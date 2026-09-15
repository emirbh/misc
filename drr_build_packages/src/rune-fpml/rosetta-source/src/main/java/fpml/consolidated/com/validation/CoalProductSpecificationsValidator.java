package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalProductSpecifications;
import fpml.consolidated.com.CoalStandardQuality;
import fpml.consolidated.com.CoalStandardQualitySchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalProductSpecificationsValidator implements Validator<CoalProductSpecifications> {

	private List<ComparisonResult> getComparisonResults(CoalProductSpecifications o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardQuality", (CoalStandardQuality) o.getStandardQuality() != null ? 1 : 0, 0, 1), 
				checkCardinality("standardQualitySchedule", (CoalStandardQualitySchedule) o.getStandardQualitySchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalProductSpecifications o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalProductSpecifications", ValidationResult.ValidationType.CARDINALITY, "CoalProductSpecifications", path, "", res.getError());
				}
				return success("CoalProductSpecifications", ValidationResult.ValidationType.CARDINALITY, "CoalProductSpecifications", path, "");
			})
			.collect(toList());
	}

}
