package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CommitmentAdjustment;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingEconomicBenefitValidator implements Validator<LoanTradingEconomicBenefit> {

	private List<ComparisonResult> getComparisonResults(LoanTradingEconomicBenefit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventIdentifier", (BusinessEventIdentifier) o.getEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("commitmentAdjustment", (CommitmentAdjustment) o.getCommitmentAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingEconomicBenefit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingEconomicBenefit", ValidationResult.ValidationType.CARDINALITY, "LoanTradingEconomicBenefit", path, "", res.getError());
				}
				return success("LoanTradingEconomicBenefit", ValidationResult.ValidationType.CARDINALITY, "LoanTradingEconomicBenefit", path, "");
			})
			.collect(toList());
	}

}
