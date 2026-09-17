package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CustodianRiskElection;
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
@RosettaDataRule("CustodianRiskElectionSpecified")
@ImplementedBy(CustodianRiskElectionSpecified.Default.class)
public interface CustodianRiskElectionSpecified extends Validator<CustodianRiskElection> {
	
	String NAME = "CustodianRiskElectionSpecified";
	String DEFINITION = "if isSpecified = False then qualification is absent";
	
	class Default implements CustodianRiskElectionSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianRiskElection custodianRiskElection) {
			ComparisonResult result = executeDataRule(custodianRiskElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CustodianRiskElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CustodianRiskElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CustodianRiskElection custodianRiskElection) {
			try {
				if (areEqual(MapperS.of(custodianRiskElection).<Boolean>map("getIsSpecified", _custodianRiskElection -> _custodianRiskElection.getIsSpecified()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(custodianRiskElection).<String>map("getQualification", _custodianRiskElection -> _custodianRiskElection.getQualification()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CustodianRiskElectionSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianRiskElection custodianRiskElection) {
			return Collections.emptyList();
		}
	}
}
