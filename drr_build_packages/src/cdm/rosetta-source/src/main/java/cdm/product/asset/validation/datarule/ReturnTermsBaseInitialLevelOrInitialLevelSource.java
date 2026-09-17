package cdm.product.asset.validation.datarule;

import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.ReturnTermsBase;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ReturnTermsBaseInitialLevelOrInitialLevelSource")
@ImplementedBy(ReturnTermsBaseInitialLevelOrInitialLevelSource.Default.class)
public interface ReturnTermsBaseInitialLevelOrInitialLevelSource extends Validator<ReturnTermsBase> {
	
	String NAME = "ReturnTermsBaseInitialLevelOrInitialLevelSource";
	String DEFINITION = "if initialLevel is absent then initialLevelSource exists and if initialLevelSource is absent then initialLevel exists";
	
	class Default implements ReturnTermsBaseInitialLevelOrInitialLevelSource {
	
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
				if (notExists(MapperS.of(returnTermsBase).<BigDecimal>map("getInitialLevel", _returnTermsBase -> _returnTermsBase.getInitialLevel())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (notExists(MapperS.of(returnTermsBase).<DeterminationMethodEnum>map("getInitialLevelSource", _returnTermsBase -> _returnTermsBase.getInitialLevelSource())).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(returnTermsBase).<BigDecimal>map("getInitialLevel", _returnTermsBase -> _returnTermsBase.getInitialLevel()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return exists(MapperS.of(returnTermsBase).<DeterminationMethodEnum>map("getInitialLevelSource", _returnTermsBase -> _returnTermsBase.getInitialLevelSource())).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnTermsBaseInitialLevelOrInitialLevelSource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnTermsBase returnTermsBase) {
			return Collections.emptyList();
		}
	}
}
