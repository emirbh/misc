package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.SinglePayment;
import fpml.consolidated.fpmlenum.QuotationStyleEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FeeLegOnlyExistsValidator implements ValidatorWithArg<FeeLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FeeLeg> ValidationResult<FeeLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("initialPayment", ExistenceChecker.isSet((InitialPayment) o.getInitialPayment()))
				.put("singlePayment", ExistenceChecker.isSet((List<? extends SinglePayment>) o.getSinglePayment()))
				.put("periodicPayment", ExistenceChecker.isSet((PeriodicPayment) o.getPeriodicPayment()))
				.put("marketFixedRate", ExistenceChecker.isSet((BigDecimal) o.getMarketFixedRate()))
				.put("paymentDelay", ExistenceChecker.isSet((Boolean) o.getPaymentDelay()))
				.put("initialPoints", ExistenceChecker.isSet((BigDecimal) o.getInitialPoints()))
				.put("marketPrice", ExistenceChecker.isSet((BigDecimal) o.getMarketPrice()))
				.put("quotationStyle", ExistenceChecker.isSet((QuotationStyleEnum) o.getQuotationStyle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FeeLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FeeLeg", path, "");
		}
		return failure("FeeLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FeeLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
