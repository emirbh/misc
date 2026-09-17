package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationOther;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationOtherOnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationOther, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationOther> ValidationResult<RegulatoryClassificationOther> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((SupervisoryBody) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationOther", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationOther", path, "");
		}
		return failure("RegulatoryClassificationOther", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationOther", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
