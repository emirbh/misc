package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.CSAThresholdVariableSet;
import cdm.legaldocumentation.csa.NotRatedByEnum;
import cdm.legaldocumentation.csa.NumberOfRatingAgenciesEnum;
import cdm.legaldocumentation.csa.RatingTypeEnum;
import cdm.legaldocumentation.csa.ThresholdRatedPartyEnum;
import cdm.legaldocumentation.csa.ThresholdRatingsBased;
import cdm.legaldocumentation.csa.ThresholdZeroEventEnum;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ThresholdRatingsBasedOnlyExistsValidator implements ValidatorWithArg<ThresholdRatingsBased, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ThresholdRatingsBased> ValidationResult<ThresholdRatingsBased> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCurrency()))
				.put("ratingType", ExistenceChecker.isSet((RatingTypeEnum) o.getRatingType()))
				.put("variableSet", ExistenceChecker.isSet((List<? extends CSAThresholdVariableSet>) o.getVariableSet()))
				.put("ratedParty", ExistenceChecker.isSet((ThresholdRatedPartyEnum) o.getRatedParty()))
				.put("namedEntity", ExistenceChecker.isSet((String) o.getNamedEntity()))
				.put("namedAffiliate", ExistenceChecker.isSet((String) o.getNamedAffiliate()))
				.put("compare", ExistenceChecker.isSet((CreditNotationMismatchResolutionEnum) o.getCompare()))
				.put("noRating", ExistenceChecker.isSet((Boolean) o.getNoRating()))
				.put("notRatedBy", ExistenceChecker.isSet((NotRatedByEnum) o.getNotRatedBy()))
				.put("numberOfRatingAgencies", ExistenceChecker.isSet((NumberOfRatingAgenciesEnum) o.getNumberOfRatingAgencies()))
				.put("zeroEvent", ExistenceChecker.isSet((Boolean) o.getZeroEvent()))
				.put("event", ExistenceChecker.isSet((List<ThresholdZeroEventEnum>) o.getEvent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ThresholdRatingsBased", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdRatingsBased", path, "");
		}
		return failure("ThresholdRatingsBased", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdRatingsBased", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
