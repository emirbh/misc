package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxPivot;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.fx.targets.FxTarget;
import fpml.consolidated.fx.targets.FxTargetKnockoutForward;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodSchedule;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardValidator implements Validator<FxTargetKnockoutForward> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("target", (List<? extends FxTarget>) o.getTarget() == null ? 0 : o.getTarget().size(), 1, 2), 
				checkCardinality("expirySchedule", (FxExpirySchedule) o.getExpirySchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementSchedule", (FxSettlementSchedule) o.getSettlementSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingInformationSource", (FxInformationSource) o.getFixingInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("pivot", (FxPivot) o.getPivot() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (FxTargetLinearPayoffRegion) o.getLinearPayoffRegion() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodSchedule", (FxTargetSettlementPeriodSchedule) o.getSettlementPeriodSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForward", ValidationResult.ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "", res.getError());
				}
				return success("FxTargetKnockoutForward", ValidationResult.ValidationType.CARDINALITY, "FxTargetKnockoutForward", path, "");
			})
			.collect(toList());
	}

}
