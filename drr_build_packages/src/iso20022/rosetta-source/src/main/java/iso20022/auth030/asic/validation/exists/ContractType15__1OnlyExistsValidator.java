package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ContractType15__1;
import iso20022.auth030.asic.CurrencyExchange23__1;
import iso20022.auth030.asic.FinancialInstrumentContractType2Code;
import iso20022.auth030.asic.ProductType4Code__1;
import iso20022.auth030.asic.SecurityIdentification41Choice__1;
import iso20022.auth030.asic.SecurityIdentification46__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractType15__1OnlyExistsValidator implements ValidatorWithArg<ContractType15__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractType15__1> ValidationResult<ContractType15__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrctTp", ExistenceChecker.isSet((FinancialInstrumentContractType2Code) o.getCtrctTp()))
				.put("asstClss", ExistenceChecker.isSet((ProductType4Code__1) o.getAsstClss()))
				.put("pdctId", ExistenceChecker.isSet((SecurityIdentification46__1) o.getPdctId()))
				.put("undrlygInstrm", ExistenceChecker.isSet((SecurityIdentification41Choice__1) o.getUndrlygInstrm()))
				.put("sttlmCcy", ExistenceChecker.isSet((CurrencyExchange23__1) o.getSttlmCcy()))
				.put("sttlmCcyScndLeg", ExistenceChecker.isSet((CurrencyExchange23__1) o.getSttlmCcyScndLeg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ContractType15__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractType15__1", path, "");
		}
		return failure("ContractType15__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractType15__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
