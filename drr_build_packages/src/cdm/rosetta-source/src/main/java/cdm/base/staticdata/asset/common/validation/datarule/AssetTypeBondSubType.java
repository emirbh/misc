package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
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
@RosettaDataRule("AssetTypeBondSubType")
@ImplementedBy(AssetTypeBondSubType.Default.class)
public interface AssetTypeBondSubType extends Validator<AssetType> {
	
	String NAME = "AssetTypeBondSubType";
	String DEFINITION = "if securityType <> InstrumentTypeEnum -> Debt then debtType is absent";
	
	class Default implements AssetTypeBondSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetType assetType) {
			ComparisonResult result = executeDataRule(assetType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetType assetType) {
			try {
				if (notEqual(MapperS.of(assetType).<InstrumentTypeEnum>map("getSecurityType", _assetType -> _assetType.getSecurityType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(assetType).<DebtType>map("getDebtType", _assetType -> _assetType.getDebtType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetTypeBondSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetType assetType) {
			return Collections.emptyList();
		}
	}
}
