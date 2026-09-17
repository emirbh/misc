package fpml.consolidated.sec.lending.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.sec.lending.SecurityLending;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SecurityLendingChoice1")
@ImplementedBy(SecurityLendingChoice1.Default.class)
public interface SecurityLendingChoice1 extends Validator<SecurityLending> {
	
	String NAME = "SecurityLendingChoice1";
	String DEFINITION = "fee exists or rebate exists";
	
	class Default implements SecurityLendingChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityLending securityLending) {
			ComparisonResult result = executeDataRule(securityLending);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityLending", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityLending", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecurityLending securityLending) {
			try {
				return exists(MapperS.of(securityLending).<SecLendFeeCalculation>map("getFee", _securityLending -> _securityLending.getFee())).orNullSafe(exists(MapperS.of(securityLending).<SecLendRebateCalculation>map("getRebate", _securityLending -> _securityLending.getRebate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityLendingChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityLending securityLending) {
			return Collections.emptyList();
		}
	}
}
