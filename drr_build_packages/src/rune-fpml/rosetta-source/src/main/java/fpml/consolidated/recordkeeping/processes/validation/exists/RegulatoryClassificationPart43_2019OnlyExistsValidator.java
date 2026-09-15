package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegReportingPackageInfo;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2019;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationPart43_2019OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationPart43_2019, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationPart43_2019> ValidationResult<RegulatoryClassificationPart43_2019> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<String>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("cancellationOfPublicReporting", ExistenceChecker.isSet((Boolean) o.getCancellationOfPublicReporting()))
				.put("cleared", ExistenceChecker.isSet((String) o.getCleared()))
				.put("endUserException", ExistenceChecker.isSet((Boolean) o.getEndUserException()))
				.put("executionVenueType", ExistenceChecker.isSet((ExecutionVenueType) o.getExecutionVenueType()))
				.put("collateralizationType", ExistenceChecker.isSet((CollateralizationType) o.getCollateralizationType()))
				.put("offMarketPrice", ExistenceChecker.isSet((Boolean) o.getOffMarketPrice()))
				.put("largeSizeTrade", ExistenceChecker.isSet((Boolean) o.getLargeSizeTrade()))
				.put("clearingService", ExistenceChecker.isSet((PartyReference) o.getClearingService()))
				.put("packageInfo", ExistenceChecker.isSet((RegReportingPackageInfo) o.getPackageInfo()))
				.put("disseminationTime", ExistenceChecker.isSet((ZonedDateTime) o.getDisseminationTime()))
				.put("disseminationId", ExistenceChecker.isSet((String) o.getDisseminationId()))
				.put("originalDisseminationId", ExistenceChecker.isSet((String) o.getOriginalDisseminationId()))
				.put("postPricedIndicator", ExistenceChecker.isSet((Boolean) o.getPostPricedIndicator()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart43_2019", path, "");
		}
		return failure("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationPart43_2019", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
