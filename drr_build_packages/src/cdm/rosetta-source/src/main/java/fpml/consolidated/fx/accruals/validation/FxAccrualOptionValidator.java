package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAccrualOption;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import fpml.consolidated.fx.accruals.FxAverageRate;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.fx.accruals.FxOptionStrikePrice;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualOptionValidator implements Validator<FxAccrualOption> {

	private List<ComparisonResult> getComparisonResults(FxAccrualOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("putCurrency", (Currency) o.getPutCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("callCurrency", (Currency) o.getCallCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (FxExpiryDate) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirySchedule", (FxExpirySchedule) o.getExpirySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (FxAdjustedDateAndDateAdjustments) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementSchedule", (FxSettlementSchedule) o.getSettlementSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (FxOptionStrikePrice) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (NonNegativeAmountSchedule) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrike", (FxAverageStrike) o.getAverageStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageRate", (FxAverageRate) o.getAverageRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualOption", ValidationResult.ValidationType.CARDINALITY, "FxAccrualOption", path, "", res.getError());
				}
				return success("FxAccrualOption", ValidationResult.ValidationType.CARDINALITY, "FxAccrualOption", path, "");
			})
			.collect(toList());
	}

}
