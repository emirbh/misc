package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCalculationTerms;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Frequency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductCalculationTermsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductCalculationTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductCalculationTerms> ValidationResult<RegulatoryReportingProductCalculationTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dayCountFraction", ExistenceChecker.isSet((List<? extends DayCountFraction>) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((List<? extends Frequency>) o.getPaymentFrequency()))
				.put("calculationFrequency", ExistenceChecker.isSet((List<? extends Frequency>) o.getCalculationFrequency()))
				.put("resetFrequency", ExistenceChecker.isSet((List<? extends Frequency>) o.getResetFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductCalculationTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductCalculationTerms", path, "");
		}
		return failure("RegulatoryReportingProductCalculationTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductCalculationTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
