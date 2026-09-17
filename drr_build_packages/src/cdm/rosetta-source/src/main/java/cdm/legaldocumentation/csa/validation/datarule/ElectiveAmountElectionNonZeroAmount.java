package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.ElectiveAmountEnum;
import cdm.observable.asset.Money;
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
@RosettaDataRule("ElectiveAmountElectionNonZeroAmount")
@ImplementedBy(ElectiveAmountElectionNonZeroAmount.Default.class)
public interface ElectiveAmountElectionNonZeroAmount extends Validator<ElectiveAmountElection> {
	
	String NAME = "ElectiveAmountElectionNonZeroAmount";
	String DEFINITION = "if electiveAmount is absent then amount exists or customElection exists";
	
	class Default implements ElectiveAmountElectionNonZeroAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectiveAmountElection electiveAmountElection) {
			ComparisonResult result = executeDataRule(electiveAmountElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectiveAmountElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectiveAmountElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ElectiveAmountElection electiveAmountElection) {
			try {
				if (notExists(MapperS.of(electiveAmountElection).<ElectiveAmountEnum>map("getElectiveAmount", _electiveAmountElection -> _electiveAmountElection.getElectiveAmount())).getOrDefault(false)) {
					return exists(MapperS.of(electiveAmountElection).<Money>map("getAmount", _electiveAmountElection -> _electiveAmountElection.getAmount())).orNullSafe(exists(MapperS.of(electiveAmountElection).<String>map("getCustomElection", _electiveAmountElection -> _electiveAmountElection.getCustomElection())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ElectiveAmountElectionNonZeroAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectiveAmountElection electiveAmountElection) {
			return Collections.emptyList();
		}
	}
}
