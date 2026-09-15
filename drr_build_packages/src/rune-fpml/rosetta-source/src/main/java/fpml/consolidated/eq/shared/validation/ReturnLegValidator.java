package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.Return;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnLegValuation;
import fpml.consolidated.eq.shared.ReturnSwapAmount;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.fpmlenum.NotionalAdjustmentEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.AveragingPeriod;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnLegValidator implements Validator<ReturnLeg> {

	private List<ComparisonResult> getComparisonResults(ReturnLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeDate", (AdjustableOrRelativeDate) o.getStrikeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateOfReturn", (ReturnLegValuation) o.getRateOfReturn() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (ReturnSwapNotional) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (ReturnSwapAmount) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("return", (Return) o.getReturn() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAdjustments", (NotionalAdjustmentEnum) o.getNotionalAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingDates", (AveragingPeriod) o.getAveragingDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLeg", ValidationResult.ValidationType.CARDINALITY, "ReturnLeg", path, "", res.getError());
				}
				return success("ReturnLeg", ValidationResult.ValidationType.CARDINALITY, "ReturnLeg", path, "");
			})
			.collect(toList());
	}

}
