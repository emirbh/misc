package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.FrenchLawAddendum;
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
@RosettaDataRule("FrenchLawAddendumApplicable")
@ImplementedBy(FrenchLawAddendumApplicable.Default.class)
public interface FrenchLawAddendumApplicable extends Validator<FrenchLawAddendum> {
	
	String NAME = "FrenchLawAddendumApplicable";
	String DEFINITION = "if isApplicable = True then partyElection count = 2";
	
	class Default implements FrenchLawAddendumApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FrenchLawAddendum frenchLawAddendum) {
			ComparisonResult result = executeDataRule(frenchLawAddendum);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendum", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendum", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FrenchLawAddendum frenchLawAddendum) {
			try {
				if (areEqual(MapperS.of(frenchLawAddendum).<Boolean>map("getIsApplicable", _frenchLawAddendum -> _frenchLawAddendum.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(frenchLawAddendum).<FrenchLawAddendumElection>mapC("getPartyElection", _frenchLawAddendum -> _frenchLawAddendum.getPartyElection()).resultCount()), MapperS.of(2), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FrenchLawAddendumApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FrenchLawAddendum frenchLawAddendum) {
			return Collections.emptyList();
		}
	}
}
