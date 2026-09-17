package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Instrument;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("InstrumentChoice")
@ImplementedBy(InstrumentChoice.Default.class)
public interface InstrumentChoice extends Validator<Instrument> {
	
	String NAME = "InstrumentChoice";
	String DEFINITION = "";
	
	class Default implements InstrumentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instrument instrument) {
			ComparisonResult result = executeDataRule(instrument);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Instrument", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Instrument", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Instrument instrument) {
			try {
				return choice(MapperS.of(instrument), Arrays.asList("ListedDerivative", "Loan", "Security"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instrument instrument) {
			return Collections.emptyList();
		}
	}
}
