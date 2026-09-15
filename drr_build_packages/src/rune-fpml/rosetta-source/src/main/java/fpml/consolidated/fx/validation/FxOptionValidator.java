package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.fx.FxAmericanExercise;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxOptionFeatures;
import fpml.consolidated.fx.FxStrikePrice;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOptionValidator implements Validator<FxOption> {

	private List<ComparisonResult> getComparisonResults(FxOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenorPeriod", (Period) o.getTenorPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("americanExercise", (FxAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (FxEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("putCurrencyAmount", (NonNegativeMoney) o.getPutCurrencyAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("callCurrencyAmount", (NonNegativeMoney) o.getCallCurrencyAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("soldAs", (PutCallEnum) o.getSoldAs() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (FxStrikePrice) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("features", (FxOptionFeatures) o.getFeatures() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlement) o.getCashSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOption", ValidationResult.ValidationType.CARDINALITY, "FxOption", path, "", res.getError());
				}
				return success("FxOption", ValidationResult.ValidationType.CARDINALITY, "FxOption", path, "");
			})
			.collect(toList());
	}

}
