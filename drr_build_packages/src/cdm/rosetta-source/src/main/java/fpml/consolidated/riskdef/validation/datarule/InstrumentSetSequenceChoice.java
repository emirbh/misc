package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.InstrumentSetSequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("InstrumentSetSequenceChoice")
@ImplementedBy(InstrumentSetSequenceChoice.Default.class)
public interface InstrumentSetSequenceChoice extends Validator<InstrumentSetSequence> {
	
	String NAME = "InstrumentSetSequenceChoice";
	String DEFINITION = "optional choice underlyingAsset, curveInstrument";
	
	class Default implements InstrumentSetSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentSetSequence instrumentSetSequence) {
			ComparisonResult result = executeDataRule(instrumentSetSequence);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentSetSequence", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentSetSequence", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InstrumentSetSequence instrumentSetSequence) {
			try {
				return choice(MapperS.of(instrumentSetSequence), Arrays.asList("underlyingAsset", "curveInstrument"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentSetSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentSetSequence instrumentSetSequence) {
			return Collections.emptyList();
		}
	}
}
