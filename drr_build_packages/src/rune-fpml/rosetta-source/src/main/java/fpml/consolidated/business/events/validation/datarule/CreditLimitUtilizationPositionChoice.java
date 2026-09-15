package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditLimitUtilizationPosition;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CreditLimitUtilizationPositionChoice")
@ImplementedBy(CreditLimitUtilizationPositionChoice.Default.class)
public interface CreditLimitUtilizationPositionChoice extends Validator<CreditLimitUtilizationPosition> {
	
	String NAME = "CreditLimitUtilizationPositionChoice";
	String DEFINITION = "if short exists then long exists else if global exists then long is absent else False";
	
	class Default implements CreditLimitUtilizationPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			ComparisonResult result = executeDataRule(creditLimitUtilizationPosition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditLimitUtilizationPosition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditLimitUtilizationPosition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			try {
				if (exists(MapperS.of(creditLimitUtilizationPosition).<BigDecimal>map("getShort", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getShort())).getOrDefault(false)) {
					return exists(MapperS.of(creditLimitUtilizationPosition).<BigDecimal>map("getLong", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getLong()));
				}
				if (exists(MapperS.of(creditLimitUtilizationPosition).<BigDecimal>map("getGlobal", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getGlobal())).getOrDefault(false)) {
					return notExists(MapperS.of(creditLimitUtilizationPosition).<BigDecimal>map("getLong", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getLong()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditLimitUtilizationPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			return Collections.emptyList();
		}
	}
}
