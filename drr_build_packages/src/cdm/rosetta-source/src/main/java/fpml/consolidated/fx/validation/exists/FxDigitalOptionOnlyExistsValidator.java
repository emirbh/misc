package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxOptionPayout;
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.FxTouch;
import fpml.consolidated.fx.FxTrigger;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDigitalOptionOnlyExistsValidator implements ValidatorWithArg<FxDigitalOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDigitalOption> ValidationResult<FxDigitalOption> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("americanExercise", ExistenceChecker.isSet((FxDigitalAmericanExercise) o.getAmericanExercise()))
				.put("touch", ExistenceChecker.isSet((List<? extends FxTouch>) o.getTouch()))
				.put("europeanExercise", ExistenceChecker.isSet((FxEuropeanExercise) o.getEuropeanExercise()))
				.put("trigger", ExistenceChecker.isSet((List<? extends FxTrigger>) o.getTrigger()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("payout", ExistenceChecker.isSet((FxOptionPayout) o.getPayout()))
				.put("premium", ExistenceChecker.isSet((List<? extends FxOptionPremium>) o.getPremium()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDigitalOption", ValidationResult.ValidationType.ONLY_EXISTS, "FxDigitalOption", path, "");
		}
		return failure("FxDigitalOption", ValidationResult.ValidationType.ONLY_EXISTS, "FxDigitalOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
