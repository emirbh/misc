package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxAdditionalTerms;
import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
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
@RosettaDataRule("FxAdditionalTermsNoFaultTerminationOrDisruptionTerms")
@ImplementedBy(FxAdditionalTermsNoFaultTerminationOrDisruptionTerms.Default.class)
public interface FxAdditionalTermsNoFaultTerminationOrDisruptionTerms extends Validator<FxAdditionalTerms> {
	
	String NAME = "FxAdditionalTermsNoFaultTerminationOrDisruptionTerms";
	String DEFINITION = "(disruptionEvents exists and noFaultTermination is absent or noFaultTermination = False) or (disruptionEvents is absent and noFaultTermination = True)";
	
	class Default implements FxAdditionalTermsNoFaultTerminationOrDisruptionTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdditionalTerms fxAdditionalTerms) {
			ComparisonResult result = executeDataRule(fxAdditionalTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAdditionalTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAdditionalTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAdditionalTerms fxAdditionalTerms) {
			try {
				return exists(MapperS.of(fxAdditionalTerms).<FxDisruptionEvents>map("getDisruptionEvents", _fxAdditionalTerms -> _fxAdditionalTerms.getDisruptionEvents())).andNullSafe(notExists(MapperS.of(fxAdditionalTerms).<Boolean>map("getNoFaultTermination", _fxAdditionalTerms -> _fxAdditionalTerms.getNoFaultTermination()))).orNullSafe(areEqual(MapperS.of(fxAdditionalTerms).<Boolean>map("getNoFaultTermination", _fxAdditionalTerms -> _fxAdditionalTerms.getNoFaultTermination()), MapperS.of(false), CardinalityOperator.All)).orNullSafe(notExists(MapperS.of(fxAdditionalTerms).<FxDisruptionEvents>map("getDisruptionEvents", _fxAdditionalTerms -> _fxAdditionalTerms.getDisruptionEvents())).andNullSafe(areEqual(MapperS.of(fxAdditionalTerms).<Boolean>map("getNoFaultTermination", _fxAdditionalTerms -> _fxAdditionalTerms.getNoFaultTermination()), MapperS.of(true), CardinalityOperator.All)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAdditionalTermsNoFaultTerminationOrDisruptionTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdditionalTerms fxAdditionalTerms) {
			return Collections.emptyList();
		}
	}
}
