package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Counterparty45;
import iso20022.auth108.iso.Counterparty46;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import iso20022.auth108.iso.TradeCounterpartyRelationshipRecord1;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeCounterpartyReport20OnlyExistsValidator implements ValidatorWithArg<TradeCounterpartyReport20, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeCounterpartyReport20> ValidationResult<TradeCounterpartyReport20> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptgCtrPty", ExistenceChecker.isSet((Counterparty45) o.getRptgCtrPty()))
				.put("othrCtrPty", ExistenceChecker.isSet((Counterparty46) o.getOthrCtrPty()))
				.put("brkr", ExistenceChecker.isSet((OrganisationIdentification15Choice) o.getBrkr()))
				.put("submitgAgt", ExistenceChecker.isSet((OrganisationIdentification15Choice) o.getSubmitgAgt()))
				.put("clrMmb", ExistenceChecker.isSet((PartyIdentification248Choice) o.getClrMmb()))
				.put("bnfcry", ExistenceChecker.isSet((List<? extends PartyIdentification248Choice>) o.getBnfcry()))
				.put("nttyRspnsblForRpt", ExistenceChecker.isSet((OrganisationIdentification15Choice) o.getNttyRspnsblForRpt()))
				.put("exctnAgt", ExistenceChecker.isSet((List<? extends OrganisationIdentification15Choice>) o.getExctnAgt()))
				.put("rltshRcrd", ExistenceChecker.isSet((List<? extends TradeCounterpartyRelationshipRecord1>) o.getRltshRcrd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeCounterpartyReport20", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20", path, "");
		}
		return failure("TradeCounterpartyReport20", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
