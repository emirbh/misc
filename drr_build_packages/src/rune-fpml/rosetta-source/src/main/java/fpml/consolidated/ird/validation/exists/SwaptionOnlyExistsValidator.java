package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.SwaptionTypeEnum;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.ird.SwaptionAdjustedDates;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SwaptionOnlyExistsValidator implements ValidatorWithArg<Swaption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Swaption> ValidationResult<Swaption> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("premium", ExistenceChecker.isSet((List<? extends Payment>) o.getPremium()))
				.put("optionType", ExistenceChecker.isSet((SwaptionTypeEnum) o.getOptionType()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("calculationAgent", ExistenceChecker.isSet((CalculationAgent) o.getCalculationAgent()))
				.put("cashSettlement", ExistenceChecker.isSet((CashSettlement) o.getCashSettlement()))
				.put("physicalSettlement", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getPhysicalSettlement()))
				.put("swaptionStraddle", ExistenceChecker.isSet((Boolean) o.getSwaptionStraddle()))
				.put("earlyTerminationProvision", ExistenceChecker.isSet((EarlyTerminationProvision) o.getEarlyTerminationProvision()))
				.put("swaptionAdjustedDates", ExistenceChecker.isSet((SwaptionAdjustedDates) o.getSwaptionAdjustedDates()))
				.put("swap", ExistenceChecker.isSet((Swap) o.getSwap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Swaption", ValidationResult.ValidationType.ONLY_EXISTS, "Swaption", path, "");
		}
		return failure("Swaption", ValidationResult.ValidationType.ONLY_EXISTS, "Swaption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
