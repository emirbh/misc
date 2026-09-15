package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AccrualOptionChange;
import fpml.consolidated.loan.AccruingPikOption;
import fpml.consolidated.loan.FixedRateOption;
import fpml.consolidated.loan.LcOption;
import fpml.consolidated.loan.LegacyFloatingRateOption;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanFloatingRateOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AccrualOptionChangeChoice")
@ImplementedBy(AccrualOptionChangeChoice.Default.class)
public interface AccrualOptionChangeChoice extends Validator<AccrualOptionChange> {
	
	String NAME = "AccrualOptionChangeChoice";
	String DEFINITION = "if fixedRateOption exists then floatingRateOption is absent and legacyFloatingRateOption is absent and accruingPikOption is absent and lcOption is absent and letterOfCreditReference is absent else if floatingRateOption exists then fixedRateOption is absent and legacyFloatingRateOption is absent and accruingPikOption is absent and lcOption is absent and letterOfCreditReference is absent else if legacyFloatingRateOption exists then fixedRateOption is absent and floatingRateOption is absent and accruingPikOption is absent and lcOption is absent and letterOfCreditReference is absent else if accruingPikOption exists then fixedRateOption is absent and floatingRateOption is absent and legacyFloatingRateOption is absent and loanContractReference is absent and lcOption is absent and letterOfCreditReference is absent else if lcOption exists then fixedRateOption is absent and floatingRateOption is absent and legacyFloatingRateOption is absent and accruingPikOption is absent and loanContractReference is absent else False";
	
	class Default implements AccrualOptionChangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionChange accrualOptionChange) {
			ComparisonResult result = executeDataRule(accrualOptionChange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AccrualOptionChange accrualOptionChange) {
			try {
				if (exists(MapperS.of(accrualOptionChange).<FixedRateOption>map("getFixedRateOption", _accrualOptionChange -> _accrualOptionChange.getFixedRateOption())).getOrDefault(false)) {
					return notExists(MapperS.of(accrualOptionChange).<LoanFloatingRateOption>map("getFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getFloatingRateOption())).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getLegacyFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<AccruingPikOption>map("getAccruingPikOption", _accrualOptionChange -> _accrualOptionChange.getAccruingPikOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LcOption>map("getLcOption", _accrualOptionChange -> _accrualOptionChange.getLcOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LetterOfCreditReference>mapC("getLetterOfCreditReference", _accrualOptionChange -> _accrualOptionChange.getLetterOfCreditReference())));
				}
				if (exists(MapperS.of(accrualOptionChange).<LoanFloatingRateOption>map("getFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getFloatingRateOption())).getOrDefault(false)) {
					return notExists(MapperS.of(accrualOptionChange).<FixedRateOption>map("getFixedRateOption", _accrualOptionChange -> _accrualOptionChange.getFixedRateOption())).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getLegacyFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<AccruingPikOption>map("getAccruingPikOption", _accrualOptionChange -> _accrualOptionChange.getAccruingPikOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LcOption>map("getLcOption", _accrualOptionChange -> _accrualOptionChange.getLcOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LetterOfCreditReference>mapC("getLetterOfCreditReference", _accrualOptionChange -> _accrualOptionChange.getLetterOfCreditReference())));
				}
				if (exists(MapperS.of(accrualOptionChange).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getLegacyFloatingRateOption())).getOrDefault(false)) {
					return notExists(MapperS.of(accrualOptionChange).<FixedRateOption>map("getFixedRateOption", _accrualOptionChange -> _accrualOptionChange.getFixedRateOption())).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LoanFloatingRateOption>map("getFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<AccruingPikOption>map("getAccruingPikOption", _accrualOptionChange -> _accrualOptionChange.getAccruingPikOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LcOption>map("getLcOption", _accrualOptionChange -> _accrualOptionChange.getLcOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LetterOfCreditReference>mapC("getLetterOfCreditReference", _accrualOptionChange -> _accrualOptionChange.getLetterOfCreditReference())));
				}
				if (exists(MapperS.of(accrualOptionChange).<AccruingPikOption>map("getAccruingPikOption", _accrualOptionChange -> _accrualOptionChange.getAccruingPikOption())).getOrDefault(false)) {
					return notExists(MapperS.of(accrualOptionChange).<FixedRateOption>map("getFixedRateOption", _accrualOptionChange -> _accrualOptionChange.getFixedRateOption())).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LoanFloatingRateOption>map("getFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getLegacyFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LoanContractReference>mapC("getLoanContractReference", _accrualOptionChange -> _accrualOptionChange.getLoanContractReference()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LcOption>map("getLcOption", _accrualOptionChange -> _accrualOptionChange.getLcOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LetterOfCreditReference>mapC("getLetterOfCreditReference", _accrualOptionChange -> _accrualOptionChange.getLetterOfCreditReference())));
				}
				if (exists(MapperS.of(accrualOptionChange).<LcOption>map("getLcOption", _accrualOptionChange -> _accrualOptionChange.getLcOption())).getOrDefault(false)) {
					return notExists(MapperS.of(accrualOptionChange).<FixedRateOption>map("getFixedRateOption", _accrualOptionChange -> _accrualOptionChange.getFixedRateOption())).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LoanFloatingRateOption>map("getFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _accrualOptionChange -> _accrualOptionChange.getLegacyFloatingRateOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<AccruingPikOption>map("getAccruingPikOption", _accrualOptionChange -> _accrualOptionChange.getAccruingPikOption()))).andNullSafe(notExists(MapperS.of(accrualOptionChange).<LoanContractReference>mapC("getLoanContractReference", _accrualOptionChange -> _accrualOptionChange.getLoanContractReference())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AccrualOptionChangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionChange accrualOptionChange) {
			return Collections.emptyList();
		}
	}
}
