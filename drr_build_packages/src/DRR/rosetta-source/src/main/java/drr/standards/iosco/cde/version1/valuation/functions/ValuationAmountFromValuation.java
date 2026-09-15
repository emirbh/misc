package drr.standards.iosco.cde.version1.valuation.functions;

import cdm.base.math.RoundingDirectionEnum;
import cdm.base.math.functions.RoundToPrecision;
import cdm.event.common.Valuation;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ValuationAmountFromValuation.ValuationAmountFromValuationDefault.class)
public abstract class ValuationAmountFromValuation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected RoundToPrecision roundToPrecision;

	/**
	* @param valuation 
	* @return valuationAmount 
	*/
	public BigDecimal evaluate(Valuation valuation) {
		BigDecimal valuationAmount = doEvaluate(valuation);
		
		return valuationAmount;
	}

	protected abstract BigDecimal doEvaluate(Valuation valuation);

	public static class ValuationAmountFromValuationDefault extends ValuationAmountFromValuation {
		@Override
		protected BigDecimal doEvaluate(Valuation valuation) {
			BigDecimal valuationAmount = null;
			return assignOutput(valuationAmount, valuation);
		}
		
		protected BigDecimal assignOutput(BigDecimal valuationAmount, Valuation valuation) {
			final MapperS<BigDecimal> thenArg0 = MapperS.of(valuation).<Money>map("getAmount", _valuation -> _valuation.getAmount()).<BigDecimal>map("getValue", money -> money.getValue());
			final MapperS<BigDecimal> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(roundToPrecision.evaluate(item.get(), 5, RoundingDirectionEnum.NEAREST, false)));
			valuationAmount = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg1.get())).get();
			
			return valuationAmount;
		}
	}
}
