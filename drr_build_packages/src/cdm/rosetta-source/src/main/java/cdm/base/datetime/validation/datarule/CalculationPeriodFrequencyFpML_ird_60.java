package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.datetime.RollConventionEnum;
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
@RosettaDataRule("CalculationPeriodFrequencyFpML_ird_60")
@ImplementedBy(CalculationPeriodFrequencyFpML_ird_60.Default.class)
public interface CalculationPeriodFrequencyFpML_ird_60 extends Validator<CalculationPeriodFrequency> {
	
	String NAME = "CalculationPeriodFrequencyFpML_ird_60";
	String DEFINITION = "if period = PeriodExtendedEnum -> T then rollConvention = RollConventionEnum -> NONE";
	
	class Default implements CalculationPeriodFrequencyFpML_ird_60 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodFrequency calculationPeriodFrequency) {
			ComparisonResult result = executeDataRule(calculationPeriodFrequency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodFrequency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodFrequency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationPeriodFrequency calculationPeriodFrequency) {
			try {
				if (areEqual(MapperS.of(calculationPeriodFrequency).<PeriodExtendedEnum>map("getPeriod", _calculationPeriodFrequency -> _calculationPeriodFrequency.getPeriod()), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.NONE), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationPeriodFrequencyFpML_ird_60 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodFrequency calculationPeriodFrequency) {
			return Collections.emptyList();
		}
	}
}
