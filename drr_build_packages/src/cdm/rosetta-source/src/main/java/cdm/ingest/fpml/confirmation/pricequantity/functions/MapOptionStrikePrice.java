package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.UnitType;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapOptionStrikePrice.MapOptionStrikePriceDefault.class)
public abstract class MapOptionStrikePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlStrikePrice 
	* @param fpmlStrikePercentage 
	* @param unit 
	* @param perUnitOf 
	* @return optionStrike 
	*/
	public OptionStrike evaluate(BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, UnitType unit, UnitType perUnitOf) {
		OptionStrike.OptionStrikeBuilder optionStrikeBuilder = doEvaluate(fpmlStrikePrice, fpmlStrikePercentage, unit, perUnitOf);
		
		final OptionStrike optionStrike;
		if (optionStrikeBuilder == null) {
			optionStrike = null;
		} else {
			optionStrike = optionStrikeBuilder.build();
			objectValidator.validate(OptionStrike.class, optionStrike);
		}
		
		return optionStrike;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, UnitType unit, UnitType perUnitOf);

	public static class MapOptionStrikePriceDefault extends MapOptionStrikePrice {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, UnitType unit, UnitType perUnitOf) {
			OptionStrike.OptionStrikeBuilder optionStrike = OptionStrike.builder();
			return assignOutput(optionStrike, fpmlStrikePrice, fpmlStrikePercentage, unit, perUnitOf);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder optionStrike, BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, UnitType unit, UnitType perUnitOf) {
			if (exists(MapperS.of(fpmlStrikePrice)).orNullSafe(exists(MapperS.of(fpmlStrikePercentage))).getOrDefault(false)) {
				optionStrike = toBuilder(OptionStrike.builder()
					.setStrikePrice(Price.builder()
						.setValue(MapperS.of(fpmlStrikePrice).getOrDefault(fpmlStrikePercentage))
						.setUnit(unit)
						.setPerUnitOf(perUnitOf)
						.setPriceType(PriceTypeEnum.ASSET_PRICE)
						.build())
					.build());
			} else {
				optionStrike = null;
			}
			
			return Optional.ofNullable(optionStrike)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
