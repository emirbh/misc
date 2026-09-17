package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.RequestRegulatoryReportingStatus;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RequestRegulatoryReportingStatusOnlyExistsValidator implements ValidatorWithArg<RequestRegulatoryReportingStatus, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RequestRegulatoryReportingStatus> ValidationResult<RequestRegulatoryReportingStatus> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((NotificationMessageHeader) o.getHeader()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("tradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getTradeIdentifier()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RequestRegulatoryReportingStatus", ValidationResult.ValidationType.ONLY_EXISTS, "RequestRegulatoryReportingStatus", path, "");
		}
		return failure("RequestRegulatoryReportingStatus", ValidationResult.ValidationType.ONLY_EXISTS, "RequestRegulatoryReportingStatus", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
