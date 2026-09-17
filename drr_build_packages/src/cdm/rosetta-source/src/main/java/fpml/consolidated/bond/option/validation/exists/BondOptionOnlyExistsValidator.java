package fpml.consolidated.bond.option.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BondOptionOnlyExistsValidator implements ValidatorWithArg<BondOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BondOption> ValidationResult<BondOption> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("premium", ExistenceChecker.isSet((Premium) o.getPremium()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("feature", ExistenceChecker.isSet((OptionFeature) o.getFeature()))
				.put("notionalReference", ExistenceChecker.isSet((NotionalAmountReference) o.getNotionalReference()))
				.put("notionalAmount", ExistenceChecker.isSet((Money) o.getNotionalAmount()))
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("entitlementCurrency", ExistenceChecker.isSet((Currency) o.getEntitlementCurrency()))
				.put("numberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNumberOfOptions()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementDate()))
				.put("settlementAmount", ExistenceChecker.isSet((Money) o.getSettlementAmount()))
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("strike", ExistenceChecker.isSet((BondOptionStrike) o.getStrike()))
				.put("bond", ExistenceChecker.isSet((Bond) o.getBond()))
				.put("convertibleBond", ExistenceChecker.isSet((ConvertibleBond) o.getConvertibleBond()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BondOption", ValidationResult.ValidationType.ONLY_EXISTS, "BondOption", path, "");
		}
		return failure("BondOption", ValidationResult.ValidationType.ONLY_EXISTS, "BondOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
