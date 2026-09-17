package fpml.consolidated.sec.lending.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SecLendRebateCalculationChoice")
@ImplementedBy(SecLendRebateCalculationChoice.Default.class)
public interface SecLendRebateCalculationChoice extends Validator<SecLendRebateCalculation> {
	
	String NAME = "SecLendRebateCalculationChoice";
	String DEFINITION = "if fixedRateSchedule exists then floatingRateCalculation is absent and resetFrequency is absent else if floatingRateCalculation exists then fixedRateSchedule is absent else False";
	
	class Default implements SecLendRebateCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendRebateCalculation secLendRebateCalculation) {
			ComparisonResult result = executeDataRule(secLendRebateCalculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecLendRebateCalculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecLendRebateCalculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecLendRebateCalculation secLendRebateCalculation) {
			try {
				if (exists(MapperS.of(secLendRebateCalculation).<Schedule>map("getFixedRateSchedule", _secLendRebateCalculation -> _secLendRebateCalculation.getFixedRateSchedule())).getOrDefault(false)) {
					return notExists(MapperS.of(secLendRebateCalculation).<FloatingRateCalculation>map("getFloatingRateCalculation", _secLendRebateCalculation -> _secLendRebateCalculation.getFloatingRateCalculation())).andNullSafe(notExists(MapperS.of(secLendRebateCalculation).<Frequency>map("getResetFrequency", _secLendRebateCalculation -> _secLendRebateCalculation.getResetFrequency())));
				}
				if (exists(MapperS.of(secLendRebateCalculation).<FloatingRateCalculation>map("getFloatingRateCalculation", _secLendRebateCalculation -> _secLendRebateCalculation.getFloatingRateCalculation())).getOrDefault(false)) {
					return notExists(MapperS.of(secLendRebateCalculation).<Schedule>map("getFixedRateSchedule", _secLendRebateCalculation -> _secLendRebateCalculation.getFixedRateSchedule()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecLendRebateCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendRebateCalculation secLendRebateCalculation) {
			return Collections.emptyList();
		}
	}
}
