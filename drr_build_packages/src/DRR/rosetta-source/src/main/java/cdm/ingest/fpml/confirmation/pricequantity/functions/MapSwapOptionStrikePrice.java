package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.CreditOptionStrike;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwapOptionStrikePrice.MapSwapOptionStrikePriceDefault.class)
public abstract class MapSwapOptionStrikePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param fpmlStrikePrice 
	* @param fpmlStrikePercentage 
	* @param fpmlCurrency 
	* @return optionStrike 
	*/
	public OptionStrike evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, Currency fpmlCurrency) {
		OptionStrike.OptionStrikeBuilder optionStrikeBuilder = doEvaluate(fpmlCreditDefaultSwapOption, fpmlStrikePrice, fpmlStrikePercentage, fpmlCurrency);
		
		final OptionStrike optionStrike;
		if (optionStrikeBuilder == null) {
			optionStrike = null;
		} else {
			optionStrike = optionStrikeBuilder.build();
			objectValidator.validate(OptionStrike.class, optionStrike);
		}
		
		return optionStrike;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, Currency fpmlCurrency);

	public static class MapSwapOptionStrikePriceDefault extends MapSwapOptionStrikePrice {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, Currency fpmlCurrency) {
			OptionStrike.OptionStrikeBuilder optionStrike = OptionStrike.builder();
			return assignOutput(optionStrike, fpmlCreditDefaultSwapOption, fpmlStrikePrice, fpmlStrikePercentage, fpmlCurrency);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder optionStrike, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, BigDecimal fpmlStrikePrice, BigDecimal fpmlStrikePercentage, Currency fpmlCurrency) {
			if (exists(MapperS.of(fpmlStrikePrice)).orNullSafe(exists(MapperS.of(fpmlStrikePercentage))).getOrDefault(false)) {
				ArithmeticOperationEnum ifThenElseResult = null;
				if (exists(MapperS.of(fpmlCreditDefaultSwapOption).<CreditOptionStrike>map("getStrike", creditDefaultSwapOption -> creditDefaultSwapOption.getStrike()).<BigDecimal>map("getSpread", creditOptionStrike -> creditOptionStrike.getSpread())).getOrDefault(false)) {
					ifThenElseResult = ArithmeticOperationEnum.ADD;
				}
				optionStrike = toBuilder(OptionStrike.builder()
					.setStrikePrice(Price.builder()
						.setValue(MapperS.of(fpmlStrikePrice).getOrDefault(fpmlStrikePercentage))
						.setUnit(UnitType.builder()
							.setCurrency(mapCurrency.evaluate(fpmlCurrency))
							.build())
						.setPerUnitOf(UnitType.builder()
							.setCurrency(mapCurrency.evaluate(fpmlCurrency))
							.build())
						.setPriceType(PriceTypeEnum.INTEREST_RATE)
						.setArithmeticOperator(ifThenElseResult)
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
