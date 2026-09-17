package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.InitialMarginCalculation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("InitialMarginCalculationChoice")
@ImplementedBy(InitialMarginCalculationChoice.Default.class)
public interface InitialMarginCalculationChoice extends Validator<InitialMarginCalculation> {
	
	String NAME = "InitialMarginCalculationChoice";
	String DEFINITION = "if marginRatio exists then haircut is absent and haircutThreshold is absent else if haircut exists then marginRatio is absent and marginRatioThreshold is absent else False";
	
	class Default implements InitialMarginCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMarginCalculation initialMarginCalculation) {
			ComparisonResult result = executeDataRule(initialMarginCalculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InitialMarginCalculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InitialMarginCalculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InitialMarginCalculation initialMarginCalculation) {
			try {
				if (exists(MapperS.of(initialMarginCalculation).<BigDecimal>map("getMarginRatio", _initialMarginCalculation -> _initialMarginCalculation.getMarginRatio())).getOrDefault(false)) {
					return notExists(MapperS.of(initialMarginCalculation).<BigDecimal>map("getHaircut", _initialMarginCalculation -> _initialMarginCalculation.getHaircut())).andNullSafe(notExists(MapperS.of(initialMarginCalculation).<BigDecimal>mapC("getHaircutThreshold", _initialMarginCalculation -> _initialMarginCalculation.getHaircutThreshold())));
				}
				if (exists(MapperS.of(initialMarginCalculation).<BigDecimal>map("getHaircut", _initialMarginCalculation -> _initialMarginCalculation.getHaircut())).getOrDefault(false)) {
					return notExists(MapperS.of(initialMarginCalculation).<BigDecimal>map("getMarginRatio", _initialMarginCalculation -> _initialMarginCalculation.getMarginRatio())).andNullSafe(notExists(MapperS.of(initialMarginCalculation).<BigDecimal>mapC("getMarginRatioThreshold", _initialMarginCalculation -> _initialMarginCalculation.getMarginRatioThreshold())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InitialMarginCalculationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMarginCalculation initialMarginCalculation) {
			return Collections.emptyList();
		}
	}
}
