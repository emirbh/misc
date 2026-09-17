package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType;
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
@RosettaDataRule("QuasiGovernmentIssuerTypeNonSovereignEntityRecourse")
@ImplementedBy(QuasiGovernmentIssuerTypeNonSovereignEntityRecourse.Default.class)
public interface QuasiGovernmentIssuerTypeNonSovereignEntityRecourse extends Validator<QuasiGovernmentIssuerType> {
	
	String NAME = "QuasiGovernmentIssuerTypeNonSovereignEntityRecourse";
	String DEFINITION = "if sovereignRecourse exists then sovereignEntity = False";
	
	class Default implements QuasiGovernmentIssuerTypeNonSovereignEntityRecourse {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
			ComparisonResult result = executeDataRule(quasiGovernmentIssuerType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "QuasiGovernmentIssuerType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "QuasiGovernmentIssuerType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
			try {
				if (exists(MapperS.of(quasiGovernmentIssuerType).<Boolean>map("getSovereignRecourse", _quasiGovernmentIssuerType -> _quasiGovernmentIssuerType.getSovereignRecourse())).getOrDefault(false)) {
					return areEqual(MapperS.of(quasiGovernmentIssuerType).<Boolean>map("getSovereignEntity", _quasiGovernmentIssuerType -> _quasiGovernmentIssuerType.getSovereignEntity()), MapperS.of(false), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuasiGovernmentIssuerTypeNonSovereignEntityRecourse {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
			return Collections.emptyList();
		}
	}
}
