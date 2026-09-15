package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ClearingExceptionReasonEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ClearingExceptionClearingException")
@ImplementedBy(ClearingExceptionClearingException.Default.class)
public interface ClearingExceptionClearingException extends Validator<ClearingException> {
	
	String NAME = "ClearingExceptionClearingException";
	String DEFINITION = "if clearingException = True then clearingExceptionReason exists else if clearingExceptionReason exists then clearingException = True";
	
	class Default implements ClearingExceptionClearingException {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingException clearingException) {
			ComparisonResult result = executeDataRule(clearingException);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingException", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingException", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ClearingException clearingException) {
			try {
				if (areEqual(MapperS.of(clearingException).<Boolean>map("getClearingException", _clearingException -> _clearingException.getClearingException()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(clearingException).<ClearingExceptionReasonEnum>mapC("getClearingExceptionReason", _clearingException -> _clearingException.getClearingExceptionReason()));
				}
				if (exists(MapperS.of(clearingException).<ClearingExceptionReasonEnum>mapC("getClearingExceptionReason", _clearingException -> _clearingException.getClearingExceptionReason())).getOrDefault(false)) {
					return areEqual(MapperS.of(clearingException).<Boolean>map("getClearingException", _clearingException -> _clearingException.getClearingException()), MapperS.of(true), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingExceptionClearingException {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingException clearingException) {
			return Collections.emptyList();
		}
	}
}
