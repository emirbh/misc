package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.SimpleCreditDefaultSwap;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SimpleCreditDefaultSwapOnlyExistsValidator implements ValidatorWithArg<SimpleCreditDefaultSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SimpleCreditDefaultSwap> ValidationResult<SimpleCreditDefaultSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("referenceEntity", ExistenceChecker.isSet((LegalEntity) o.getReferenceEntity()))
				.put("creditEntityReference", ExistenceChecker.isSet((LegalEntityReference) o.getCreditEntityReference()))
				.put("term", ExistenceChecker.isSet((Period) o.getTerm()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SimpleCreditDefaultSwap", ValidationResult.ValidationType.ONLY_EXISTS, "SimpleCreditDefaultSwap", path, "");
		}
		return failure("SimpleCreditDefaultSwap", ValidationResult.ValidationType.ONLY_EXISTS, "SimpleCreditDefaultSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
