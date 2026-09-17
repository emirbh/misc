package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingInputReplacement;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingInputReplacementValidator implements Validator<PricingInputReplacement> {

	private List<ComparisonResult> getComparisonResults(PricingInputReplacement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalInputReference", (PricingStructureReference) o.getOriginalInputReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("replacementInputReference", (PricingStructureReference) o.getReplacementInputReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingInputReplacement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingInputReplacement", ValidationResult.ValidationType.CARDINALITY, "PricingInputReplacement", path, "", res.getError());
				}
				return success("PricingInputReplacement", ValidationResult.ValidationType.CARDINALITY, "PricingInputReplacement", path, "");
			})
			.collect(toList());
	}

}
