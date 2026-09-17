package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.FrenchLawAddendumElection;
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
@RosettaDataRule("FrenchLawAddendumElectionAddendumLanguage")
@ImplementedBy(FrenchLawAddendumElectionAddendumLanguage.Default.class)
public interface FrenchLawAddendumElectionAddendumLanguage extends Validator<FrenchLawAddendumElection> {
	
	String NAME = "FrenchLawAddendumElectionAddendumLanguage";
	String DEFINITION = "if isApplicable = True then addendumLanguage exists else if isApplicable = False then addendumLanguage is absent";
	
	class Default implements FrenchLawAddendumElectionAddendumLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FrenchLawAddendumElection frenchLawAddendumElection) {
			ComparisonResult result = executeDataRule(frenchLawAddendumElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendumElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendumElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FrenchLawAddendumElection frenchLawAddendumElection) {
			try {
				if (areEqual(MapperS.of(frenchLawAddendumElection).<Boolean>map("getIsApplicable", _frenchLawAddendumElection -> _frenchLawAddendumElection.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(frenchLawAddendumElection).<String>map("getAddendumLanguage", _frenchLawAddendumElection -> _frenchLawAddendumElection.getAddendumLanguage()));
				}
				if (areEqual(MapperS.of(frenchLawAddendumElection).<Boolean>map("getIsApplicable", _frenchLawAddendumElection -> _frenchLawAddendumElection.getIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(frenchLawAddendumElection).<String>map("getAddendumLanguage", _frenchLawAddendumElection -> _frenchLawAddendumElection.getAddendumLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FrenchLawAddendumElectionAddendumLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FrenchLawAddendumElection frenchLawAddendumElection) {
			return Collections.emptyList();
		}
	}
}
