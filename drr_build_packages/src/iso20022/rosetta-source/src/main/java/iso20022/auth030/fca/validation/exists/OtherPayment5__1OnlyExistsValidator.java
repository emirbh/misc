package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection106__2;
import iso20022.auth030.fca.OtherPayment5__1;
import iso20022.auth030.fca.PartyIdentification236Choice__1;
import iso20022.auth030.fca.PaymentType5Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OtherPayment5__1OnlyExistsValidator implements ValidatorWithArg<OtherPayment5__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OtherPayment5__1> ValidationResult<OtherPayment5__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pmtAmt", ExistenceChecker.isSet((AmountAndDirection106__2) o.getPmtAmt()))
				.put("pmtTp", ExistenceChecker.isSet((PaymentType5Choice__1) o.getPmtTp()))
				.put("pmtDt", ExistenceChecker.isSet((Date) o.getPmtDt()))
				.put("pmtPyer", ExistenceChecker.isSet((PartyIdentification236Choice__1) o.getPmtPyer()))
				.put("pmtRcvr", ExistenceChecker.isSet((PartyIdentification236Choice__1) o.getPmtRcvr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OtherPayment5__1", ValidationResult.ValidationType.ONLY_EXISTS, "OtherPayment5__1", path, "");
		}
		return failure("OtherPayment5__1", ValidationResult.ValidationType.ONLY_EXISTS, "OtherPayment5__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
