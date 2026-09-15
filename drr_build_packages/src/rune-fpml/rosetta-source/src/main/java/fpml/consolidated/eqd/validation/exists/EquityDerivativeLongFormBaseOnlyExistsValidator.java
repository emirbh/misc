package fpml.consolidated.eqd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.EquityDerivativeLongFormBase;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityDerivativeLongFormBaseOnlyExistsValidator implements ValidatorWithArg<EquityDerivativeLongFormBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityDerivativeLongFormBase> ValidationResult<EquityDerivativeLongFormBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("optionType", ExistenceChecker.isSet((EquityOptionTypeEnum) o.getOptionType()))
				.put("equityEffectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEquityEffectiveDate()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("equityExercise", ExistenceChecker.isSet((EquityExerciseValuationSettlement) o.getEquityExercise()))
				.put("feature", ExistenceChecker.isSet((OptionFeatures) o.getFeature()))
				.put("fxFeature", ExistenceChecker.isSet((FxFeature) o.getFxFeature()))
				.put("strategyFeature", ExistenceChecker.isSet((StrategyFeature) o.getStrategyFeature()))
				.put("dividendConditions", ExistenceChecker.isSet((DividendConditions) o.getDividendConditions()))
				.put("methodOfAdjustment", ExistenceChecker.isSet((MethodOfAdjustmentEnum) o.getMethodOfAdjustment()))
				.put("extraordinaryEvents", ExistenceChecker.isSet((ExtraordinaryEvents) o.getExtraordinaryEvents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityDerivativeLongFormBase", ValidationResult.ValidationType.ONLY_EXISTS, "EquityDerivativeLongFormBase", path, "");
		}
		return failure("EquityDerivativeLongFormBase", ValidationResult.ValidationType.ONLY_EXISTS, "EquityDerivativeLongFormBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
