package fpml.consolidated.riskdef.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PerturbationType;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DerivativeCalculationProcedureChoice")
@ImplementedBy(DerivativeCalculationProcedureChoice.Default.class)
public interface DerivativeCalculationProcedureChoice extends Validator<DerivativeCalculationProcedure> {
	
	String NAME = "DerivativeCalculationProcedureChoice";
	String DEFINITION = "averaged is absent and replacementMarketInput is absent and perturbationAmount is absent and perturbationType is absent or derivativeFormula is absent and replacementMarketInput is absent or perturbationAmount is absent and averaged is absent and perturbationType is absent and derivativeFormula is absent";
	
	class Default implements DerivativeCalculationProcedureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeCalculationProcedure derivativeCalculationProcedure) {
			ComparisonResult result = executeDataRule(derivativeCalculationProcedure);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativeCalculationProcedure", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativeCalculationProcedure", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DerivativeCalculationProcedure derivativeCalculationProcedure) {
			try {
				return notExists(MapperS.of(derivativeCalculationProcedure).<Boolean>map("getAveraged", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getAveraged())).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<PricingStructureReference>map("getReplacementMarketInput", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getReplacementMarketInput()))).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<BigDecimal>map("getPerturbationAmount", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getPerturbationAmount()))).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<PerturbationType>map("getPerturbationType", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getPerturbationType()))).orNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<String>map("getDerivativeFormula", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getDerivativeFormula())).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<PricingStructureReference>map("getReplacementMarketInput", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getReplacementMarketInput())))).orNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<BigDecimal>map("getPerturbationAmount", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getPerturbationAmount())).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<Boolean>map("getAveraged", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getAveraged()))).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<PerturbationType>map("getPerturbationType", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getPerturbationType()))).andNullSafe(notExists(MapperS.of(derivativeCalculationProcedure).<String>map("getDerivativeFormula", _derivativeCalculationProcedure -> _derivativeCalculationProcedure.getDerivativeFormula()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DerivativeCalculationProcedureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeCalculationProcedure derivativeCalculationProcedure) {
			return Collections.emptyList();
		}
	}
}
