package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.CreditEventNotice;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.FailureToPay;
import fpml.consolidated.option.shared.Restructuring;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditEventsValidator implements Validator<CreditEvents> {

	private List<ComparisonResult> getComparisonResults(CreditEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("bankruptcy", (Boolean) o.getBankruptcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToPay", (FailureToPay) o.getFailureToPay() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToPayPrincipal", (Boolean) o.getFailureToPayPrincipal() != null ? 1 : 0, 0, 1), 
				checkCardinality("failureToPayInterest", (Boolean) o.getFailureToPayInterest() != null ? 1 : 0, 0, 1), 
				checkCardinality("obligationDefault", (Boolean) o.getObligationDefault() != null ? 1 : 0, 0, 1), 
				checkCardinality("obligationAcceleration", (Boolean) o.getObligationAcceleration() != null ? 1 : 0, 0, 1), 
				checkCardinality("repudiationMoratorium", (Boolean) o.getRepudiationMoratorium() != null ? 1 : 0, 0, 1), 
				checkCardinality("restructuring", (Restructuring) o.getRestructuring() != null ? 1 : 0, 0, 1), 
				checkCardinality("governmentalIntervention", (Boolean) o.getGovernmentalIntervention() != null ? 1 : 0, 0, 1), 
				checkCardinality("distressedRatingsDowngrade", (Boolean) o.getDistressedRatingsDowngrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityExtension", (Boolean) o.getMaturityExtension() != null ? 1 : 0, 0, 1), 
				checkCardinality("writedown", (Boolean) o.getWritedown() != null ? 1 : 0, 0, 1), 
				checkCardinality("impliedWritedown", (Boolean) o.getImpliedWritedown() != null ? 1 : 0, 0, 1), 
				checkCardinality("defaultRequirement", (Money) o.getDefaultRequirement() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEventNotice", (CreditEventNotice) o.getCreditEventNotice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEvents", ValidationResult.ValidationType.CARDINALITY, "CreditEvents", path, "", res.getError());
				}
				return success("CreditEvents", ValidationResult.ValidationType.CARDINALITY, "CreditEvents", path, "");
			})
			.collect(toList());
	}

}
