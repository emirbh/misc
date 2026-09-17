package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.business.events.CompressionType;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.TradeId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CompressionActivityOnlyExistsValidator implements ValidatorWithArg<CompressionActivity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CompressionActivity> ValidationResult<CompressionActivity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("compressionType", ExistenceChecker.isSet((CompressionType) o.getCompressionType()))
				.put("replacementTradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getReplacementTradeIdentifier()))
				.put("originatingTradeIdentifier", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getOriginatingTradeIdentifier()))
				.put("replacementTradeId", ExistenceChecker.isSet((TradeId) o.getReplacementTradeId()))
				.put("originatingTradeId", ExistenceChecker.isSet((List<? extends TradeId>) o.getOriginatingTradeId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CompressionActivity", ValidationResult.ValidationType.ONLY_EXISTS, "CompressionActivity", path, "");
		}
		return failure("CompressionActivity", ValidationResult.ValidationType.ONLY_EXISTS, "CompressionActivity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
