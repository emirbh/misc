package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.common.CreditSupportProviderTermsEnum;
import cdm.legaldocumentation.csa.CreditSupportProviderElection;
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
@RosettaDataRule("CreditSupportProviderElectionCreditSupportProvider")
@ImplementedBy(CreditSupportProviderElectionCreditSupportProvider.Default.class)
public interface CreditSupportProviderElectionCreditSupportProvider extends Validator<CreditSupportProviderElection> {
	
	String NAME = "CreditSupportProviderElectionCreditSupportProvider";
	String DEFINITION = "if creditSupportProviderTerms = CreditSupportProviderTermsEnum -> Specified then creditSupportProvider exists";
	
	class Default implements CreditSupportProviderElectionCreditSupportProvider {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportProviderElection creditSupportProviderElection) {
			ComparisonResult result = executeDataRule(creditSupportProviderElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportProviderElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportProviderElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditSupportProviderElection creditSupportProviderElection) {
			try {
				if (areEqual(MapperS.of(creditSupportProviderElection).<CreditSupportProviderTermsEnum>map("getCreditSupportProviderTerms", _creditSupportProviderElection -> _creditSupportProviderElection.getCreditSupportProviderTerms()), MapperS.of(CreditSupportProviderTermsEnum.SPECIFIED), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(creditSupportProviderElection).<LegalEntity>mapC("getCreditSupportProvider", _creditSupportProviderElection -> _creditSupportProviderElection.getCreditSupportProvider()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditSupportProviderElectionCreditSupportProvider {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportProviderElection creditSupportProviderElection) {
			return Collections.emptyList();
		}
	}
}
