package cdm.product.common.settlement.validation.datarule;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.product.common.settlement.AssetFlowBase;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("AssetFlowBaseQuantityUnitExists")
@ImplementedBy(AssetFlowBaseQuantityUnitExists.Default.class)
public interface AssetFlowBaseQuantityUnitExists extends Validator<AssetFlowBase> {
	
	String NAME = "AssetFlowBaseQuantityUnitExists";
	String DEFINITION = "if asset -> Cash exists then quantity -> unit -> currency exists else if asset -> Commodity exists then quantity -> unit -> capacityUnit exists else if asset -> Instrument exists then quantity -> unit -> financialUnit exists";
	
	class Default implements AssetFlowBaseQuantityUnitExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetFlowBase assetFlowBase) {
			ComparisonResult result = executeDataRule(assetFlowBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetFlowBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetFlowBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetFlowBase assetFlowBase) {
			try {
				if (exists(MapperS.of(assetFlowBase).<Asset>map("getAsset", _assetFlowBase -> _assetFlowBase.getAsset()).<Cash>map("getCash", asset -> asset.getCash())).getOrDefault(false)) {
					return exists(MapperS.of(assetFlowBase).<NonNegativeQuantity>map("getQuantity", _assetFlowBase -> _assetFlowBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()));
				}
				if (exists(MapperS.of(assetFlowBase).<Asset>map("getAsset", _assetFlowBase -> _assetFlowBase.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).getOrDefault(false)) {
					return exists(MapperS.of(assetFlowBase).<NonNegativeQuantity>map("getQuantity", _assetFlowBase -> _assetFlowBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()));
				}
				if (exists(MapperS.of(assetFlowBase).<Asset>map("getAsset", _assetFlowBase -> _assetFlowBase.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument())).getOrDefault(false)) {
					return exists(MapperS.of(assetFlowBase).<NonNegativeQuantity>map("getQuantity", _assetFlowBase -> _assetFlowBase.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetFlowBaseQuantityUnitExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetFlowBase assetFlowBase) {
			return Collections.emptyList();
		}
	}
}
