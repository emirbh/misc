package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanAllocationSettlementDateAvailability;
import fpml.consolidated.shared.DateList;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanAllocationSettlementDateAvailabilityChoice")
@ImplementedBy(LoanAllocationSettlementDateAvailabilityChoice.Default.class)
public interface LoanAllocationSettlementDateAvailabilityChoice extends Validator<LoanAllocationSettlementDateAvailability> {
	
	String NAME = "LoanAllocationSettlementDateAvailabilityChoice";
	String DEFINITION = "if specificDates exists then startDate is absent and endDate is absent and onOrAfterDate is absent else if startDate exists or endDate exists then startDate exists and endDate exists and specificDates is absent and onOrAfterDate is absent else if onOrAfterDate exists then specificDates is absent and startDate is absent and endDate is absent else False";
	
	class Default implements LoanAllocationSettlementDateAvailabilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementDateAvailability loanAllocationSettlementDateAvailability) {
			ComparisonResult result = executeDataRule(loanAllocationSettlementDateAvailability);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationSettlementDateAvailability", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanAllocationSettlementDateAvailability", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanAllocationSettlementDateAvailability loanAllocationSettlementDateAvailability) {
			try {
				if (exists(MapperS.of(loanAllocationSettlementDateAvailability).<DateList>map("getSpecificDates", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getSpecificDates())).getOrDefault(false)) {
					return notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getStartDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getStartDate())).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getEndDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getEndDate()))).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getOnOrAfterDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getOnOrAfterDate())));
				}
				if (exists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getStartDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getStartDate())).orNullSafe(exists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getEndDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getEndDate()))).getOrDefault(false)) {
					return exists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getStartDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getStartDate())).andNullSafe(exists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getEndDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getEndDate()))).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<DateList>map("getSpecificDates", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getSpecificDates()))).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getOnOrAfterDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getOnOrAfterDate())));
				}
				if (exists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getOnOrAfterDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getOnOrAfterDate())).getOrDefault(false)) {
					return notExists(MapperS.of(loanAllocationSettlementDateAvailability).<DateList>map("getSpecificDates", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getSpecificDates())).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getStartDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getStartDate()))).andNullSafe(notExists(MapperS.of(loanAllocationSettlementDateAvailability).<ZonedDateTime>map("getEndDate", _loanAllocationSettlementDateAvailability -> _loanAllocationSettlementDateAvailability.getEndDate())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanAllocationSettlementDateAvailabilityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementDateAvailability loanAllocationSettlementDateAvailability) {
			return Collections.emptyList();
		}
	}
}
