package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.ird.Cashflows;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.ResetDates;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamValidator implements Validator<InterestRateStream> {

	private List<ComparisonResult> getComparisonResults(InterestRateStream o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDates", (CalculationPeriodDates) o.getCalculationPeriodDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDates", (PaymentDates) o.getPaymentDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("resetDates", (ResetDates) o.getResetDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodAmount", (CalculationPeriodAmount) o.getCalculationPeriodAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("stubCalculationPeriodAmount", (StubCalculationPeriodAmount) o.getStubCalculationPeriodAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchanges", (PrincipalExchanges) o.getPrincipalExchanges() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflows", (Cashflows) o.getCashflows() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementProvision", (SettlementProvision) o.getSettlementProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStream o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStream", ValidationResult.ValidationType.CARDINALITY, "InterestRateStream", path, "", res.getError());
				}
				return success("InterestRateStream", ValidationResult.ValidationType.CARDINALITY, "InterestRateStream", path, "");
			})
			.collect(toList());
	}

}
