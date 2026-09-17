package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.ConditionsPrecedent;
import cdm.legaldocumentation.csa.ExceptionEnum;
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
@RosettaDataRule("ConditionsPrecedentCustomProvision")
@ImplementedBy(ConditionsPrecedentCustomProvision.Default.class)
public interface ConditionsPrecedentCustomProvision extends Validator<ConditionsPrecedent> {
	
	String NAME = "ConditionsPrecedentCustomProvision";
	String DEFINITION = "if customProvision exists then conditionsPrecedentElection = ExceptionEnum -> Other";
	
	class Default implements ConditionsPrecedentCustomProvision {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConditionsPrecedent conditionsPrecedent) {
			ComparisonResult result = executeDataRule(conditionsPrecedent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConditionsPrecedent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConditionsPrecedent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConditionsPrecedent conditionsPrecedent) {
			try {
				if (exists(MapperS.of(conditionsPrecedent).<String>map("getCustomProvision", _conditionsPrecedent -> _conditionsPrecedent.getCustomProvision())).getOrDefault(false)) {
					return areEqual(MapperS.of(conditionsPrecedent).<ExceptionEnum>map("getConditionsPrecedentElection", _conditionsPrecedent -> _conditionsPrecedent.getConditionsPrecedentElection()), MapperS.of(ExceptionEnum.OTHER), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConditionsPrecedentCustomProvision {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConditionsPrecedent conditionsPrecedent) {
			return Collections.emptyList();
		}
	}
}
