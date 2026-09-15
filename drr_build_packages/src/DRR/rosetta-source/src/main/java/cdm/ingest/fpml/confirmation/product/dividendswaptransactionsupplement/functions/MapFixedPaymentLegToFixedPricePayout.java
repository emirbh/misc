package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendPeriodPayment;
import fpml.consolidated.dividend.swaps.FixedPaymentAmount;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedPaymentLegToFixedPricePayout.MapFixedPaymentLegToFixedPricePayoutDefault.class)
public abstract class MapFixedPaymentLegToFixedPricePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedLegSettlementTerms mapFixedLegSettlementTerms;
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlFixedPaymentLeg 
	* @param fpmlDividendLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FixedPaymentLeg fpmlFixedPaymentLeg, DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFixedPaymentLeg, fpmlDividendLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg, DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFixedPaymentLegToFixedPricePayoutDefault extends MapFixedPaymentLegToFixedPricePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg, DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFixedPaymentLeg, fpmlDividendLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FixedPaymentLeg fpmlFixedPaymentLeg, DividendLeg fpmlDividendLeg, List<? extends Counterparty> cdmCounterpartyList) {
			PriceSchedule ifThenElseResult = null;
			if (exists(MapperS.of(fpmlDividendLeg).<DividendPeriodPayment>mapC("getDividendPeriod", dividendLeg -> dividendLeg.getDividendPeriod()).<BigDecimal>map("getFixedStrike", dividendPeriodPayment -> dividendPeriodPayment.getFixedStrike())).getOrDefault(false)) {
				ifThenElseResult = PriceSchedule.builder()
					.setValue(MapperS.of(fpmlDividendLeg).<DividendPeriodPayment>mapC("getDividendPeriod", dividendLeg -> dividendLeg.getDividendPeriod()).<BigDecimal>map("getFixedStrike", dividendPeriodPayment -> dividendPeriodPayment.getFixedStrike()).get())
					.setPriceType(PriceTypeEnum.DIVIDEND)
					.build();
			}
			payout = toBuilder(Payout.builder()
				.setFixedPricePayout(FixedPricePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlFixedPaymentLeg).<PartyReference>map("getPayerPartyReference", fixedPaymentLeg -> fixedPaymentLeg.getPayerPartyReference()).get(), MapperS.of(fpmlFixedPaymentLeg).<PartyReference>map("getReceiverPartyReference", fixedPaymentLeg -> fixedPaymentLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlFixedPaymentLeg).<FixedPaymentAmount>mapC("getFixedPayment", fixedPaymentLeg -> fixedPaymentLeg.getFixedPayment())
							.first().<NonNegativeMoney>map("getPaymentAmount", fixedPaymentAmount -> fixedPaymentAmount.getPaymentAmount()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), fpmlFixedPaymentLeg))
						.build())
					.setSettlementTerms(mapFixedLegSettlementTerms.evaluate(fpmlFixedPaymentLeg, null, null, null, null, null))
					.setPaymentDates(null)
					.setFixedPrice(FixedPrice.builder()
						.setPriceValue(ifThenElseResult)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
