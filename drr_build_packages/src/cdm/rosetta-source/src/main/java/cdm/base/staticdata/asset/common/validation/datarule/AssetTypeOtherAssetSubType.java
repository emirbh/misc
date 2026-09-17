package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.AssetTypeEnum;
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
@RosettaDataRule("AssetTypeOtherAssetSubType")
@ImplementedBy(AssetTypeOtherAssetSubType.Default.class)
public interface AssetTypeOtherAssetSubType extends Validator<AssetType> {
	
	String NAME = "AssetTypeOtherAssetSubType";
	String DEFINITION = "if assetType = AssetTypeEnum -> Other then otherAssetType exists";
	
	class Default implements AssetTypeOtherAssetSubType {
	
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
				if (areEqual(MapperS.of(assetType).<AssetTypeEnum>map("getAssetType", _assetType -> _assetType.getAssetType()), MapperS.of(AssetTypeEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(assetType).<String>mapC("getOtherAssetType", _assetType -> _assetType.getOtherAssetType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetTypeOtherAssetSubType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetType assetType) {
			return Collections.emptyList();
		}
	}
}
