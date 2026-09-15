package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ContractType14__1;
import iso20022.auth030.fca.CurrencyExchange23__1;
import iso20022.auth030.fca.FinancialInstrumentContractType2Code;
import iso20022.auth030.fca.ProductType4Code__1;
import iso20022.auth030.fca.SecurityIdentification41Choice__1;
import iso20022.auth030.fca.SecurityIdentification46__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractType14__1OnlyExistsValidator implements ValidatorWithArg<ContractType14__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractType14__1> ValidationResult<ContractType14__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrctTp", ExistenceChecker.isSet((FinancialInstrumentContractType2Code) o.getCtrctTp()))
				.put("asstClss", ExistenceChecker.isSet((ProductType4Code__1) o.getAsstClss()))
				.put("pdctClssfctn", ExistenceChecker.isSet((String) o.getPdctClssfctn()))
				.put("pdctId", ExistenceChecker.isSet((SecurityIdentification46__1) o.getPdctId()))
				.put("undrlygInstrm", ExistenceChecker.isSet((SecurityIdentification41Choice__1) o.getUndrlygInstrm()))
				.put("sttlmCcy", ExistenceChecker.isSet((CurrencyExchange23__1) o.getSttlmCcy()))
				.put("sttlmCcyScndLeg", ExistenceChecker.isSet((CurrencyExchange23__1) o.getSttlmCcyScndLeg()))
				.put("derivBasedOnCrptAsst", ExistenceChecker.isSet((Boolean) o.getDerivBasedOnCrptAsst()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ContractType14__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractType14__1", path, "");
		}
		return failure("ContractType14__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractType14__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
