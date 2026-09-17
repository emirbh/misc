package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.LegalAgreement;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("LegalAgreementConsistentlyExecutedAgreements")
@ImplementedBy(LegalAgreementConsistentlyExecutedAgreements.Default.class)
public interface LegalAgreementConsistentlyExecutedAgreements extends Validator<LegalAgreement> {
	
	String NAME = "LegalAgreementConsistentlyExecutedAgreements";
	String DEFINITION = "if relatedAgreements exists and agreementDate exists then relatedAgreements -> agreementDate exists";
	
	class Default implements LegalAgreementConsistentlyExecutedAgreements {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreement legalAgreement) {
			ComparisonResult result = executeDataRule(legalAgreement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalAgreement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalAgreement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegalAgreement legalAgreement) {
			try {
				if (exists(MapperS.of(legalAgreement).<LegalAgreement>mapC("getRelatedAgreements", _legalAgreement -> _legalAgreement.getRelatedAgreements())).andNullSafe(exists(MapperS.of(legalAgreement).<Date>map("getAgreementDate", _legalAgreement -> _legalAgreement.getAgreementDate()))).getOrDefault(false)) {
					return exists(MapperS.of(legalAgreement).<LegalAgreement>mapC("getRelatedAgreements", _legalAgreement -> _legalAgreement.getRelatedAgreements()).<Date>map("getAgreementDate", _legalAgreement -> _legalAgreement.getAgreementDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegalAgreementConsistentlyExecutedAgreements {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreement legalAgreement) {
			return Collections.emptyList();
		}
	}
}
