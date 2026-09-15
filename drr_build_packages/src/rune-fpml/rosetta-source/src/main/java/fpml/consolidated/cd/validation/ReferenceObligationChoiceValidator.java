package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferenceObligationChoice;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceObligationChoiceValidator implements Validator<ReferenceObligationChoice> {

	private List<ComparisonResult> getComparisonResults(ReferenceObligationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("guarantor", (LegalEntity) o.getGuarantor() != null ? 1 : 0, 0, 1), 
				checkCardinality("guarantorReference", (LegalEntityReference) o.getGuarantorReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceObligationChoice", ValidationResult.ValidationType.CARDINALITY, "ReferenceObligationChoice", path, "", res.getError());
				}
				return success("ReferenceObligationChoice", ValidationResult.ValidationType.CARDINALITY, "ReferenceObligationChoice", path, "");
			})
			.collect(toList());
	}

}
