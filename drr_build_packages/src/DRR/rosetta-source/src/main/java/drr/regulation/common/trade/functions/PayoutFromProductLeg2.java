package drr.regulation.common.trade.functions;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityFixedPriceForward;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.functions.CommodityBasisLegWithNoSpread;
import drr.regulation.common.functions.CommodityLeg2;
import drr.regulation.common.functions.FXFarLeg;
import drr.regulation.common.functions.FXLeg2;
import drr.regulation.common.functions.FXSwapLeg2;
import drr.regulation.common.functions.FixedPriceLeg1;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.functions.LastAvailableSpotPrice;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutFromProductLeg2.PayoutFromProductLeg2Default.class)
public abstract class PayoutFromProductLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityBasisLegWithNoSpread commodityBasisLegWithNoSpread;
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected FXLeg2 fXLeg2;
	@Inject protected FXSwapLeg2 fXSwapLeg2;
	@Inject protected FixedPriceLeg1 fixedPriceLeg1;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsCommodityFixedPriceForward isCommodityFixedPriceForward;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;
	@Inject protected LastAvailableSpotPrice lastAvailableSpotPrice;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @param tradeLot 
	* @param reportableInformation 
	* @return payoutLeg 
	*/
	public PayoutLegWithAuxiliary evaluate(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLegBuilder = doEvaluate(product, tradeLot, reportableInformation);
		
		final PayoutLegWithAuxiliary payoutLeg;
		if (payoutLegBuilder == null) {
			payoutLeg = null;
		} else {
			payoutLeg = payoutLegBuilder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, payoutLeg);
		}
		
		return payoutLeg;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation);

	protected abstract MapperC<? extends Payout> payout(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation);

	public static class PayoutFromProductLeg2Default extends PayoutFromProductLeg2 {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg = PayoutLegWithAuxiliary.builder();
			return assignOutput(payoutLeg, product, tradeLot, reportableInformation);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg, NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
			final Boolean boolean0 = qualify_InterestRate_Option_Swaption.evaluate(economicTermsForProduct.evaluate(product));
			if ((boolean0 == null ? false : boolean0)) {
				payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
					.setInterestRatePayout(interestRateLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))
					.build());
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product)))).getOrDefault(false)) {
				payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
					.setCashflow(fXLeg2.evaluate(product, tradeLot))
					.setZeroNotionalAmountDefaulting(true)
					.build());
			} else {
				final Boolean boolean1 = isFXSwap.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
						.setCashflow(fXSwapLeg2.evaluate(product, tradeLot))
						.setSettlementTerms(MapperS.of(fXFarLeg.evaluate(product)).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get())
						.setZeroNotionalAmountDefaulting(true)
						.build());
				} else {
					final Boolean boolean2 = qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(product));
					if ((boolean2 == null ? false : boolean2)) {
						payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
							.setCommodityPayout(commodityLeg2.evaluate(product))
							.setTradeLot(tradeLot)
							.setAuxiliaryLeg(PayoutLeg.builder()
								.setFixedPricePayout(fixedPriceLeg1.evaluate(product))
								.build())
							.build());
					} else {
						final Boolean boolean3 = qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(product));
						if ((boolean3 == null ? false : boolean3)) {
							PayoutLeg ifThenElseResult0 = null;
							if (exists(MapperS.of(lastAvailableSpotPrice.evaluate(reportableInformation))).getOrDefault(false)) {
								ifThenElseResult0 = PayoutLeg.builder()
									.setCommodityPayout(commodityBasisLegWithNoSpread.evaluate(product))
									.build();
							}
							payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
								.setCommodityPayout(commodityLeg2.evaluate(product))
								.setTradeLot(tradeLot)
								.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
								.setAuxiliaryLeg(ifThenElseResult0)
								.build());
						} else {
							final Boolean boolean4 = isCommodityFixedPriceForward.evaluate(product);
							if ((boolean4 == null ? false : boolean4)) {
								payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
									.setSettlementPayout(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get())
									.setAuxiliaryLeg(PayoutLeg.builder()
										.setFixedPricePayout(payout(product, tradeLot, reportableInformation).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).get())
										.build())
									.build());
							} else {
								final Boolean boolean5 = isCommodityFloatingPriceForward.evaluate(product);
								if ((boolean5 == null ? false : boolean5)) {
									payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
										.setSettlementPayout(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get())
										.setAuxiliaryLeg(PayoutLeg.builder()
											.setCommodityPayout(payout(product, tradeLot, reportableInformation).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout()).get())
											.build())
										.setTradeLot(tradeLot)
										.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
										.build());
								} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(product))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(product))))).getOrDefault(false)) {
									PayoutLeg ifThenElseResult1 = null;
									if (areEqual(MapperS.of(distinctIgnoringPrecision(payout(product, tradeLot, reportableInformation).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).<PayerReceiver>map("getPayerReceiver", fixedPricePayout -> fixedPricePayout.getPayerReceiver())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
										ifThenElseResult1 = PayoutLeg.builder()
											.setFixedPricePayout(payout(product, tradeLot, reportableInformation).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout())
												.first().get())
											.build();
									}
									payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
										.setInterestRatePayout(interestRateLeg2.evaluate(product))
										.setAuxiliaryLeg(ifThenElseResult1)
										.setSettlementTerms(MapperS.of(payout(product, tradeLot, reportableInformation).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout()).get()).<SettlementTerms>map("getSettlementTerms", performancePayout -> performancePayout.getSettlementTerms()).get())
										.build());
								} else {
									payoutLeg = null;
								}
							}
						}
					}
				}
			}
			
			return Optional.ofNullable(payoutLeg)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Payout> payout(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
		}
	}
}
