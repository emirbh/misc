package iso20022.auth108.mas.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.mas.DerivativesTradeMarginDataReportV02;
import iso20022.auth108.mas.Document;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DocumentOnlyExistsValidator implements ValidatorWithArg<Document, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Document> ValidationResult<Document> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("derivsTradMrgnDataRpt", ExistenceChecker.isSet((DerivativesTradeMarginDataReportV02) o.getDerivsTradMrgnDataRpt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Document", ValidationResult.ValidationType.ONLY_EXISTS, "Document", path, "");
		}
		return failure("Document", ValidationResult.ValidationType.ONLY_EXISTS, "Document", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
