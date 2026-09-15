package fpml.consolidated.eqd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BrokerEquityOptionOnlyExistsValidator implements ValidatorWithArg<BrokerEquityOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BrokerEquityOption> ValidationResult<BrokerEquityOption> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("strike", ExistenceChecker.isSet((EquityStrike) o.getStrike()))
				.put("spotPrice", ExistenceChecker.isSet((BigDecimal) o.getSpotPrice()))
				.put("numberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNumberOfOptions()))
				.put("equityPremium", ExistenceChecker.isSet((EquityPremium) o.getEquityPremium()))
				.put("deltaCrossed", ExistenceChecker.isSet((Boolean) o.getDeltaCrossed()))
				.put("brokerageFee", ExistenceChecker.isSet((Money) o.getBrokerageFee()))
				.put("brokerNotes", ExistenceChecker.isSet((String) o.getBrokerNotes()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BrokerEquityOption", ValidationResult.ValidationType.ONLY_EXISTS, "BrokerEquityOption", path, "");
		}
		return failure("BrokerEquityOption", ValidationResult.ValidationType.ONLY_EXISTS, "BrokerEquityOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
