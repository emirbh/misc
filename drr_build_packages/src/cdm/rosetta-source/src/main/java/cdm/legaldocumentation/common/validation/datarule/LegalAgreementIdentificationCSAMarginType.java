package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.product.collateral.CollateralMarginTypeEnum;
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
@RosettaDataRule("LegalAgreementIdentificationCSAMarginType")
@ImplementedBy(LegalAgreementIdentificationCSAMarginType.Default.class)
public interface LegalAgreementIdentificationCSAMarginType extends Validator<LegalAgreementIdentification> {
	
	String NAME = "LegalAgreementIdentificationCSAMarginType";
	String DEFINITION = "if agreementName -> creditSupportAgreementMarginType exists then agreementName -> creditSupportAgreementType exists and vintage >= 2016";
	
	class Default implements LegalAgreementIdentificationCSAMarginType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreementIdentification legalAgreementIdentification) {
			ComparisonResult result = executeDataRule(legalAgreementIdentification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalAgreementIdentification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalAgreementIdentification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegalAgreementIdentification legalAgreementIdentification) {
			try {
				if (exists(MapperS.of(legalAgreementIdentification).<AgreementName>map("getAgreementName", _legalAgreementIdentification -> _legalAgreementIdentification.getAgreementName()).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", agreementName -> agreementName.getCreditSupportAgreementMarginType())).getOrDefault(false)) {
					return exists(MapperS.of(legalAgreementIdentification).<AgreementName>map("getAgreementName", _legalAgreementIdentification -> _legalAgreementIdentification.getAgreementName()).<FieldWithMetaCreditSupportAgreementTypeEnum>map("getCreditSupportAgreementType", agreementName -> agreementName.getCreditSupportAgreementType())).andNullSafe(greaterThanEquals(MapperS.of(legalAgreementIdentification).<Integer>map("getVintage", _legalAgreementIdentification -> _legalAgreementIdentification.getVintage()), MapperS.of(2016), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegalAgreementIdentificationCSAMarginType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreementIdentification legalAgreementIdentification) {
			return Collections.emptyList();
		}
	}
}
