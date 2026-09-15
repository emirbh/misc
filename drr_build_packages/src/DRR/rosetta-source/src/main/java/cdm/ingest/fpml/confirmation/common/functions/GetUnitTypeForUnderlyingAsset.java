package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.Index;
import fpml.consolidated.shared.InstrumentId;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnitTypeForUnderlyingAsset.GetUnitTypeForUnderlyingAssetDefault.class)
public abstract class GetUnitTypeForUnderlyingAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlUnderlyingAsset 
	* @return unitType 
	*/
	public UnitType evaluate(Asset fpmlUnderlyingAsset) {
		UnitType.UnitTypeBuilder unitTypeBuilder = doEvaluate(fpmlUnderlyingAsset);
		
		final UnitType unitType;
		if (unitTypeBuilder == null) {
			unitType = null;
		} else {
			unitType = unitTypeBuilder.build();
			objectValidator.validate(UnitType.class, unitType);
		}
		
		return unitType;
	}

	protected abstract UnitType.UnitTypeBuilder doEvaluate(Asset fpmlUnderlyingAsset);

	protected abstract MapperS<FinancialUnitEnum> financialUnit(Asset fpmlUnderlyingAsset);

	public static class GetUnitTypeForUnderlyingAssetDefault extends GetUnitTypeForUnderlyingAsset {
		@Override
		protected UnitType.UnitTypeBuilder doEvaluate(Asset fpmlUnderlyingAsset) {
			UnitType.UnitTypeBuilder unitType = UnitType.builder();
			return assignOutput(unitType, fpmlUnderlyingAsset);
		}
		
		protected UnitType.UnitTypeBuilder assignOutput(UnitType.UnitTypeBuilder unitType, Asset fpmlUnderlyingAsset) {
			unitType = toBuilder(UnitType.builder()
				.setFinancialUnit(financialUnit(fpmlUnderlyingAsset).get())
				.build());
			
			return Optional.ofNullable(unitType)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<FinancialUnitEnum> financialUnit(Asset fpmlUnderlyingAsset) {
			if (fpmlUnderlyingAsset == null) {
				return MapperS.<FinancialUnitEnum>ofNull();
			}
			if (fpmlUnderlyingAsset instanceof Index) {
				final Index index = (Index) fpmlUnderlyingAsset;
				if (exists(MapperS.of(index).<InstrumentId>mapC("getInstrumentId", _index -> _index.getInstrumentId())).getOrDefault(false)) {
					return MapperS.of(FinancialUnitEnum.INDEX_UNIT);
				}
				return MapperS.<FinancialUnitEnum>ofNull();
			}
			return MapperS.of(FinancialUnitEnum.SHARE);
		}
	}
}
