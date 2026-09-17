package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
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
@RosettaDataRule("AgreementNameMasterConfirmation")
@ImplementedBy(AgreementNameMasterConfirmation.Default.class)
public interface AgreementNameMasterConfirmation extends Validator<AgreementName> {
	
	String NAME = "AgreementNameMasterConfirmation";
	String DEFINITION = "if masterConfirmationAnnexType exists then masterConfirmationType exists";
	
	class Default implements AgreementNameMasterConfirmation {
	
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
				if (exists(MapperS.of(agreementName).<FieldWithMetaMasterConfirmationAnnexTypeEnum>map("getMasterConfirmationAnnexType", _agreementName -> _agreementName.getMasterConfirmationAnnexType())).getOrDefault(false)) {
					return exists(MapperS.of(agreementName).<FieldWithMetaMasterConfirmationTypeEnum>map("getMasterConfirmationType", _agreementName -> _agreementName.getMasterConfirmationType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AgreementNameMasterConfirmation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgreementName agreementName) {
			return Collections.emptyList();
		}
	}
}
