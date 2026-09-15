package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxPivot;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.fx.targets.FxTarget;
import fpml.consolidated.fx.targets.FxTargetBarrier;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetKnockoutForward;
import fpml.consolidated.fx.targets.FxTargetKnockoutForwardChoice;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodSchedule;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetKnockoutForwardOnlyExistsValidator implements ValidatorWithArg<FxTargetKnockoutForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetKnockoutForward> ValidationResult<FxTargetKnockoutForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("target", ExistenceChecker.isSet((List<? extends FxTarget>) o.getTarget()))
				.put("expirySchedule", ExistenceChecker.isSet((FxExpirySchedule) o.getExpirySchedule()))
				.put("settlementSchedule", ExistenceChecker.isSet((FxSettlementSchedule) o.getSettlementSchedule()))
				.put("fixingInformationSource", ExistenceChecker.isSet((FxInformationSource) o.getFixingInformationSource()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("pivot", ExistenceChecker.isSet((FxPivot) o.getPivot()))
				.put("constantPayoffRegion", ExistenceChecker.isSet((List<? extends FxTargetConstantPayoffRegion>) o.getConstantPayoffRegion()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((FxTargetLinearPayoffRegion) o.getLinearPayoffRegion()))
				.put("fxTargetKnockoutForwardChoice", ExistenceChecker.isSet((List<? extends FxTargetKnockoutForwardChoice>) o.getFxTargetKnockoutForwardChoice()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxTargetBarrier>) o.getBarrier()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends SimplePayment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.put("settlementPeriodSchedule", ExistenceChecker.isSet((FxTargetSettlementPeriodSchedule) o.getSettlementPeriodSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetKnockoutForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetKnockoutForward", path, "");
		}
		return failure("FxTargetKnockoutForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetKnockoutForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
