package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.common.AddressForNotices;
import cdm.legaldocumentation.csa.CreditSupportDocument;
import cdm.legaldocumentation.csa.CreditSupportProvider;
import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
import cdm.legaldocumentation.master.isda.MasterAgreement;
import cdm.legaldocumentation.master.isda.SpecifiedEntities;
import cdm.legaldocumentation.master.isda.TerminationCurrency;
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

public class MasterAgreementOnlyExistsValidator implements ValidatorWithArg<MasterAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MasterAgreement> ValidationResult<MasterAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("automaticEarlyTermination", ExistenceChecker.isSet((AutomaticEarlyTermination) o.getAutomaticEarlyTermination()))
				.put("terminationCurrency", ExistenceChecker.isSet((TerminationCurrency) o.getTerminationCurrency()))
				.put("addressForNotices", ExistenceChecker.isSet((AddressForNotices) o.getAddressForNotices()))
				.put("nonContractualObligations", ExistenceChecker.isSet((Boolean) o.getNonContractualObligations()))
				.put("creditSupportDocument", ExistenceChecker.isSet((CreditSupportDocument) o.getCreditSupportDocument()))
				.put("creditSupportProvider", ExistenceChecker.isSet((CreditSupportProvider) o.getCreditSupportProvider()))
				.put("specifiedEntities", ExistenceChecker.isSet((List<? extends SpecifiedEntities>) o.getSpecifiedEntities()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "MasterAgreement", path, "");
		}
		return failure("MasterAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "MasterAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
