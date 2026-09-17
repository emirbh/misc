package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.eq.shared.LegAmount;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.eq.shared.StubCalculationPeriod;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestLegValidator implements Validator<InterestLeg> {

	private List<ComparisonResult> getComparisonResults(InterestLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestLegCalculationPeriodDates", (InterestLegCalculationPeriodDates) o.getInterestLegCalculationPeriodDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("notional", (ReturnSwapNotional) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestAmount", (LegAmount) o.getInterestAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestCalculation", (InterestCalculation) o.getInterestCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("stubCalculationPeriod", (StubCalculationPeriod) o.getStubCalculationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLeg", ValidationResult.ValidationType.CARDINALITY, "InterestLeg", path, "", res.getError());
				}
				return success("InterestLeg", ValidationResult.ValidationType.CARDINALITY, "InterestLeg", path, "");
			})
			.collect(toList());
	}

}
