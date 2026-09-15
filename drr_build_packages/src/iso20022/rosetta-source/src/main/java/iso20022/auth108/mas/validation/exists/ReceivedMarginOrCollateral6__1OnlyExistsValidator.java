package iso20022.auth108.mas.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.mas.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.mas.ReceivedMarginOrCollateral6__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReceivedMarginOrCollateral6__1OnlyExistsValidator implements ValidatorWithArg<ReceivedMarginOrCollateral6__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReceivedMarginOrCollateral6__1> ValidationResult<ReceivedMarginOrCollateral6__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initlMrgnRcvdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnRcvdPreHrcut()))
				.put("initlMrgnRcvdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnRcvdPstHrcut()))
				.put("vartnMrgnRcvdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnRcvdPreHrcut()))
				.put("vartnMrgnRcvdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnRcvdPstHrcut()))
				.put("xcssCollRcvd", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getXcssCollRcvd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReceivedMarginOrCollateral6__1", ValidationResult.ValidationType.ONLY_EXISTS, "ReceivedMarginOrCollateral6__1", path, "");
		}
		return failure("ReceivedMarginOrCollateral6__1", ValidationResult.ValidationType.ONLY_EXISTS, "ReceivedMarginOrCollateral6__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
