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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CreditIndexIndexSeries")
@ImplementedBy(CreditIndexIndexSeries.Default.class)
public interface CreditIndexIndexSeries extends Validator<CreditIndex> {
	
	String NAME = "CreditIndexIndexSeries";
	String DEFINITION = "if indexSeries exists then indexSeries >= 0";
	
	class Default implements CreditIndexIndexSeries {
	
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
				if (exists(MapperS.of(creditIndex).<Integer>map("getIndexSeries", _creditIndex -> _creditIndex.getIndexSeries())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(creditIndex).<Integer>map("getIndexSeries", _creditIndex -> _creditIndex.getIndexSeries()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditIndexIndexSeries {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditIndex creditIndex) {
			return Collections.emptyList();
		}
	}
}
