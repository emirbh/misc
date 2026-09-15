package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbCDSIndexOnlyExistsValidator implements ValidatorWithArg<AnnaDsbCDSIndex, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbCDSIndex> ValidationResult<AnnaDsbCDSIndex> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("UnderlyingCreditIndexSeries", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexSeries()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("UnderlyingCreditIndexVersion", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexVersion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbCDSIndex", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCDSIndex", path, "");
		}
		return failure("AnnaDsbCDSIndex", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCDSIndex", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
