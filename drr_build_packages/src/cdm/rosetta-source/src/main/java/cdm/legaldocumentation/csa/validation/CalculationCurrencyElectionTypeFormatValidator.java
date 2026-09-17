package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CalculationCurrencyElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationCurrencyElectionTypeFormatValidator implements Validator<CalculationCurrencyElection> {

	private List<ComparisonResult> getComparisonResults(CalculationCurrencyElection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationCurrencyElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationCurrencyElection", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationCurrencyElection", path, "", res.getError());
				}
				return success("CalculationCurrencyElection", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationCurrencyElection", path, "");
			})
			.collect(toList());
	}

}
