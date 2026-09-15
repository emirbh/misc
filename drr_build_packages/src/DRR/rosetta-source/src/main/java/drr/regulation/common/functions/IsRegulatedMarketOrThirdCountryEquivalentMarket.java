package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;
import drr.standards.iso.functions.GetOrFetchMicData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsRegulatedMarketOrThirdCountryEquivalentMarket.IsRegulatedMarketOrThirdCountryEquivalentMarketDefault.class)
public abstract class IsRegulatedMarketOrThirdCountryEquivalentMarket implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchMicData getOrFetchMicData;
	@Inject protected GetVenueOfExecution getVenueOfExecution;
	@Inject protected IsESMAThirdCountryEquivalentMarket isESMAThirdCountryEquivalentMarket;
	@Inject protected IsFCAThirdCountryEquivalentMarket isFCAThirdCountryEquivalentMarket;

	/**
	* @param reportableInformation 
	* @param regime 
	* @return result 
	*/
	public Boolean evaluate(ReportableInformation reportableInformation, RegimeNameEnum regime) {
		Boolean result = doEvaluate(reportableInformation, regime);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regime);

	protected abstract MapperS<? extends MicData> getMic(ReportableInformation reportableInformation, RegimeNameEnum regime);

	public static class IsRegulatedMarketOrThirdCountryEquivalentMarketDefault extends IsRegulatedMarketOrThirdCountryEquivalentMarket {
		@Override
		protected Boolean doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regime) {
			Boolean result = null;
			return assignOutput(result, reportableInformation, regime);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableInformation reportableInformation, RegimeNameEnum regime) {
			if (areEqual(MapperS.of(regime), MapperS.of(RegimeNameEnum.EMIR), CardinalityOperator.All).getOrDefault(false)) {
				result = areEqual(getMic(reportableInformation, regime).<MicMarketCategoryEnum>map("getMarketCategoryEsma", micData -> micData.getMarketCategoryEsma()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isESMAThirdCountryEquivalentMarket.evaluate(getMic(reportableInformation, regime).<String>map("getMic", micData -> micData.getMic()).get())), MapperS.of(true), CardinalityOperator.All)).get();
			} else if (areEqual(MapperS.of(regime), MapperS.of(RegimeNameEnum.UKEMIR), CardinalityOperator.All).getOrDefault(false)) {
				result = areEqual(getMic(reportableInformation, regime).<MicMarketCategoryEnum>map("getMarketCategoryFca", micData -> micData.getMarketCategoryFca()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isFCAThirdCountryEquivalentMarket.evaluate(getMic(reportableInformation, regime).<String>map("getMic", micData -> micData.getMic()).get())), MapperS.of(true), CardinalityOperator.All)).get();
			} else {
				result = false;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends MicData> getMic(ReportableInformation reportableInformation, RegimeNameEnum regime) {
			return MapperS.of(getOrFetchMicData.evaluate(MapperS.of(reportableInformation).<EnrichmentData>map("getEnrichment", _reportableInformation -> _reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), getVenueOfExecution.evaluate(reportableInformation)));
		}
	}
}
