package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDateToDividendPaymentDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.datetime.functions.MapUnadjustedDateToDividendPaymentDate;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapBasketConstituentWithAddress;
import cdm.product.asset.DividendPayoutRatio;
import cdm.product.asset.DividendPeriod;
import cdm.product.asset.DividendReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendPeriodPayment;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwapTransactionSupplementDividendReturnTerms.MapSwapTransactionSupplementDividendReturnTermsDefault.class)
public abstract class MapSwapTransactionSupplementDividendReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableOrRelativeDateToDividendPaymentDate mapAdjustableOrRelativeDateToDividendPaymentDate;
	@Inject protected MapBasketConstituentWithAddress mapBasketConstituentWithAddress;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapUnadjustedDateToDividendPaymentDate mapUnadjustedDateToDividendPaymentDate;

	/**
	* @param fpmlDividendLeg 
	* @return dividendReturnTerms 
	*/
	public DividendReturnTerms evaluate(DividendLeg fpmlDividendLeg) {
		DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTermsBuilder = doEvaluate(fpmlDividendLeg);
		
		final DividendReturnTerms dividendReturnTerms;
		if (dividendReturnTermsBuilder == null) {
			dividendReturnTerms = null;
		} else {
			dividendReturnTerms = dividendReturnTermsBuilder.build();
			objectValidator.validate(DividendReturnTerms.class, dividendReturnTerms);
		}
		
		return dividendReturnTerms;
	}

	protected abstract DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DividendLeg fpmlDividendLeg);

	protected abstract MapperS<? extends Underlyer> fpmlUnderlyer(DividendLeg fpmlDividendLeg);

	protected abstract MapperC<? extends DividendPeriodPayment> fpmlDividendPeriodPaymentList(DividendLeg fpmlDividendLeg);

	public static class MapSwapTransactionSupplementDividendReturnTermsDefault extends MapSwapTransactionSupplementDividendReturnTerms {
		@Override
		protected DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DividendLeg fpmlDividendLeg) {
			DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms = DividendReturnTerms.builder();
			return assignOutput(dividendReturnTerms, fpmlDividendLeg);
		}
		
		protected DividendReturnTerms.DividendReturnTermsBuilder assignOutput(DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms, DividendLeg fpmlDividendLeg) {
			final List<DividendPayoutRatio> ifThenElseResult;
			if (exists(MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer()).<Basket>map("getBasket", underlyer -> underlyer.getBasket())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer()).<Basket>map("getBasket", underlyer -> underlyer.getBasket()).<BasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
					.mapItem(item -> MapperS.of(DividendPayoutRatio.builder()
						.setTotalRatio(item.<DividendPayout>map("getDividendPayout", basketConstituent -> basketConstituent.getDividendPayout()).<BigDecimal>map("getDividendPayoutRatio", dividendPayout -> dividendPayout.getDividendPayoutRatio()).get())
						.setBasketConstituent(mapBasketConstituentWithAddress.evaluate(item.get()))
						.setCashRatio(MapperS.of(fpmlDividendLeg).<BigDecimal>map("getDeclaredCashDividendPercentage", dividendLeg -> dividendLeg.getDeclaredCashDividendPercentage()).get())
						.setNonCashRatio(MapperS.of(fpmlDividendLeg).<BigDecimal>map("getDeclaredCashEquivalentDividendPercentage", dividendLeg -> dividendLeg.getDeclaredCashEquivalentDividendPercentage()).get())
						.build())).getMulti();
			} else if (exists(MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer())).getOrDefault(false)) {
				final DividendPayoutRatio dividendPayoutRatio = DividendPayoutRatio.builder()
					.setTotalRatio(MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<DividendPayout>map("getDividendPayout", singleUnderlyer -> singleUnderlyer.getDividendPayout()).<BigDecimal>map("getDividendPayoutRatio", dividendPayout -> dividendPayout.getDividendPayoutRatio()).get())
					.setCashRatio(MapperS.of(fpmlDividendLeg).<BigDecimal>map("getDeclaredCashDividendPercentage", dividendLeg -> dividendLeg.getDeclaredCashDividendPercentage()).get())
					.setNonCashRatio(MapperS.of(fpmlDividendLeg).<BigDecimal>map("getDeclaredCashEquivalentDividendPercentage", dividendLeg -> dividendLeg.getDeclaredCashEquivalentDividendPercentage()).get())
					.build();
				ifThenElseResult = dividendPayoutRatio == null ? Collections.<DividendPayoutRatio>emptyList() : Collections.singletonList(dividendPayoutRatio);
			} else {
				ifThenElseResult = Collections.<DividendPayoutRatio>emptyList();
			}
			dividendReturnTerms = toBuilder(DividendReturnTerms.builder()
				.setDividendPayoutRatio(ifThenElseResult)
				.setDividendPeriod(fpmlDividendPeriodPaymentList(fpmlDividendLeg)
					.mapItem(item -> MapperS.of(DividendPeriod.builder()
						.setStartDate(mapUnadjustedDateToDividendPaymentDate.evaluate(item.<IdentifiedDate>map("getUnadjustedStartDate", dividendPeriodPayment -> dividendPeriodPayment.getUnadjustedStartDate()).get()))
						.setEndDate(mapUnadjustedDateToDividendPaymentDate.evaluate(item.<IdentifiedDate>map("getUnadjustedEndDate", dividendPeriodPayment -> dividendPeriodPayment.getUnadjustedEndDate()).get()))
						.setDividendPaymentDate(mapAdjustableOrRelativeDateToDividendPaymentDate.evaluate(item.<AdjustableOrRelativeDate>map("getPaymentDate", dividendPeriodPayment -> dividendPeriodPayment.getPaymentDate()).get()))
						.setDateAdjustments(mapBusinessDayAdjustments.evaluate(item.<BusinessDayAdjustments>map("getDateAdjustments", dividendPeriodPayment -> dividendPeriodPayment.getDateAdjustments()).get()))
						.setDividendValuationDate(mapAdjustableOrRelativeDate.evaluate(item.<AdjustableOrRelativeDate>map("getValuationDate", dividendPeriodPayment -> dividendPeriodPayment.getValuationDate()).get()))
						.build())).getMulti())
				.build());
			
			return Optional.ofNullable(dividendReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Underlyer> fpmlUnderlyer(DividendLeg fpmlDividendLeg) {
			return MapperS.of(fpmlDividendLeg).<Underlyer>map("getUnderlyer", dividendLeg -> dividendLeg.getUnderlyer());
		}
		
		@Override
		protected MapperC<? extends DividendPeriodPayment> fpmlDividendPeriodPaymentList(DividendLeg fpmlDividendLeg) {
			return MapperS.of(fpmlDividendLeg).<DividendPeriodPayment>mapC("getDividendPeriod", dividendLeg -> dividendLeg.getDividendPeriod());
		}
	}
}
