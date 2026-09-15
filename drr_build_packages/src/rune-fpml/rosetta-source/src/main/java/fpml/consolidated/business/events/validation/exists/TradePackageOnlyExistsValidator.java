package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.PackageHeader;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradePackageSequence;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeIdentifier;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradePackageOnlyExistsValidator implements ValidatorWithArg<TradePackage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradePackage> ValidationResult<TradePackage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("packageHeader", ExistenceChecker.isSet((PackageHeader) o.getPackageHeader()))
				.put("trade", ExistenceChecker.isSet((List<? extends Trade>) o.getTrade()))
				.put("tradePackageSequence", ExistenceChecker.isSet((List<? extends TradePackageSequence>) o.getTradePackageSequence()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getTradeIdentifier()))
				.put("approvals", ExistenceChecker.isSet((Approvals) o.getApprovals()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradePackage", ValidationResult.ValidationType.ONLY_EXISTS, "TradePackage", path, "");
		}
		return failure("TradePackage", ValidationResult.ValidationType.ONLY_EXISTS, "TradePackage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
