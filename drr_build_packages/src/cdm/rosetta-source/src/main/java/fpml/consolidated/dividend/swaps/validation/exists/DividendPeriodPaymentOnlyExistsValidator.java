package fpml.consolidated.dividend.swaps.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.dividend.swaps.DividendPeriodPayment;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendPeriodPaymentOnlyExistsValidator implements ValidatorWithArg<DividendPeriodPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendPeriodPayment> ValidationResult<DividendPeriodPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("unadjustedStartDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedStartDate()))
				.put("unadjustedEndDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedEndDate()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("underlyerReference", ExistenceChecker.isSet((AssetReference) o.getUnderlyerReference()))
				.put("fixedStrike", ExistenceChecker.isSet((BigDecimal) o.getFixedStrike()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDate()))
				.put("valuationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getValuationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendPeriodPayment", ValidationResult.ValidationType.ONLY_EXISTS, "DividendPeriodPayment", path, "");
		}
		return failure("DividendPeriodPayment", ValidationResult.ValidationType.ONLY_EXISTS, "DividendPeriodPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
