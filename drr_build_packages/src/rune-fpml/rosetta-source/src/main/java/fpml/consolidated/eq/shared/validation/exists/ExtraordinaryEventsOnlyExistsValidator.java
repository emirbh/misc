package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdditionalDisruptionEvents;
import fpml.consolidated.eq.shared.EquityCorporateEvents;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.IndexAdjustmentEvents;
import fpml.consolidated.eq.shared.Representations;
import fpml.consolidated.fpmlenum.NationalisationOrInsolvencyOrDelistingEventEnum;
import fpml.consolidated.shared.ExchangeId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExtraordinaryEventsOnlyExistsValidator implements ValidatorWithArg<ExtraordinaryEvents, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExtraordinaryEvents> ValidationResult<ExtraordinaryEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mergerEvents", ExistenceChecker.isSet((EquityCorporateEvents) o.getMergerEvents()))
				.put("tenderOffer", ExistenceChecker.isSet((Boolean) o.getTenderOffer()))
				.put("tenderOfferEvents", ExistenceChecker.isSet((EquityCorporateEvents) o.getTenderOfferEvents()))
				.put("compositionOfCombinedConsideration", ExistenceChecker.isSet((Boolean) o.getCompositionOfCombinedConsideration()))
				.put("indexAdjustmentEvents", ExistenceChecker.isSet((IndexAdjustmentEvents) o.getIndexAdjustmentEvents()))
				.put("additionalDisruptionEvents", ExistenceChecker.isSet((AdditionalDisruptionEvents) o.getAdditionalDisruptionEvents()))
				.put("failureToDeliver", ExistenceChecker.isSet((Boolean) o.getFailureToDeliver()))
				.put("representations", ExistenceChecker.isSet((Representations) o.getRepresentations()))
				.put("nationalisationOrInsolvency", ExistenceChecker.isSet((NationalisationOrInsolvencyOrDelistingEventEnum) o.getNationalisationOrInsolvency()))
				.put("delisting", ExistenceChecker.isSet((NationalisationOrInsolvencyOrDelistingEventEnum) o.getDelisting()))
				.put("relatedExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getRelatedExchangeId()))
				.put("optionsExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getOptionsExchangeId()))
				.put("specifiedExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getSpecifiedExchangeId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExtraordinaryEvents", ValidationResult.ValidationType.ONLY_EXISTS, "ExtraordinaryEvents", path, "");
		}
		return failure("ExtraordinaryEvents", ValidationResult.ValidationType.ONLY_EXISTS, "ExtraordinaryEvents", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
