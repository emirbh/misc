package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.AdditionalTerm;
import fpml.consolidated.cd.BasketReferenceInformation;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GeneralTermsOnlyExistsValidator implements ValidatorWithArg<GeneralTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GeneralTerms> ValidationResult<GeneralTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate2) o.getEffectiveDate()))
				.put("scheduledTerminationDate", ExistenceChecker.isSet((AdjustableDate2) o.getScheduledTerminationDate()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("referenceInformation", ExistenceChecker.isSet((ReferenceInformation) o.getReferenceInformation()))
				.put("indexReferenceInformation", ExistenceChecker.isSet((IndexReferenceInformation) o.getIndexReferenceInformation()))
				.put("basketReferenceInformation", ExistenceChecker.isSet((BasketReferenceInformation) o.getBasketReferenceInformation()))
				.put("additionalTerm", ExistenceChecker.isSet((List<? extends AdditionalTerm>) o.getAdditionalTerm()))
				.put("substitution", ExistenceChecker.isSet((Boolean) o.getSubstitution()))
				.put("modifiedEquityDelivery", ExistenceChecker.isSet((Boolean) o.getModifiedEquityDelivery()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GeneralTerms", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralTerms", path, "");
		}
		return failure("GeneralTerms", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
