package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductParties;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductPartiesOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductParties, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductParties> ValidationResult<RegulatoryReportingProductParties> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("fixedPayerPartyReference", ExistenceChecker.isSet((PartyReference) o.getFixedPayerPartyReference()))
				.put("fixedReceiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getFixedReceiverPartyReference()))
				.put("floatingPayerPartyReference", ExistenceChecker.isSet((PartyReference) o.getFloatingPayerPartyReference()))
				.put("floatingReceiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getFloatingReceiverPartyReference()))
				.put("floating2PayerPartyReference", ExistenceChecker.isSet((PartyReference) o.getFloating2PayerPartyReference()))
				.put("floating2ReceiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getFloating2ReceiverPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductParties", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductParties", path, "");
		}
		return failure("RegulatoryReportingProductParties", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductParties", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
