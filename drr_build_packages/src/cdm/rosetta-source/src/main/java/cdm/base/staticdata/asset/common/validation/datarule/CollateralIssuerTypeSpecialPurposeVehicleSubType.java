package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.IssuerTypeEnum;
import cdm.base.staticdata.asset.common.SpecialPurposeVehicleIssuerType;
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
@RosettaDataRule("CollateralIssuerTypeSpecialPurposeVehicleSubType")
@ImplementedBy(CollateralIssuerTypeSpecialPurposeVehicleSubType.Default.class)
public interface CollateralIssuerTypeSpecialPurposeVehicleSubType extends Validator<CollateralIssuerType> {
	
	String NAME = "CollateralIssuerTypeSpecialPurposeVehicleSubType";
	String DEFINITION = "if issuerType <> IssuerTypeEnum -> SpecialPurposeVehicle then specialPurposeVehicleType is absent";
	
	class Default implements CollateralIssuerTypeSpecialPurposeVehicleSubType {
	
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
				if (notEqual(MapperS.of(collateralIssuerType).<IssuerTypeEnum>map("getIssuerType", _collateralIssuerType -> _collateralIssuerType.getIssuerType()), MapperS.of(IssuerTypeEnum.SPECIAL_PURPOSE_VEHICLE), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(collateralIssuerType).<SpecialPurposeVehicleIssuerType>map("getSpecialPurposeVehicleType", _collateralIssuerType -> _collateralIssuerType.getSpecialPurposeVehicleType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralIssuerTypeSpecialPurposeVehicleSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralIssuerType collateralIssuerType) {
			return Collections.emptyList();
		}
	}
}
