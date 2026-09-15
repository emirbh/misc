package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.Knock;
import fpml.consolidated.option.shared.TriggerEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("KnockChoice")
@ImplementedBy(KnockChoice.Default.class)
public interface KnockChoice extends Validator<Knock> {
	
	String NAME = "KnockChoice";
	String DEFINITION = "knockIn exists or knockOut exists";
	
	class Default implements KnockChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Knock knock) {
			ComparisonResult result = executeDataRule(knock);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Knock", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Knock", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Knock knock) {
			try {
				return exists(MapperS.of(knock).<TriggerEvent>map("getKnockIn", _knock -> _knock.getKnockIn())).orNullSafe(exists(MapperS.of(knock).<TriggerEvent>map("getKnockOut", _knock -> _knock.getKnockOut())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements KnockChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Knock knock) {
			return Collections.emptyList();
		}
	}
}
