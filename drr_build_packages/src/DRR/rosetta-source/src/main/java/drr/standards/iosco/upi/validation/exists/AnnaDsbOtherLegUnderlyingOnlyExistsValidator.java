package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbOtherLegUnderlyingOnlyExistsValidator implements ValidatorWithArg<AnnaDsbOtherLegUnderlying, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbOtherLegUnderlying> ValidationResult<AnnaDsbOtherLegUnderlying> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("OtherLegUnderlierID", ExistenceChecker.isSet((String) o.getOtherLegUnderlierID()))
				.put("OtherLegReferenceRate", ExistenceChecker.isSet((String) o.getOtherLegReferenceRate()))
				.put("OtherLegReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit()))
				.put("OtherLegUnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getOtherLegUnderlierCharacteristic()))
				.put("OtherLegUnderlierIDSource", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource()))
				.put("Basket", ExistenceChecker.isSet((AnnaDsbEmpty) o.getBasket()))
				.put("OtherLegReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getOtherLegReferenceRateTermValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOtherLegUnderlying", path, "");
		}
		return failure("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOtherLegUnderlying", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
