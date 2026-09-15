package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.LoanLegalStructureAfter;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalStructureAfterValidator implements Validator<LoanLegalStructureAfter> {

	private List<ComparisonResult> getComparisonResults(LoanLegalStructureAfter o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dealReference", (DealReference) o.getDealReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfter o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalStructureAfter", ValidationResult.ValidationType.CARDINALITY, "LoanLegalStructureAfter", path, "", res.getError());
				}
				return success("LoanLegalStructureAfter", ValidationResult.ValidationType.CARDINALITY, "LoanLegalStructureAfter", path, "");
			})
			.collect(toList());
	}

}
