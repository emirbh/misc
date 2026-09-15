package fpml.consolidated.sec.lending.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SecLendFeeCalculationChoice")
@ImplementedBy(SecLendFeeCalculationChoice.Default.class)
public interface SecLendFeeCalculationChoice extends Validator<SecLendFeeCalculation> {
	
	String NAME = "SecLendFeeCalculationChoice";
	String DEFINITION = "if fixedRateSchedule exists then floatingRateCalculation is absent and resetFrequency is absent else if floatingRateCalculation exists then fixedRateSchedule is absent else False";
	
	class Default implements SecLendFeeCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendFeeCalculation secLendFeeCalculation) {
			ComparisonResult result = executeDataRule(secLendFeeCalculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecLendFeeCalculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecLendFeeCalculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecLendFeeCalculation secLendFeeCalculation) {
			try {
				if (exists(MapperS.of(secLendFeeCalculation).<Schedule>map("getFixedRateSchedule", _secLendFeeCalculation -> _secLendFeeCalculation.getFixedRateSchedule())).getOrDefault(false)) {
					return notExists(MapperS.of(secLendFeeCalculation).<FloatingRateCalculation>map("getFloatingRateCalculation", _secLendFeeCalculation -> _secLendFeeCalculation.getFloatingRateCalculation())).andNullSafe(notExists(MapperS.of(secLendFeeCalculation).<Frequency>map("getResetFrequency", _secLendFeeCalculation -> _secLendFeeCalculation.getResetFrequency())));
				}
				if (exists(MapperS.of(secLendFeeCalculation).<FloatingRateCalculation>map("getFloatingRateCalculation", _secLendFeeCalculation -> _secLendFeeCalculation.getFloatingRateCalculation())).getOrDefault(false)) {
					return notExists(MapperS.of(secLendFeeCalculation).<Schedule>map("getFixedRateSchedule", _secLendFeeCalculation -> _secLendFeeCalculation.getFixedRateSchedule()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecLendFeeCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendFeeCalculation secLendFeeCalculation) {
			return Collections.emptyList();
		}
	}
}
