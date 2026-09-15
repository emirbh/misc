package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(DeltaFromValuation.DeltaFromValuationDefault.class)
public abstract class DeltaFromValuation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

	/**
	* @param valuation 
	* @return delta 
	*/
	public BigDecimal evaluate(Valuation valuation) {
		BigDecimal delta = doEvaluate(valuation);
		
		return delta;
	}

	protected abstract BigDecimal doEvaluate(Valuation valuation);

	public static class DeltaFromValuationDefault extends DeltaFromValuation {
		@Override
		protected BigDecimal doEvaluate(Valuation valuation) {
			BigDecimal delta = null;
			return assignOutput(delta, valuation);
		}
		
		protected BigDecimal assignOutput(BigDecimal delta, Valuation valuation) {
			final MapperS<BigDecimal> thenArg = MapperS.of(valuation).<BigDecimal>map("getDelta", _valuation -> _valuation.getDelta());
			delta = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg.get())).get();
			
			return delta;
		}
	}
}
