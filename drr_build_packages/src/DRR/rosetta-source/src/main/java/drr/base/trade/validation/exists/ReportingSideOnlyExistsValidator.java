package drr.base.trade.validation.exists;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportingSide;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingSideOnlyExistsValidator implements ValidatorWithArg<ReportingSide, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingSide> ValidationResult<ReportingSide> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingParty", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getReportingParty()))
				.put("reportingCounterparty", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getReportingCounterparty()))
				.put("partyResponsibleForReporting", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getPartyResponsibleForReporting()))
				.put("reportSubmittingParty", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getReportSubmittingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingSide", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingSide", path, "");
		}
		return failure("ReportingSide", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingSide", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
