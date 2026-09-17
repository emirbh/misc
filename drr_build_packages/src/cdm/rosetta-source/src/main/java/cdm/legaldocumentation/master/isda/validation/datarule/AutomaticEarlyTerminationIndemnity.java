package cdm.legaldocumentation.master.isda.validation.datarule;

import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
import cdm.legaldocumentation.master.isda.AutomaticEarlyTerminationElection;
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
@RosettaDataRule("AutomaticEarlyTerminationIndemnity")
@ImplementedBy(AutomaticEarlyTerminationIndemnity.Default.class)
public interface AutomaticEarlyTerminationIndemnity extends Validator<AutomaticEarlyTermination> {
	
	String NAME = "AutomaticEarlyTerminationIndemnity";
	String DEFINITION = "if fallbackAET = False and partyElection -> isApplicable all = False then indemnity = False";
	
	class Default implements AutomaticEarlyTerminationIndemnity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AutomaticEarlyTermination automaticEarlyTermination) {
			ComparisonResult result = executeDataRule(automaticEarlyTermination);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AutomaticEarlyTermination", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AutomaticEarlyTermination", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AutomaticEarlyTermination automaticEarlyTermination) {
			try {
				if (areEqual(MapperS.of(automaticEarlyTermination).<Boolean>map("getFallbackAET", _automaticEarlyTermination -> _automaticEarlyTermination.getFallbackAET()), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(automaticEarlyTermination).<AutomaticEarlyTerminationElection>mapC("getPartyElection", _automaticEarlyTermination -> _automaticEarlyTermination.getPartyElection()).<Boolean>map("getIsApplicable", automaticEarlyTerminationElection -> automaticEarlyTerminationElection.getIsApplicable()), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
					return areEqual(MapperS.of(automaticEarlyTermination).<Boolean>map("getIndemnity", _automaticEarlyTermination -> _automaticEarlyTermination.getIndemnity()), MapperS.of(false), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AutomaticEarlyTerminationIndemnity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AutomaticEarlyTermination automaticEarlyTermination) {
			return Collections.emptyList();
		}
	}
}
