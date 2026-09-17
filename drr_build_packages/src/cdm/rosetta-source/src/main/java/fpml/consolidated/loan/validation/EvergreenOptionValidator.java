package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.EvergreenOption;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EvergreenOptionValidator implements Validator<EvergreenOption> {

	private List<ComparisonResult> getComparisonResults(EvergreenOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonRenewalNoticePeriod", (Period) o.getNonRenewalNoticePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extensionPeriod", (Period) o.getExtensionPeriod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EvergreenOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EvergreenOption", ValidationResult.ValidationType.CARDINALITY, "EvergreenOption", path, "", res.getError());
				}
				return success("EvergreenOption", ValidationResult.ValidationType.CARDINALITY, "EvergreenOption", path, "");
			})
			.collect(toList());
	}

}
