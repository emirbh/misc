package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
import cdm.legaldocumentation.transaction.additionalterms.FxDualExchangeRate;
import cdm.legaldocumentation.transaction.additionalterms.FxForceMajeureOrActOfSStateEnum;
import cdm.legaldocumentation.transaction.additionalterms.FxIllegalityOrImpossibilityEnum;
import cdm.legaldocumentation.transaction.additionalterms.FxInconvertibilityOrNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.FxPriceSourceDisruption;
import cdm.legaldocumentation.transaction.additionalterms.GovernmentalAuthorityDefault;
import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
import cdm.legaldocumentation.transaction.additionalterms.MaterialChangeInCircumstance;
import cdm.legaldocumentation.transaction.additionalterms.Nationalization;
import cdm.legaldocumentation.transaction.additionalterms.PriceMateriality;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDisruptionEventsOnlyExistsValidator implements ValidatorWithArg<FxDisruptionEvents, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDisruptionEvents> ValidationResult<FxDisruptionEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("illegalityOrImpossibility", ExistenceChecker.isSet((FxIllegalityOrImpossibilityEnum) o.getIllegalityOrImpossibility()))
				.put("forceMajeureOrActOfSState", ExistenceChecker.isSet((FxForceMajeureOrActOfSStateEnum) o.getForceMajeureOrActOfSState()))
				.put("eventCurrency", ExistenceChecker.isSet((EventCurrency) o.getEventCurrency()))
				.put("priceSourceDisruption", ExistenceChecker.isSet((FxPriceSourceDisruption) o.getPriceSourceDisruption()))
				.put("benchmarkObligationDefault", ExistenceChecker.isSet((FxBenchmarkObligationDefault) o.getBenchmarkObligationDefault()))
				.put("dualExchangeRate", ExistenceChecker.isSet((FxDualExchangeRate) o.getDualExchangeRate()))
				.put("inconvertibilityOrNonTransferability", ExistenceChecker.isSet((FxInconvertibilityOrNonTransferability) o.getInconvertibilityOrNonTransferability()))
				.put("governmentalAuthorityDefault", ExistenceChecker.isSet((GovernmentalAuthorityDefault) o.getGovernmentalAuthorityDefault()))
				.put("illiquidity", ExistenceChecker.isSet((Illiquidity) o.getIlliquidity()))
				.put("materialChangeInCircumstance", ExistenceChecker.isSet((MaterialChangeInCircumstance) o.getMaterialChangeInCircumstance()))
				.put("nationalization", ExistenceChecker.isSet((Nationalization) o.getNationalization()))
				.put("priceMateriality", ExistenceChecker.isSet((PriceMateriality) o.getPriceMateriality()))
				.put("fallbackLanguageBespokeTerms", ExistenceChecker.isSet((Clause) o.getFallbackLanguageBespokeTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDisruptionEvents", ValidationResult.ValidationType.ONLY_EXISTS, "FxDisruptionEvents", path, "");
		}
		return failure("FxDisruptionEvents", ValidationResult.ValidationType.ONLY_EXISTS, "FxDisruptionEvents", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
