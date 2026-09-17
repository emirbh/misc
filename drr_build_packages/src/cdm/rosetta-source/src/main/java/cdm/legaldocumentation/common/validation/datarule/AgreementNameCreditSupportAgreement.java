package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreementTypeEnum;
import cdm.product.collateral.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
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
@RosettaDataRule("AgreementNameCreditSupportAgreement")
@ImplementedBy(AgreementNameCreditSupportAgreement.Default.class)
public interface AgreementNameCreditSupportAgreement extends Validator<AgreementName> {
	
	String NAME = "AgreementNameCreditSupportAgreement";
	String DEFINITION = "if agreementType = LegalAgreementTypeEnum -> CreditSupportAgreement then creditSupportAgreementType exists";
	
	class Default implements AgreementNameCreditSupportAgreement {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgreementName agreementName) {
			ComparisonResult result = executeDataRule(agreementName);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AgreementName", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AgreementName", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AgreementName agreementName) {
			try {
				if (areEqual(MapperS.of(agreementName).<LegalAgreementTypeEnum>map("getAgreementType", _agreementName -> _agreementName.getAgreementType()), MapperS.of(LegalAgreementTypeEnum.CREDIT_SUPPORT_AGREEMENT), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(agreementName).<FieldWithMetaCreditSupportAgreementTypeEnum>map("getCreditSupportAgreementType", _agreementName -> _agreementName.getCreditSupportAgreementType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AgreementNameCreditSupportAgreement {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgreementName agreementName) {
			return Collections.emptyList();
		}
	}
}
