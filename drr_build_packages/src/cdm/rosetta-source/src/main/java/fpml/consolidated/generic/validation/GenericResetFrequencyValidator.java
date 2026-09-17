package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.generic.GenericResetFrequency;
import fpml.consolidated.generic.UnderlyerReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericResetFrequencyValidator implements Validator<GenericResetFrequency> {

	private List<ComparisonResult> getComparisonResults(GenericResetFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("period", (PeriodExtendedEnum) o.getPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerReference", (UnderlyerReference) o.getUnderlyerReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericResetFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericResetFrequency", ValidationResult.ValidationType.CARDINALITY, "GenericResetFrequency", path, "", res.getError());
				}
				return success("GenericResetFrequency", ValidationResult.ValidationType.CARDINALITY, "GenericResetFrequency", path, "");
			})
			.collect(toList());
	}

}
