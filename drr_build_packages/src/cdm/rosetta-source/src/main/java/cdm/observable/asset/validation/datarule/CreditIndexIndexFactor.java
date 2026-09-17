package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CreditIndexIndexFactor")
@ImplementedBy(CreditIndexIndexFactor.Default.class)
public interface CreditIndexIndexFactor extends Validator<CreditIndex> {
	
	String NAME = "CreditIndexIndexFactor";
	String DEFINITION = "if indexFactor exists then indexFactor >= 0 and indexFactor <= 1";
	
	class Default implements CreditIndexIndexFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditIndex creditIndex) {
			ComparisonResult result = executeDataRule(creditIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditIndex creditIndex) {
			try {
				if (exists(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(creditIndex).<BigDecimal>map("getIndexFactor", _creditIndex -> _creditIndex.getIndexFactor()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditIndexIndexFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditIndex creditIndex) {
			return Collections.emptyList();
		}
	}
}
