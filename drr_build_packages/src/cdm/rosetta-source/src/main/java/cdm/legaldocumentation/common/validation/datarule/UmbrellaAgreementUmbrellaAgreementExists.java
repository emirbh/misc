package cdm.legaldocumentation.common.validation.datarule;

import cdm.legaldocumentation.common.UmbrellaAgreement;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity;
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
@RosettaDataRule("UmbrellaAgreementUmbrellaAgreementExists")
@ImplementedBy(UmbrellaAgreementUmbrellaAgreementExists.Default.class)
public interface UmbrellaAgreementUmbrellaAgreementExists extends Validator<UmbrellaAgreement> {
	
	String NAME = "UmbrellaAgreementUmbrellaAgreementExists";
	String DEFINITION = "if isApplicable = True then language exists and parties exists";
	
	class Default implements UmbrellaAgreementUmbrellaAgreementExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UmbrellaAgreement umbrellaAgreement) {
			ComparisonResult result = executeDataRule(umbrellaAgreement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UmbrellaAgreement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "UmbrellaAgreement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(UmbrellaAgreement umbrellaAgreement) {
			try {
				if (areEqual(MapperS.of(umbrellaAgreement).<Boolean>map("getIsApplicable", _umbrellaAgreement -> _umbrellaAgreement.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(umbrellaAgreement).<String>map("getLanguage", _umbrellaAgreement -> _umbrellaAgreement.getLanguage())).andNullSafe(exists(MapperS.of(umbrellaAgreement).<UmbrellaAgreementEntity>mapC("getParties", _umbrellaAgreement -> _umbrellaAgreement.getParties())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UmbrellaAgreementUmbrellaAgreementExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UmbrellaAgreement umbrellaAgreement) {
			return Collections.emptyList();
		}
	}
}
