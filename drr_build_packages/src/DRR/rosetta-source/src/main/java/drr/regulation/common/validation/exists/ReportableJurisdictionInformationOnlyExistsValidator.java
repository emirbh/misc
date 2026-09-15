package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableJurisdictionInformationOnlyExistsValidator implements ValidatorWithArg<ReportableJurisdictionInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableJurisdictionInformation> ValidationResult<ReportableJurisdictionInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regimeName", ExistenceChecker.isSet((FieldWithMetaRegimeNameEnum) o.getRegimeName()))
				.put("supervisoryBody", ExistenceChecker.isSet((FieldWithMetaSupervisoryBodyEnum) o.getSupervisoryBody()))
				.put("transactionInformation", ExistenceChecker.isSet((TransactionInformation) o.getTransactionInformation()))
				.put("partyInformation", ExistenceChecker.isSet((List<? extends JurisdictionPartyInformation>) o.getPartyInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableJurisdictionInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableJurisdictionInformation", path, "");
		}
		return failure("ReportableJurisdictionInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableJurisdictionInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
