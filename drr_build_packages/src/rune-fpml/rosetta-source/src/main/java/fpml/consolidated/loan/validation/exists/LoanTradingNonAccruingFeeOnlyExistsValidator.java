package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.LoanTradingNonAccruingFeeTypeEnum;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanTradingNonAccruingFee;
import fpml.consolidated.loan.MiscFeeType;
import fpml.consolidated.loan.NonAccruingFeeTypeId;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingNonAccruingFeeOnlyExistsValidator implements ValidatorWithArg<LoanTradingNonAccruingFee, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingNonAccruingFee> ValidationResult<LoanTradingNonAccruingFee> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("nonAccruingFeeTypeId", ExistenceChecker.isSet((NonAccruingFeeTypeId) o.getNonAccruingFeeTypeId()))
				.put("nonAccruingFeetype", ExistenceChecker.isSet((LoanTradingNonAccruingFeeTypeEnum) o.getNonAccruingFeetype()))
				.put("miscFeeType", ExistenceChecker.isSet((MiscFeeType) o.getMiscFeeType()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("loanContractReference", ExistenceChecker.isSet((LoanContractReference) o.getLoanContractReference()))
				.put("letterOfCreditReference", ExistenceChecker.isSet((LetterOfCreditReference) o.getLetterOfCreditReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingNonAccruingFee", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingNonAccruingFee", path, "");
		}
		return failure("LoanTradingNonAccruingFee", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingNonAccruingFee", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
