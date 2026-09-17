package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.CustodianElection;
import cdm.legaldocumentation.csa.LegacyVMCustodianEnum;
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
@RosettaDataRule("CustodianElectionNamedEntity")
@ImplementedBy(CustodianElectionNamedEntity.Default.class)
public interface CustodianElectionNamedEntity extends Validator<CustodianElection> {
	
	String NAME = "CustodianElectionNamedEntity";
	String DEFINITION = "if legacyVMCustodian = LegacyVMCustodianEnum -> NamedEntity then legacyNamedEntity exists";
	
	class Default implements CustodianElectionNamedEntity {
	
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
				if (areEqual(MapperS.of(custodianElection).<LegacyVMCustodianEnum>map("getLegacyVMCustodian", _custodianElection -> _custodianElection.getLegacyVMCustodian()), MapperS.of(LegacyVMCustodianEnum.NAMED_ENTITY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(custodianElection).<LegalEntity>map("getLegacyNamedEntity", _custodianElection -> _custodianElection.getLegacyNamedEntity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CustodianElectionNamedEntity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianElection custodianElection) {
			return Collections.emptyList();
		}
	}
}
