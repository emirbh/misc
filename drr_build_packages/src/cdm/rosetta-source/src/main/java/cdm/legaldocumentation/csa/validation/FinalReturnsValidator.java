package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.FinalReturns;
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

public class FinalReturnsValidator implements Validator<FinalReturns> {

	private List<ComparisonResult> getComparisonResults(FinalReturns o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalReturns o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinalReturns", ValidationResult.ValidationType.CARDINALITY, "FinalReturns", path, "", res.getError());
				}
				return success("FinalReturns", ValidationResult.ValidationType.CARDINALITY, "FinalReturns", path, "");
			})
			.collect(toList());
	}

}
