package iso20022.auth108.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.Counterparty45__1;
import iso20022.auth108.asic.Counterparty46__1;
import iso20022.auth108.asic.OrganisationIdentification15Choice__1;
import iso20022.auth108.asic.TradeCounterpartyReport20__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeCounterpartyReport20__1OnlyExistsValidator implements ValidatorWithArg<TradeCounterpartyReport20__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeCounterpartyReport20__1> ValidationResult<TradeCounterpartyReport20__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptgCtrPty", ExistenceChecker.isSet((Counterparty45__1) o.getRptgCtrPty()))
				.put("othrCtrPty", ExistenceChecker.isSet((Counterparty46__1) o.getOthrCtrPty()))
				.put("submitgAgt", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getSubmitgAgt()))
				.put("nttyRspnsblForRpt", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getNttyRspnsblForRpt()))
				.put("exctnAgt", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getExctnAgt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeCounterpartyReport20__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20__1", path, "");
		}
		return failure("TradeCounterpartyReport20__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyReport20__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
