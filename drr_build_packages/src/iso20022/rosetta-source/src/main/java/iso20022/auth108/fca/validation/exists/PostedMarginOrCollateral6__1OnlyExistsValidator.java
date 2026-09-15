package iso20022.auth108.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.fca.PostedMarginOrCollateral6__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostedMarginOrCollateral6__1OnlyExistsValidator implements ValidatorWithArg<PostedMarginOrCollateral6__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostedMarginOrCollateral6__1> ValidationResult<PostedMarginOrCollateral6__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initlMrgnPstdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnPstdPreHrcut()))
				.put("initlMrgnPstdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getInitlMrgnPstdPstHrcut()))
				.put("vartnMrgnPstdPreHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnPstdPreHrcut()))
				.put("vartnMrgnPstdPstHrcut", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getVartnMrgnPstdPstHrcut()))
				.put("xcssCollPstd", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getXcssCollPstd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.ONLY_EXISTS, "PostedMarginOrCollateral6__1", path, "");
		}
		return failure("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.ONLY_EXISTS, "PostedMarginOrCollateral6__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
