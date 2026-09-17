package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CustodianElection;
import cdm.legaldocumentation.csa.LegacyVMCustodianEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("CustodianElectionAdditionalLanguage")
@ImplementedBy(CustodianElectionAdditionalLanguage.Default.class)
public interface CustodianElectionAdditionalLanguage extends Validator<CustodianElection> {
	
	String NAME = "CustodianElectionAdditionalLanguage";
	String DEFINITION = "if legacyVMCustodian is absent then additionalLanguage exists";
	
	class Default implements CustodianElectionAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianElection custodianElection) {
			ComparisonResult result = executeDataRule(custodianElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CustodianElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CustodianElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CustodianElection custodianElection) {
			try {
				if (notExists(MapperS.of(custodianElection).<LegacyVMCustodianEnum>map("getLegacyVMCustodian", _custodianElection -> _custodianElection.getLegacyVMCustodian())).getOrDefault(false)) {
					return exists(MapperS.of(custodianElection).<String>map("getAdditionalLanguage", _custodianElection -> _custodianElection.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CustodianElectionAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianElection custodianElection) {
			return Collections.emptyList();
		}
	}
}
