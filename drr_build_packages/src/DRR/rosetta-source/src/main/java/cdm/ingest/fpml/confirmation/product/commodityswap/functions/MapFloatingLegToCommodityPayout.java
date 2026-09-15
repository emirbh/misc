package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityCalculationPeriods;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityPriceDatesToPricingDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityRelativePaymentDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommoditySwapNonPeriodicPaymentDates;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommoditySpreadToPriceWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCommoditySettlementModelToSettlementTerms;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.SpreadSchedule;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.CommodityPriceReturnTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.FloatingLegCalculation;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFloatingLegToCommodityPayout.MapFloatingLegToCommodityPayoutDefault.class)
public abstract class MapFloatingLegToCommodityPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithAddress mapAssetToObservableWithAddress;
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapCommodityCalculationPeriods mapCommodityCalculationPeriods;
	@Inject protected MapCommodityNotionalQuantityToQuantityWithAddress mapCommodityNotionalQuantityToQuantityWithAddress;
	@Inject protected MapCommodityPriceDatesToPricingDates mapCommodityPriceDatesToPricingDates;
	@Inject protected MapCommodityRelativePaymentDates mapCommodityRelativePaymentDates;
	@Inject protected MapCommoditySettlementModelToSettlementTerms mapCommoditySettlementModelToSettlementTerms;
	@Inject protected MapCommoditySpreadToPriceWithAddress mapCommoditySpreadToPriceWithAddress;
	@Inject protected MapCommoditySwapNonPeriodicPaymentDates mapCommoditySwapNonPeriodicPaymentDates;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlSettlementCurrency 
	* @param fpmlFloatingLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(IdentifiedCurrency fpmlSettlementCurrency, FloatingLeg fpmlFloatingLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlSettlementCurrency, fpmlFloatingLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(IdentifiedCurrency fpmlSettlementCurrency, FloatingLeg fpmlFloatingLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFloatingLegToCommodityPayoutDefault extends MapFloatingLegToCommodityPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(IdentifiedCurrency fpmlSettlementCurrency, FloatingLeg fpmlFloatingLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlSettlementCurrency, fpmlFloatingLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, IdentifiedCurrency fpmlSettlementCurrency, FloatingLeg fpmlFloatingLeg, List<? extends Counterparty> cdmCounterpartyList) {
			final PaymentDates ifThenElseResult;
			if (exists(MapperS.of(fpmlFloatingLeg).<CommodityRelativePaymentDates>map("getRelativePaymentDates", floatingLeg -> floatingLeg.getRelativePaymentDates())).getOrDefault(false)) {
				ifThenElseResult = mapCommodityRelativePaymentDates.evaluate(MapperS.of(fpmlFloatingLeg).<CommodityRelativePaymentDates>map("getRelativePaymentDates", floatingLeg -> floatingLeg.getRelativePaymentDates()).get());
			} else if (exists(MapperS.of(fpmlFloatingLeg).<AdjustableDatesOrRelativeDateOffset>map("getPaymentDates", floatingLeg -> floatingLeg.getPaymentDates())).getOrDefault(false)) {
				ifThenElseResult = mapCommoditySwapNonPeriodicPaymentDates.evaluate(MapperS.of(fpmlFloatingLeg).<AdjustableDatesOrRelativeDateOffset>map("getPaymentDates", floatingLeg -> floatingLeg.getPaymentDates()).get());
			} else {
				ifThenElseResult = null;
			}
			final CommodityPayout.CommodityPayoutBuilder withMetaArgument = CommodityPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlFloatingLeg).<PartyReference>map("getPayerPartyReference", floatingLeg -> floatingLeg.getPayerPartyReference()).get(), MapperS.of(fpmlFloatingLeg).<PartyReference>map("getReceiverPartyReference", floatingLeg -> floatingLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
				.setPriceQuantity(ResolvablePriceQuantity.builder()
					.setQuantitySchedule(mapCommodityNotionalQuantityToQuantityWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<BigDecimal>map("getTotalNotionalQuantity", floatingLeg -> floatingLeg.getTotalNotionalQuantity()).get(), fpmlFloatingLeg))
					.build())
				.setSettlementTerms(mapCommoditySettlementModelToSettlementTerms.evaluate(fpmlSettlementCurrency))
				.setAveragingFeature(mapAveragingCalculation.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<AveragingMethodEnum>map("getAveragingMethod", floatingLegCalculation -> floatingLegCalculation.getAveragingMethod()).get()))
				.setPricingDates(mapCommodityPriceDatesToPricingDates.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<CommodityPricingDates>map("getPricingDates", floatingLegCalculation -> floatingLegCalculation.getPricingDates()).get()))
				.setCalculationPeriodDates(mapCommodityCalculationPeriods.evaluate(MapperS.of(fpmlFloatingLeg).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", floatingLeg -> floatingLeg.getCalculationPeriodsSchedule()).get()))
				.setPaymentDates(ifThenElseResult)
				.setUnderlier(Underlier.builder()
					.setObservable(mapAssetToObservableWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<Commodity>map("getCommodity", floatingLeg -> floatingLeg.getCommodity()).get()))
					.build())
				.setCommodityPriceReturnTerms(CommodityPriceReturnTerms.builder()
					.setSpread(SpreadSchedule.builder()
						.setPrice(mapCommoditySpreadToPriceWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<CommoditySpread>map("getSpread", floatingLegCalculation -> floatingLegCalculation.getSpread()).get(), fpmlFloatingLeg))
						.build())
					.setConversionFactor(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<BigDecimal>map("getConversionFactor", floatingLegCalculation -> floatingLegCalculation.getConversionFactor()).get())
					.build())
				.build() == null ? null : CommodityPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlFloatingLeg).<PartyReference>map("getPayerPartyReference", floatingLeg -> floatingLeg.getPayerPartyReference()).get(), MapperS.of(fpmlFloatingLeg).<PartyReference>map("getReceiverPartyReference", floatingLeg -> floatingLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
				.setPriceQuantity(ResolvablePriceQuantity.builder()
					.setQuantitySchedule(mapCommodityNotionalQuantityToQuantityWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<BigDecimal>map("getTotalNotionalQuantity", floatingLeg -> floatingLeg.getTotalNotionalQuantity()).get(), fpmlFloatingLeg))
					.build())
				.setSettlementTerms(mapCommoditySettlementModelToSettlementTerms.evaluate(fpmlSettlementCurrency))
				.setAveragingFeature(mapAveragingCalculation.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<AveragingMethodEnum>map("getAveragingMethod", floatingLegCalculation -> floatingLegCalculation.getAveragingMethod()).get()))
				.setPricingDates(mapCommodityPriceDatesToPricingDates.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<CommodityPricingDates>map("getPricingDates", floatingLegCalculation -> floatingLegCalculation.getPricingDates()).get()))
				.setCalculationPeriodDates(mapCommodityCalculationPeriods.evaluate(MapperS.of(fpmlFloatingLeg).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", floatingLeg -> floatingLeg.getCalculationPeriodsSchedule()).get()))
				.setPaymentDates(ifThenElseResult)
				.setUnderlier(Underlier.builder()
					.setObservable(mapAssetToObservableWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<Commodity>map("getCommodity", floatingLeg -> floatingLeg.getCommodity()).get()))
					.build())
				.setCommodityPriceReturnTerms(CommodityPriceReturnTerms.builder()
					.setSpread(SpreadSchedule.builder()
						.setPrice(mapCommoditySpreadToPriceWithAddress.evaluate(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<CommoditySpread>map("getSpread", floatingLegCalculation -> floatingLegCalculation.getSpread()).get(), fpmlFloatingLeg))
						.build())
					.setConversionFactor(MapperS.of(fpmlFloatingLeg).<FloatingLegCalculation>map("getCalculation", floatingLeg -> floatingLeg.getCalculation()).<BigDecimal>map("getConversionFactor", floatingLegCalculation -> floatingLegCalculation.getConversionFactor()).get())
					.build())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlFloatingLeg).<String>map("getId", floatingLeg -> floatingLeg.getId()).get());
			payout = toBuilder(Payout.builder()
				.setCommodityPayout(withMetaArgument)
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
