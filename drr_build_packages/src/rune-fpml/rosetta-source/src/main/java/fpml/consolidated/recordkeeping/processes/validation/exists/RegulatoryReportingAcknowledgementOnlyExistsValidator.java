package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.recordkeeping.processes.RegulatoryReportingAcknowledgement;
import fpml.consolidated.reg.fpmlreporting.shared.ReportingStatus;
import fpml.consolidated.shared.Party;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingAcknowledgementOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingAcknowledgement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingAcknowledgement> ValidationResult<RegulatoryReportingAcknowledgement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ResponseMessageHeader) o.getHeader()))
				.put("tradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getTradeIdentifier()))
				.put("reportingStatus", ExistenceChecker.isSet((List<? extends ReportingStatus>) o.getReportingStatus()))
				.put("additionalData", ExistenceChecker.isSet((AdditionalData) o.getAdditionalData()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingAcknowledgement", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingAcknowledgement", path, "");
		}
		return failure("RegulatoryReportingAcknowledgement", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingAcknowledgement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
