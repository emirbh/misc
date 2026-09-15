package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.Counterparty45__2;
import iso20022.auth030.fca.Counterparty46__2;
import iso20022.auth030.fca.OrganisationIdentification15Choice__1;
import iso20022.auth030.fca.TradeCounterpartyRelationshipRecord1__1;
import iso20022.auth030.fca.TradeCounterpartyReport20__2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeCounterpartyReport20__2OnlyExistsValidator implements ValidatorWithArg<TradeCounterpartyReport20__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeCounterpartyReport20__2> ValidationResult<TradeCounterpartyReport20__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptgCtrPty", ExistenceChecker.isSet((Counterparty45__2) o.getRptgCtrPty()))
				.put("othrCtrPty", ExistenceChecker.isSet((Counterparty46__2) o.getOthrCtrPty()))
				.put("submitgAgt", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getSubmitgAgt()))
				.put("nttyRspnsblForRpt", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getNttyRspnsblForRpt()))
				.put("exctnAgt", ExistenceChecker.isSet((List<? extends OrganisationIdentification15Choice__1>) o.getExctnAgt()))
				.put("rltshRcrd", ExistenceChecker.isSet((TradeCounterpartyRelationshipRecord1__1) o.getRltshRcrd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeCounterpartyReport20__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20__2", path, "");
		}
		return failure("TradeCounterpartyReport20__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
