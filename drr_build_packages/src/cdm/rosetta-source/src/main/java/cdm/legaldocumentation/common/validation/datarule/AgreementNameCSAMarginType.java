package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.AgreementName;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
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
@RosettaDataRule("AgreementNameCSAMarginType")
@ImplementedBy(AgreementNameCSAMarginType.Default.class)
public interface AgreementNameCSAMarginType extends Validator<AgreementName> {
	
	String NAME = "AgreementNameCSAMarginType";
	String DEFINITION = "if creditSupportAgreementMarginType exists then creditSupportAgreementType exists";
	
	class Default implements AgreementNameCSAMarginType {
	
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
				if (exists(MapperS.of(agreementName).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", _agreementName -> _agreementName.getCreditSupportAgreementMarginType())).getOrDefault(false)) {
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
	class NoOp implements AgreementNameCSAMarginType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgreementName agreementName) {
			return Collections.emptyList();
		}
	}
}
