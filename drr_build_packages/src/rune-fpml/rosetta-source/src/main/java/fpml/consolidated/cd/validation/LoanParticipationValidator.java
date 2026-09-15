package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.LoanParticipation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanParticipationValidator implements Validator<LoanParticipation> {

	private List<ComparisonResult> getComparisonResults(LoanParticipation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("partialCashSettlement", (Boolean) o.getPartialCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("qualifyingParticipationSeller", (String) o.getQualifyingParticipationSeller() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanParticipation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanParticipation", ValidationResult.ValidationType.CARDINALITY, "LoanParticipation", path, "", res.getError());
				}
				return success("LoanParticipation", ValidationResult.ValidationType.CARDINALITY, "LoanParticipation", path, "");
			})
			.collect(toList());
	}

}
