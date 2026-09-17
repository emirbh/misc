package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PrincipalPaymentSchedule;
import cdm.product.common.settlement.PrincipalPayments;
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

public class PrincipalPaymentsValidator implements Validator<PrincipalPayments> {

	private List<ComparisonResult> getComparisonResults(PrincipalPayments o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialPayment", (Boolean) o.getInitialPayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalPayment", (Boolean) o.getFinalPayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("intermediatePayment", (Boolean) o.getIntermediatePayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("principalPaymentSchedule", (PrincipalPaymentSchedule) o.getPrincipalPaymentSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalPayments o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalPayments", ValidationResult.ValidationType.CARDINALITY, "PrincipalPayments", path, "", res.getError());
				}
				return success("PrincipalPayments", ValidationResult.ValidationType.CARDINALITY, "PrincipalPayments", path, "");
			})
			.collect(toList());
	}

}
