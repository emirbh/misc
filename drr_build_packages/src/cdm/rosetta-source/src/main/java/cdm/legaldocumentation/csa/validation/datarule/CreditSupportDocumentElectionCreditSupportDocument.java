package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.common.CreditSupportDocumentTermsEnum;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.csa.CreditSupportDocumentElection;
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
@RosettaDataRule("CreditSupportDocumentElectionCreditSupportDocument")
@ImplementedBy(CreditSupportDocumentElectionCreditSupportDocument.Default.class)
public interface CreditSupportDocumentElectionCreditSupportDocument extends Validator<CreditSupportDocumentElection> {
	
	String NAME = "CreditSupportDocumentElectionCreditSupportDocument";
	String DEFINITION = "if creditSupportDocumentTerms = CreditSupportDocumentTermsEnum -> Specified then (creditSupportDocument exists and creditSupportDocumentTypes is absent) or (creditSupportDocument is absent and creditSupportDocumentTypes exists)";
	
	class Default implements CreditSupportDocumentElectionCreditSupportDocument {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportDocumentElection creditSupportDocumentElection) {
			ComparisonResult result = executeDataRule(creditSupportDocumentElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportDocumentElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportDocumentElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CreditSupportDocumentElection creditSupportDocumentElection) {
			try {
				if (areEqual(MapperS.of(creditSupportDocumentElection).<CreditSupportDocumentTermsEnum>map("getCreditSupportDocumentTerms", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocumentTerms()), MapperS.of(CreditSupportDocumentTermsEnum.SPECIFIED), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(creditSupportDocumentElection).<LegalAgreement>mapC("getCreditSupportDocument", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocument())).andNullSafe(notExists(MapperS.of(creditSupportDocumentElection).<LegalAgreementIdentification>mapC("getCreditSupportDocumentTypes", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocumentTypes()))).orNullSafe(notExists(MapperS.of(creditSupportDocumentElection).<LegalAgreement>mapC("getCreditSupportDocument", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocument())).andNullSafe(exists(MapperS.of(creditSupportDocumentElection).<LegalAgreementIdentification>mapC("getCreditSupportDocumentTypes", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocumentTypes()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditSupportDocumentElectionCreditSupportDocument {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportDocumentElection creditSupportDocumentElection) {
			return Collections.emptyList();
		}
	}
}
