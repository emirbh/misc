package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierType;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUnderlyingOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUnderlying, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUnderlying> ValidationResult<AnnaDsbUnderlying> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic()))
				.put("ReferenceRate", ExistenceChecker.isSet((String) o.getReferenceRate()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("UnderlyingInstrumentISIN", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentISIN()))
				.put("UnderlyingCreditIndexVersion", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexVersion()))
				.put("UnderlierType", ExistenceChecker.isSet((AnnaDsbUnderlierType) o.getUnderlierType()))
				.put("Basket", ExistenceChecker.isSet((AnnaDsbEmpty) o.getBasket()))
				.put("ReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit()))
				.put("UnderlyingAssetType", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetType) o.getUnderlyingAssetType()))
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("UnderlyingCreditIndexSeries", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexSeries()))
				.put("InstrumentISIN", ExistenceChecker.isSet((String) o.getInstrumentISIN()))
				.put("InstrumentLEI", ExistenceChecker.isSet((String) o.getInstrumentLEI()))
				.put("UnderlyingInstrumentIndex", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndex()))
				.put("UnderlyingInstrumentIndexProp", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndexProp()))
				.put("ReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getReferenceRateTermValue()))
				.put("UnderlyingInstrumentUPI", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentUPI()))
				.put("UnderlyingInstrumentLEI", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentLEI()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUnderlying", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlying", path, "");
		}
		return failure("AnnaDsbUnderlying", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlying", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
