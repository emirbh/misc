package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReturnTermsBase;
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
@RosettaDataRule("ReturnTermsBasePositiveExpectedN")
@ImplementedBy(ReturnTermsBasePositiveExpectedN.Default.class)
public interface ReturnTermsBasePositiveExpectedN extends Validator<ReturnTermsBase> {
	
	String NAME = "ReturnTermsBasePositiveExpectedN";
	String DEFINITION = "expectedN > 0";
	
	class Default implements ReturnTermsBasePositiveExpectedN {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnTermsBase returnTermsBase) {
			ComparisonResult result = executeDataRule(returnTermsBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnTermsBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnTermsBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReturnTermsBase returnTermsBase) {
			try {
				return greaterThan(MapperS.of(returnTermsBase).<Integer>map("getExpectedN", _returnTermsBase -> _returnTermsBase.getExpectedN()), MapperS.of(0), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnTermsBasePositiveExpectedN {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnTermsBase returnTermsBase) {
			return Collections.emptyList();
		}
	}
}
