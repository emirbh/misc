package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.LoanTradingAccruingFeeTypeEnum;
import fpml.consolidated.loan.AccrualPeriod;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanTradingFacilityFeeAccrual;
import fpml.consolidated.shared.Money;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingFacilityFeeAccrualOnlyExistsValidator implements ValidatorWithArg<LoanTradingFacilityFeeAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingFacilityFeeAccrual> ValidationResult<LoanTradingFacilityFeeAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("accrualPeriod", ExistenceChecker.isSet((List<? extends AccrualPeriod>) o.getAccrualPeriod()))
				.put("accruingFeeTypeId", ExistenceChecker.isSet((AccrualTypeId) o.getAccruingFeeTypeId()))
				.put("accruingFeeType", ExistenceChecker.isSet((LoanTradingAccruingFeeTypeEnum) o.getAccruingFeeType()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingFacilityFeeAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingFacilityFeeAccrual", path, "");
		}
		return failure("LoanTradingFacilityFeeAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingFacilityFeeAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
