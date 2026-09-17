package cdm.base.datetime.validation;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FrequencyValidator implements Validator<Frequency> {

	private List<ComparisonResult> getComparisonResults(Frequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodExtendedEnum) o.getPeriod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Frequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Frequency", ValidationResult.ValidationType.CARDINALITY, "Frequency", path, "", res.getError());
				}
				return success("Frequency", ValidationResult.ValidationType.CARDINALITY, "Frequency", path, "");
			})
			.collect(toList());
	}

}
