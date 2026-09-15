package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Core;
import iso20022.dtcc.rds.harmonized.DataResponse;
import iso20022.dtcc.rds.harmonized.GenericAttribute;
import iso20022.dtcc.rds.harmonized.Header;
import iso20022.dtcc.rds.harmonized.SubmissionWrapper;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DataResponseOnlyExistsValidator implements ValidatorWithArg<DataResponse, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DataResponse> ValidationResult<DataResponse> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("header", ExistenceChecker.isSet((Header) o.getHeader()))
				.put("submissionValidationStatus", ExistenceChecker.isSet((List<? extends GenericAttribute>) o.getSubmissionValidationStatus()))
				.put("core", ExistenceChecker.isSet((Core) o.getCore()))
				.put("error", ExistenceChecker.isSet((List<? extends iso20022.dtcc.rds.harmonized.Error>) o.getError()))
				.put("originalSubmission", ExistenceChecker.isSet((SubmissionWrapper) o.getOriginalSubmission()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DataResponse", ValidationResult.ValidationType.ONLY_EXISTS, "DataResponse", path, "");
		}
		return failure("DataResponse", ValidationResult.ValidationType.ONLY_EXISTS, "DataResponse", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
