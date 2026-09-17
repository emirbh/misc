package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityOptionValidator implements Validator<EquityOption> {

	private List<ComparisonResult> getComparisonResults(EquityOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (EquityOptionTypeEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityEffectiveDate", (ZonedDateTime) o.getEquityEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExercise", (EquityExerciseValuationSettlement) o.getEquityExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("feature", (OptionFeatures) o.getFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxFeature", (FxFeature) o.getFxFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("strategyFeature", (StrategyFeature) o.getStrategyFeature() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendConditions", (DividendConditions) o.getDividendConditions() != null ? 1 : 0, 0, 1), 
				checkCardinality("methodOfAdjustment", (MethodOfAdjustmentEnum) o.getMethodOfAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (EquityStrike) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotPrice", (BigDecimal) o.getSpotPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptions", (BigDecimal) o.getNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityPremium", (EquityPremium) o.getEquityPremium() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityOption", ValidationResult.ValidationType.CARDINALITY, "EquityOption", path, "", res.getError());
				}
				return success("EquityOption", ValidationResult.ValidationType.CARDINALITY, "EquityOption", path, "");
			})
			.collect(toList());
	}

}
