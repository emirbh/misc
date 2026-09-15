package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.DeliverableObligations;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.mktenv.CreditCurve;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditCurveOnlyExistsValidator implements ValidatorWithArg<CreditCurve, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditCurve> ValidationResult<CreditCurve> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("referenceEntity", ExistenceChecker.isSet((LegalEntity) o.getReferenceEntity()))
				.put("creditEntityReference", ExistenceChecker.isSet((LegalEntityReference) o.getCreditEntityReference()))
				.put("creditEvents", ExistenceChecker.isSet((CreditEvents) o.getCreditEvents()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("secured", ExistenceChecker.isSet((Boolean) o.getSecured()))
				.put("obligationCurrency", ExistenceChecker.isSet((Currency) o.getObligationCurrency()))
				.put("obligations", ExistenceChecker.isSet((Obligations) o.getObligations()))
				.put("deliverableObligations", ExistenceChecker.isSet((DeliverableObligations) o.getDeliverableObligations()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditCurve", ValidationResult.ValidationType.ONLY_EXISTS, "CreditCurve", path, "");
		}
		return failure("CreditCurve", ValidationResult.ValidationType.ONLY_EXISTS, "CreditCurve", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
