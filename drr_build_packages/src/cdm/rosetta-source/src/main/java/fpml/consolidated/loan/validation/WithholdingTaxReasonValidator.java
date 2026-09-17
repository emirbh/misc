package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.WithholdingTaxReason;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WithholdingTaxReasonValidator implements Validator<WithholdingTaxReason> {

	private List<ComparisonResult> getComparisonResults(WithholdingTaxReason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("withholdingTaxReasonScheme", (String) o.getWithholdingTaxReasonScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithholdingTaxReason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithholdingTaxReason", ValidationResult.ValidationType.CARDINALITY, "WithholdingTaxReason", path, "", res.getError());
				}
				return success("WithholdingTaxReason", ValidationResult.ValidationType.CARDINALITY, "WithholdingTaxReason", path, "");
			})
			.collect(toList());
	}

}
