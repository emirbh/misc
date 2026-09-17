package fpml.consolidated.fx.targets.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxTargetPhysicalSettlementChoice")
@ImplementedBy(FxTargetPhysicalSettlementChoice.Default.class)
public interface FxTargetPhysicalSettlementChoice extends Validator<FxTargetPhysicalSettlement> {
	
	String NAME = "FxTargetPhysicalSettlementChoice";
	String DEFINITION = "optional choice strike, strikeReference";
	
	class Default implements FxTargetPhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPhysicalSettlement fxTargetPhysicalSettlement) {
			ComparisonResult result = executeDataRule(fxTargetPhysicalSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetPhysicalSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetPhysicalSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxTargetPhysicalSettlement fxTargetPhysicalSettlement) {
			try {
				return choice(MapperS.of(fxTargetPhysicalSettlement), Arrays.asList("strike", "strikeReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetPhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPhysicalSettlement fxTargetPhysicalSettlement) {
			return Collections.emptyList();
		}
	}
}
