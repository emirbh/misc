package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.asset.VolatilityCapFloor;
import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.template.ReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import fpml.consolidated.volatility.swaps.VolatilityCap;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapVolatilitySwapReturnTerms.MapVolatilitySwapReturnTermsDefault.class)
public abstract class MapVolatilitySwapReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlVolatilityLeg 
	* @return returnTerms 
	*/
	public ReturnTerms evaluate(VolatilityLeg fpmlVolatilityLeg) {
		ReturnTerms.ReturnTermsBuilder returnTermsBuilder = doEvaluate(fpmlVolatilityLeg);
		
		final ReturnTerms returnTerms;
		if (returnTermsBuilder == null) {
			returnTerms = null;
		} else {
			returnTerms = returnTermsBuilder.build();
			objectValidator.validate(ReturnTerms.class, returnTerms);
		}
		
		return returnTerms;
	}

	protected abstract ReturnTerms.ReturnTermsBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg);

	public static class MapVolatilitySwapReturnTermsDefault extends MapVolatilitySwapReturnTerms {
		@Override
		protected ReturnTerms.ReturnTermsBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg) {
			ReturnTerms.ReturnTermsBuilder returnTerms = ReturnTerms.builder();
			return assignOutput(returnTerms, fpmlVolatilityLeg);
		}
		
		protected ReturnTerms.ReturnTermsBuilder assignOutput(ReturnTerms.ReturnTermsBuilder returnTerms, VolatilityLeg fpmlVolatilityLeg) {
			PriceTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility())).getOrDefault(false)) {
				ifThenElseResult = PriceTypeEnum.VOLATILITY;
			}
			returnTerms = toBuilder(ReturnTerms.builder()
				.setVolatilityReturnTerms(VolatilityReturnTerms.builder()
					.setVolatilityStrikePrice(Price.builder()
						.setValue(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<BigDecimal>map("getVolatilityStrikePrice", volatility -> volatility.getVolatilityStrikePrice()).get())
						.setPriceType(ifThenElseResult)
						.build())
					.setExpectedN(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<Integer>map("getExpectedN", volatility -> volatility.getExpectedN()).get())
					.setVolatilityCapFloor(VolatilityCapFloor.builder()
						.setApplicable(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<VolatilityCap>map("getVolatilityCap", volatility -> volatility.getVolatilityCap()).<Boolean>map("getApplicable", volatilityCap -> volatilityCap.getApplicable()).get())
						.setTotalVolatilityCap(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<VolatilityCap>map("getVolatilityCap", volatility -> volatility.getVolatilityCap()).<BigDecimal>map("getTotalVolatilityCap", volatilityCap -> volatilityCap.getTotalVolatilityCap()).get())
						.setVolatilityCapFactor(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<VolatilityCap>map("getVolatilityCap", volatility -> volatility.getVolatilityCap()).<BigDecimal>map("getVolatilityCapFactor", volatilityCap -> volatilityCap.getVolatilityCapFactor()).get())
						.build())
					.setValuationTerms(null)
					.build())
				.build());
			
			return Optional.ofNullable(returnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
