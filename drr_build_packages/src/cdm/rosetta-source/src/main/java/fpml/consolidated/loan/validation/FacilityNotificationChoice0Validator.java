package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityNotificationChoice0;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanContractSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilityNotificationChoice0Validator implements Validator<FacilityNotificationChoice0> {

	private List<ComparisonResult> getComparisonResults(FacilityNotificationChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractIdentifier", (LoanContractIdentifier) o.getContractIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractSummary", (LoanContractSummary) o.getContractSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("contract", (LoanContract) o.getContract() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotificationChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "FacilityNotificationChoice0", path, "", res.getError());
				}
				return success("FacilityNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "FacilityNotificationChoice0", path, "");
			})
			.collect(toList());
	}

}
