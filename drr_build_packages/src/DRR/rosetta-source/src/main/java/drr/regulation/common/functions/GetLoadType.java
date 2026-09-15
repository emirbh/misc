package drr.regulation.common.functions;

import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.LoadTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.EnergyLoadType1Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetLoadType.GetLoadTypeDefault.class)
public abstract class GetLoadType implements RosettaFunction {

	/**
	* @param profile 
	* @return loadType 
	*/
	public EnergyLoadType1Code evaluate(AssetDeliveryProfile profile) {
		EnergyLoadType1Code loadType = doEvaluate(profile);
		
		return loadType;
	}

	protected abstract EnergyLoadType1Code doEvaluate(AssetDeliveryProfile profile);

	public static class GetLoadTypeDefault extends GetLoadType {
		@Override
		protected EnergyLoadType1Code doEvaluate(AssetDeliveryProfile profile) {
			EnergyLoadType1Code loadType = null;
			return assignOutput(loadType, profile);
		}
		
		protected EnergyLoadType1Code assignOutput(EnergyLoadType1Code loadType, AssetDeliveryProfile profile) {
			if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.BASE_LOAD), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.BSLD;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.PEAK_LOAD), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.PKLD;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.OFF_PEAK), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.OFFP;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.BLOCK_HOURS), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.HABH;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.SHAPED), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.SHPD;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.GAS_DAY), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.GASD;
			} else if (areEqual(MapperS.of(profile).<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				loadType = EnergyLoadType1Code.OTHR;
			} else {
				loadType = null;
			}
			
			return loadType;
		}
	}
}
