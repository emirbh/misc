package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.MakeWholeProvisions;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.PrePayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityExerciseValuationSettlementChoice1")
@ImplementedBy(EquityExerciseValuationSettlementChoice1.Default.class)
public interface EquityExerciseValuationSettlementChoice1 extends Validator<EquityExerciseValuationSettlement> {
	
	String NAME = "EquityExerciseValuationSettlementChoice1";
	String DEFINITION = "prePayment is absent or automaticExercise is absent and makeWholeProvisions is absent";
	
	class Default implements EquityExerciseValuationSettlementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			ComparisonResult result = executeDataRule(equityExerciseValuationSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			try {
				return notExists(MapperS.of(equityExerciseValuationSettlement).<PrePayment>map("getPrePayment", _equityExerciseValuationSettlement -> _equityExerciseValuationSettlement.getPrePayment())).orNullSafe(notExists(MapperS.of(equityExerciseValuationSettlement).<Boolean>map("getAutomaticExercise", _equityExerciseValuationSettlement -> _equityExerciseValuationSettlement.getAutomaticExercise())).andNullSafe(notExists(MapperS.of(equityExerciseValuationSettlement).<MakeWholeProvisions>map("getMakeWholeProvisions", _equityExerciseValuationSettlement -> _equityExerciseValuationSettlement.getMakeWholeProvisions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityExerciseValuationSettlementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			return Collections.emptyList();
		}
	}
}
