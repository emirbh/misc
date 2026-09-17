package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanContractList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanContractListValidator implements Validator<LoanContractList> {

	private List<ComparisonResult> getComparisonResults(LoanContractList o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contract", (List<? extends LoanContract>) o.getContract() == null ? 0 : o.getContract().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractList o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContractList", ValidationResult.ValidationType.CARDINALITY, "LoanContractList", path, "", res.getError());
				}
				return success("LoanContractList", ValidationResult.ValidationType.CARDINALITY, "LoanContractList", path, "");
			})
			.collect(toList());
	}

}
