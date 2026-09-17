package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapPerformanceValuationDates;
import cdm.observable.asset.ValuationDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.ReturnLegValuation;
import fpml.consolidated.eq.shared.ReturnLegValuationPrice;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnLegValuationToValuationDates.MapReturnLegValuationToValuationDatesDefault.class)
public abstract class MapReturnLegValuationToValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPerformanceValuationDates mapPerformanceValuationDates;

	/**
	* @param fpmlReturnLegValuation 
	* @return valuationDates 
	*/
	public ValuationDates evaluate(ReturnLegValuation fpmlReturnLegValuation) {
		ValuationDates.ValuationDatesBuilder valuationDatesBuilder = doEvaluate(fpmlReturnLegValuation);
		
		final ValuationDates valuationDates;
		if (valuationDatesBuilder == null) {
			valuationDates = null;
		} else {
			valuationDates = valuationDatesBuilder.build();
			objectValidator.validate(ValuationDates.class, valuationDates);
		}
		
		return valuationDates;
	}

	protected abstract ValuationDates.ValuationDatesBuilder doEvaluate(ReturnLegValuation fpmlReturnLegValuation);

	public static class MapReturnLegValuationToValuationDatesDefault extends MapReturnLegValuationToValuationDates {
		@Override
		protected ValuationDates.ValuationDatesBuilder doEvaluate(ReturnLegValuation fpmlReturnLegValuation) {
			ValuationDates.ValuationDatesBuilder valuationDates = ValuationDates.builder();
			return assignOutput(valuationDates, fpmlReturnLegValuation);
		}
		
		protected ValuationDates.ValuationDatesBuilder assignOutput(ValuationDates.ValuationDatesBuilder valuationDates, ReturnLegValuation fpmlReturnLegValuation) {
			valuationDates = toBuilder(ValuationDates.builder()
				.setInterimValuationDate(mapPerformanceValuationDates.evaluate(MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getValuationPriceInterim", returnLegValuation -> returnLegValuation.getValuationPriceInterim()).<DeterminationMethod>map("getDeterminationMethod", returnLegValuationPrice -> returnLegValuationPrice.getDeterminationMethod()).get(), MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getValuationPriceInterim", returnLegValuation -> returnLegValuation.getValuationPriceInterim()).<EquityValuation>map("getValuationRules", returnLegValuationPrice -> returnLegValuationPrice.getValuationRules()).get()))
				.setFinalValuationDate(mapPerformanceValuationDates.evaluate(MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getValuationPriceFinal", returnLegValuation -> returnLegValuation.getValuationPriceFinal()).<DeterminationMethod>map("getDeterminationMethod", returnLegValuationPrice -> returnLegValuationPrice.getDeterminationMethod()).get(), MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getValuationPriceFinal", returnLegValuation -> returnLegValuation.getValuationPriceFinal()).<EquityValuation>map("getValuationRules", returnLegValuationPrice -> returnLegValuationPrice.getValuationRules()).get()))
				.setInitialValuationDate(mapPerformanceValuationDates.evaluate(MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getInitialPrice", returnLegValuation -> returnLegValuation.getInitialPrice()).<DeterminationMethod>map("getDeterminationMethod", returnLegValuationPrice -> returnLegValuationPrice.getDeterminationMethod()).get(), MapperS.of(fpmlReturnLegValuation).<ReturnLegValuationPrice>map("getInitialPrice", returnLegValuation -> returnLegValuation.getInitialPrice()).<EquityValuation>map("getValuationRules", returnLegValuationPrice -> returnLegValuationPrice.getValuationRules()).get()))
				.build());
			
			return Optional.ofNullable(valuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
