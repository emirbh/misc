package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.TerminationCurrencyElection;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TerminationCurrencyElectionCurrencyElection")
@ImplementedBy(TerminationCurrencyElectionCurrencyElection.Default.class)
public interface TerminationCurrencyElectionCurrencyElection extends Validator<TerminationCurrencyElection> {
	
	String NAME = "TerminationCurrencyElectionCurrencyElection";
	String DEFINITION = "if isSpecified = False then currency is absent";
	
	class Default implements TerminationCurrencyElectionCurrencyElection {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyElection terminationCurrencyElection) {
			ComparisonResult result = executeDataRule(terminationCurrencyElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TerminationCurrencyElection terminationCurrencyElection) {
			try {
				if (areEqual(MapperS.of(terminationCurrencyElection).<Boolean>map("getIsSpecified", _terminationCurrencyElection -> _terminationCurrencyElection.getIsSpecified()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(terminationCurrencyElection).<FieldWithMetaString>map("getCurrency", _terminationCurrencyElection -> _terminationCurrencyElection.getCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TerminationCurrencyElectionCurrencyElection {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyElection terminationCurrencyElection) {
			return Collections.emptyList();
		}
	}
}
