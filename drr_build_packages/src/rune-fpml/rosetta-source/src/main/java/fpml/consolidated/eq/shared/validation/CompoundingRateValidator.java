package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.CompoundingRate;
import fpml.consolidated.eq.shared.FloatingRateCalculationReference;
import fpml.consolidated.shared.InterestAccrualsMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CompoundingRateValidator implements Validator<CompoundingRate> {

	private List<ComparisonResult> getComparisonResults(CompoundingRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestLegRate", (FloatingRateCalculationReference) o.getInterestLegRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificRate", (InterestAccrualsMethod) o.getSpecificRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompoundingRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompoundingRate", ValidationResult.ValidationType.CARDINALITY, "CompoundingRate", path, "", res.getError());
				}
				return success("CompoundingRate", ValidationResult.ValidationType.CARDINALITY, "CompoundingRate", path, "");
			})
			.collect(toList());
	}

}
