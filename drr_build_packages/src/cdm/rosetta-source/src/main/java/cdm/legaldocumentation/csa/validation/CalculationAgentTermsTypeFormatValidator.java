package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CalculationAgentTerms;
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

public class CalculationAgentTermsTypeFormatValidator implements Validator<CalculationAgentTerms> {

	private List<ComparisonResult> getComparisonResults(CalculationAgentTerms o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgentTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAgentTerms", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationAgentTerms", path, "", res.getError());
				}
				return success("CalculationAgentTerms", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationAgentTerms", path, "");
			})
			.collect(toList());
	}

}
