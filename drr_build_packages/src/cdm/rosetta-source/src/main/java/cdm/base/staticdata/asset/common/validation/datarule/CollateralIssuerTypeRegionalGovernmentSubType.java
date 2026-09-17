package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.IssuerTypeEnum;
import cdm.base.staticdata.asset.common.RegionalGovernmentIssuerType;
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
@RosettaDataRule("CollateralIssuerTypeRegionalGovernmentSubType")
@ImplementedBy(CollateralIssuerTypeRegionalGovernmentSubType.Default.class)
public interface CollateralIssuerTypeRegionalGovernmentSubType extends Validator<CollateralIssuerType> {
	
	String NAME = "CollateralIssuerTypeRegionalGovernmentSubType";
	String DEFINITION = "if issuerType <> IssuerTypeEnum -> RegionalGovernment then regionalGovernmentType is absent";
	
	class Default implements CollateralIssuerTypeRegionalGovernmentSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralIssuerType collateralIssuerType) {
			ComparisonResult result = executeDataRule(collateralIssuerType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralIssuerType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralIssuerType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralIssuerType collateralIssuerType) {
			try {
				if (notEqual(MapperS.of(collateralIssuerType).<IssuerTypeEnum>map("getIssuerType", _collateralIssuerType -> _collateralIssuerType.getIssuerType()), MapperS.of(IssuerTypeEnum.REGIONAL_GOVERNMENT), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(collateralIssuerType).<RegionalGovernmentIssuerType>map("getRegionalGovernmentType", _collateralIssuerType -> _collateralIssuerType.getRegionalGovernmentType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralIssuerTypeRegionalGovernmentSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralIssuerType collateralIssuerType) {
			return Collections.emptyList();
		}
	}
}
