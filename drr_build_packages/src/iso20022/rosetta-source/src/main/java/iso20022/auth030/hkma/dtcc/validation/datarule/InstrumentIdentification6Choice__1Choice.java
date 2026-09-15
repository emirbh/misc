package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.InstrumentIdentification6Choice__1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InstrumentIdentification6Choice__1Choice")
@ImplementedBy(InstrumentIdentification6Choice__1Choice.Default.class)
public interface InstrumentIdentification6Choice__1Choice extends Validator<InstrumentIdentification6Choice__1> {
	
	String NAME = "InstrumentIdentification6Choice__1Choice";
	String DEFINITION = "one-of";
	
	class Default implements InstrumentIdentification6Choice__1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentIdentification6Choice__1 instrumentIdentification6Choice__1) {
			ComparisonResult result = executeDataRule(instrumentIdentification6Choice__1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentIdentification6Choice__1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentIdentification6Choice__1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InstrumentIdentification6Choice__1 instrumentIdentification6Choice__1) {
			try {
				return choice(MapperS.of(instrumentIdentification6Choice__1), Arrays.asList("isin", "othrId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentIdentification6Choice__1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentIdentification6Choice__1 instrumentIdentification6Choice__1) {
			return Collections.emptyList();
		}
	}
}
