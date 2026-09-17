package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.TaxWithholding;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashPayableOnlyExistsValidator implements ValidatorWithArg<CashPayable, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashPayable> ValidationResult<CashPayable> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("netAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getNetAmount()))
				.put("taxWithholding", ExistenceChecker.isSet((List<? extends TaxWithholding>) o.getTaxWithholding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashPayable", ValidationResult.ValidationType.ONLY_EXISTS, "CashPayable", path, "");
		}
		return failure("CashPayable", ValidationResult.ValidationType.ONLY_EXISTS, "CashPayable", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
