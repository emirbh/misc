package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapInformationSource;
import cdm.observable.asset.CashCollateralValuationMethod;
import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.ValuationSource;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationMethod.MapValuationMethodDefault.class)
public abstract class MapValuationMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInformationSource mapInformationSource;
	@Inject protected MapReferenceBanks mapReferenceBanks;

	/**
	* @param fpmlSettlementRateSource 
	* @param fpmlCashSettlementReferenceBanks 
	* @param fpmlQuotationRateType 
	* @param cdmCashCollateralValuationMethod 
	* @return valuationMethod 
	*/
	public ValuationMethod evaluate(SettlementRateSource fpmlSettlementRateSource, CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks, QuotationRateTypeEnum fpmlQuotationRateType, CashCollateralValuationMethod cdmCashCollateralValuationMethod) {
		ValuationMethod.ValuationMethodBuilder valuationMethodBuilder = doEvaluate(fpmlSettlementRateSource, fpmlCashSettlementReferenceBanks, fpmlQuotationRateType, cdmCashCollateralValuationMethod);
		
		final ValuationMethod valuationMethod;
		if (valuationMethodBuilder == null) {
			valuationMethod = null;
		} else {
			valuationMethod = valuationMethodBuilder.build();
			objectValidator.validate(ValuationMethod.class, valuationMethod);
		}
		
		return valuationMethod;
	}

	protected abstract ValuationMethod.ValuationMethodBuilder doEvaluate(SettlementRateSource fpmlSettlementRateSource, CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks, QuotationRateTypeEnum fpmlQuotationRateType, CashCollateralValuationMethod cdmCashCollateralValuationMethod);

	public static class MapValuationMethodDefault extends MapValuationMethod {
		@Override
		protected ValuationMethod.ValuationMethodBuilder doEvaluate(SettlementRateSource fpmlSettlementRateSource, CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks, QuotationRateTypeEnum fpmlQuotationRateType, CashCollateralValuationMethod cdmCashCollateralValuationMethod) {
			ValuationMethod.ValuationMethodBuilder valuationMethod = ValuationMethod.builder();
			return assignOutput(valuationMethod, fpmlSettlementRateSource, fpmlCashSettlementReferenceBanks, fpmlQuotationRateType, cdmCashCollateralValuationMethod);
		}
		
		protected ValuationMethod.ValuationMethodBuilder assignOutput(ValuationMethod.ValuationMethodBuilder valuationMethod, SettlementRateSource fpmlSettlementRateSource, CashSettlementReferenceBanks fpmlCashSettlementReferenceBanks, QuotationRateTypeEnum fpmlQuotationRateType, CashCollateralValuationMethod cdmCashCollateralValuationMethod) {
			valuationMethod = toBuilder(ValuationMethod.builder()
				.setValuationSource(ValuationSource.builder()
					.setQuotedCurrencyPairValue(null)
					.setInformationSource(FxSpotRateSource.builder()
						.setPrimarySource(mapInformationSource.evaluate(MapperS.of(fpmlSettlementRateSource).<InformationSource>map("getInformationSource", settlementRateSource -> settlementRateSource.getInformationSource()).get()))
						.build())
					.setReferenceBanks(mapReferenceBanks.evaluate(fpmlCashSettlementReferenceBanks))
					.build())
				.setQuotationMethod(MapperS.of(fpmlQuotationRateType).checkedMap("to-enum", e -> cdm.observable.asset.QuotationRateTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setCashCollateralValuationMethod(cdmCashCollateralValuationMethod)
				.build());
			
			return Optional.ofNullable(valuationMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
