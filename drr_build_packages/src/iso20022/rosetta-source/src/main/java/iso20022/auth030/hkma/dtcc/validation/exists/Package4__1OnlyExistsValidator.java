package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.Package4__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice20Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Package4__1OnlyExistsValidator implements ValidatorWithArg<Package4__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Package4__1> ValidationResult<Package4__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cmplxTradId", ExistenceChecker.isSet((String) o.getCmplxTradId()))
				.put("fxSwpLkId", ExistenceChecker.isSet((String) o.getFxSwpLkId()))
				.put("pric", ExistenceChecker.isSet((SecuritiesTransactionPrice17Choice__1) o.getPric()))
				.put("sprd", ExistenceChecker.isSet((SecuritiesTransactionPrice20Choice__1) o.getSprd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Package4__1", ValidationResult.ValidationType.ONLY_EXISTS, "Package4__1", path, "");
		}
		return failure("Package4__1", ValidationResult.ValidationType.ONLY_EXISTS, "Package4__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
