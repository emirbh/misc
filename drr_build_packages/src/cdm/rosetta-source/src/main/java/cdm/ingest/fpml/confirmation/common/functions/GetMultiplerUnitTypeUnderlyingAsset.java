package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.Equity;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetMultiplerUnitTypeUnderlyingAsset.GetMultiplerUnitTypeUnderlyingAssetDefault.class)
public abstract class GetMultiplerUnitTypeUnderlyingAsset implements RosettaFunction {
	
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

	public static class GetMultiplerUnitTypeUnderlyingAssetDefault extends GetMultiplerUnitTypeUnderlyingAsset {
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
			if (fpmlUnderlyingAsset instanceof Equity) {
				final Equity equity = (Equity) fpmlUnderlyingAsset;
				return MapperS.of(FinancialUnitEnum.SHARE);
			}
			return MapperS.<FinancialUnitEnum>ofNull();
		}
	}
}
