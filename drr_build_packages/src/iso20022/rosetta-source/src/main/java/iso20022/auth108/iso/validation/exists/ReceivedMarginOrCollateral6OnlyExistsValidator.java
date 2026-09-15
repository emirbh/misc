package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.ActiveOrHistoricCurrencyAnd20DecimalAmount;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReceivedMarginOrCollateral6OnlyExistsValidator implements ValidatorWithArg<ReceivedMarginOrCollateral6, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReceivedMarginOrCollateral6> ValidationResult<ReceivedMarginOrCollateral6> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initlMrgnRcvdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd20DecimalAmount) o.getInitlMrgnRcvdPreHrcut()))
				.put("initlMrgnRcvdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd20DecimalAmount) o.getInitlMrgnRcvdPstHrcut()))
				.put("vartnMrgnRcvdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd20DecimalAmount) o.getVartnMrgnRcvdPreHrcut()))
				.put("vartnMrgnRcvdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd20DecimalAmount) o.getVartnMrgnRcvdPstHrcut()))
				.put("xcssCollRcvd", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd20DecimalAmount) o.getXcssCollRcvd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReceivedMarginOrCollateral6", ValidationResult.ValidationType.ONLY_EXISTS, "ReceivedMarginOrCollateral6", path, "");
		}
		return failure("ReceivedMarginOrCollateral6", ValidationResult.ValidationType.ONLY_EXISTS, "ReceivedMarginOrCollateral6", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
