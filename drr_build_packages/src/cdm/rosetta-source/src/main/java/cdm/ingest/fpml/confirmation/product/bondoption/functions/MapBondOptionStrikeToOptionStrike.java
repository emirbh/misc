package cdm.ingest.fpml.confirmation.product.bondoption.functions;

import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionStrikePrice;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionStrikeReferenceSwapCurve;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBondOptionStrikeToOptionStrike.MapBondOptionStrikeToOptionStrikeDefault.class)
public abstract class MapBondOptionStrikeToOptionStrike implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapOptionStrikePrice mapOptionStrikePrice;
	@Inject protected MapOptionStrikeReferenceSwapCurve mapOptionStrikeReferenceSwapCurve;

	/**
	* @param fpmlBondOptionStrike 
	* @return optionStrikePrice 
	*/
	public OptionStrike evaluate(BondOptionStrike fpmlBondOptionStrike) {
		OptionStrike.OptionStrikeBuilder optionStrikePriceBuilder = doEvaluate(fpmlBondOptionStrike);
		
		final OptionStrike optionStrikePrice;
		if (optionStrikePriceBuilder == null) {
			optionStrikePrice = null;
		} else {
			optionStrikePrice = optionStrikePriceBuilder.build();
			objectValidator.validate(OptionStrike.class, optionStrikePrice);
		}
		
		return optionStrikePrice;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(BondOptionStrike fpmlBondOptionStrike);

	protected abstract MapperS<? extends UnitType> unit(BondOptionStrike fpmlBondOptionStrike);

	protected abstract MapperS<? extends UnitType> perUnitOf(BondOptionStrike fpmlBondOptionStrike);

	public static class MapBondOptionStrikeToOptionStrikeDefault extends MapBondOptionStrikeToOptionStrike {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(BondOptionStrike fpmlBondOptionStrike) {
			OptionStrike.OptionStrikeBuilder optionStrikePrice = OptionStrike.builder();
			return assignOutput(optionStrikePrice, fpmlBondOptionStrike);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder optionStrikePrice, BondOptionStrike fpmlBondOptionStrike) {
			if (exists(MapperS.of(fpmlBondOptionStrike).<fpml.consolidated.option.shared.OptionStrike>map("getPrice", bondOptionStrike -> bondOptionStrike.getPrice())).getOrDefault(false)) {
				optionStrikePrice = toBuilder(mapOptionStrikePrice.evaluate(MapperS.of(fpmlBondOptionStrike).<fpml.consolidated.option.shared.OptionStrike>map("getPrice", bondOptionStrike -> bondOptionStrike.getPrice()).<BigDecimal>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).get(), MapperS.of(fpmlBondOptionStrike).<fpml.consolidated.option.shared.OptionStrike>map("getPrice", bondOptionStrike -> bondOptionStrike.getPrice()).<BigDecimal>map("getStrikePercentage", optionStrike -> optionStrike.getStrikePercentage()).get(), unit(fpmlBondOptionStrike).get(), perUnitOf(fpmlBondOptionStrike).get()));
			} else {
				optionStrikePrice = toBuilder(mapOptionStrikeReferenceSwapCurve.evaluate(MapperS.of(fpmlBondOptionStrike).<ReferenceSwapCurve>map("getReferenceSwapCurve", bondOptionStrike -> bondOptionStrike.getReferenceSwapCurve()).get()));
			}
			
			return Optional.ofNullable(optionStrikePrice)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(BondOptionStrike fpmlBondOptionStrike) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlBondOptionStrike).<fpml.consolidated.option.shared.OptionStrike>map("getPrice", bondOptionStrike -> bondOptionStrike.getPrice()).<Currency>map("getCurrency", optionStrike -> optionStrike.getCurrency()).get()))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(BondOptionStrike fpmlBondOptionStrike) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlBondOptionStrike).<fpml.consolidated.option.shared.OptionStrike>map("getPrice", bondOptionStrike -> bondOptionStrike.getPrice()).<Currency>map("getCurrency", optionStrike -> optionStrike.getCurrency()).get()))
				.build());
		}
	}
}
