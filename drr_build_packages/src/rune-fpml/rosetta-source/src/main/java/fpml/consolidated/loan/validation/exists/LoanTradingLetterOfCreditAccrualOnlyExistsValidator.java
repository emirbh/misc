package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.LoanTradingLetterOfCreditFeeTypeEnum;
import fpml.consolidated.loan.AccrualPeriod;
import fpml.consolidated.loan.LcFeeTypeId;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanTradingLetterOfCreditAccrual;
import fpml.consolidated.shared.Money;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingLetterOfCreditAccrualOnlyExistsValidator implements ValidatorWithArg<LoanTradingLetterOfCreditAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingLetterOfCreditAccrual> ValidationResult<LoanTradingLetterOfCreditAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("accrualPeriod", ExistenceChecker.isSet((List<? extends AccrualPeriod>) o.getAccrualPeriod()))
				.put("lcFeeTypeId", ExistenceChecker.isSet((LcFeeTypeId) o.getLcFeeTypeId()))
				.put("lcFeeType", ExistenceChecker.isSet((LoanTradingLetterOfCreditFeeTypeEnum) o.getLcFeeType()))
				.put("letterOfCreditReference", ExistenceChecker.isSet((LetterOfCreditReference) o.getLetterOfCreditReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingLetterOfCreditAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingLetterOfCreditAccrual", path, "");
		}
		return failure("LoanTradingLetterOfCreditAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingLetterOfCreditAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
