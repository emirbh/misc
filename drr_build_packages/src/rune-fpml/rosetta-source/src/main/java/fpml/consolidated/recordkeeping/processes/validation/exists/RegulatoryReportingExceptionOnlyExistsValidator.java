package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.recordkeeping.processes.RegulatoryReportingException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingExceptionOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingException, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingException> ValidationResult<RegulatoryReportingException> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ExceptionMessageHeader) o.getHeader()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.put("additionalData", ExistenceChecker.isSet((AdditionalData) o.getAdditionalData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingException", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingException", path, "");
		}
		return failure("RegulatoryReportingException", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingException", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
