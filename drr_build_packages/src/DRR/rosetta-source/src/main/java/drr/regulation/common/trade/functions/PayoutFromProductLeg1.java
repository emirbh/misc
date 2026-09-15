package drr.regulation.common.trade.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.qualification.functions.Qualify_Commodity_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_Credit_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_Equity_OtherOption;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityFixedPriceForward;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.qualification.product.functions.IsCommodityForward;
import drr.base.qualification.product.functions.IsCommodityOption;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.qualification.product.functions.IsEquityForward;
import drr.base.qualification.product.functions.IsEquityOption;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.qualification.product.functions.IsFixedFloatZeroCouponSwapKnownAmount;
import drr.base.qualification.product.functions.IsInterestRateDebtOption;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.functions.CommodityBasisLegWithNoSpread;
import drr.regulation.common.functions.CommodityLeg1;
import drr.regulation.common.functions.CommodityLeg2;
import drr.regulation.common.functions.FXFarLeg;
import drr.regulation.common.functions.FXLeg1;
import drr.regulation.common.functions.FXSwapLeg1;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.regulation.common.functions.InterestRateLeg1ZeroCouponSwapKnownAmount;
import drr.regulation.common.functions.InterestRateLeg2FixedFloatSingleCurrency;
import drr.regulation.common.functions.IsCreditTotalReturnSwap;
import drr.regulation.common.functions.LastAvailableSpotPrice;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutFromProductLeg1.PayoutFromProductLeg1Default.class)
public abstract class PayoutFromProductLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityBasisLegWithNoSpread commodityBasisLegWithNoSpread;
	@Inject protected CommodityLeg1 commodityLeg1;
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FXFarLeg fXFarLeg;
	@Inject protected FXLeg1 fXLeg1;
	@Inject protected FXSwapLeg1 fXSwapLeg1;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected InterestRateLeg1ZeroCouponSwapKnownAmount interestRateLeg1ZeroCouponSwapKnownAmount;
	@Inject protected InterestRateLeg2FixedFloatSingleCurrency interestRateLeg2FixedFloatSingleCurrency;
	@Inject protected IsCommodityFixedPriceForward isCommodityFixedPriceForward;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsCommodityForward isCommodityForward;
	@Inject protected IsCommodityOption isCommodityOption;
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsCreditTotalReturnSwap isCreditTotalReturnSwap;
	@Inject protected IsEquity isEquity;
	@Inject protected IsEquityForward isEquityForward;
	@Inject protected IsEquityOption isEquityOption;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;
	@Inject protected IsFixedFloatZeroCouponSwapKnownAmount isFixedFloatZeroCouponSwapKnownAmount;
	@Inject protected IsInterestRateDebtOption isInterestRateDebtOption;
	@Inject protected IsProductETD isProductETD;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;
	@Inject protected LastAvailableSpotPrice lastAvailableSpotPrice;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected Qualify_Commodity_Option_NonStandard qualify_Commodity_Option_NonStandard;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_Credit_Option_NonStandard qualify_Credit_Option_NonStandard;
	@Inject protected Qualify_Equity_OtherOption qualify_Equity_OtherOption;
	@Inject protected Qualify_InterestRate_Forward_Debt qualify_InterestRate_Forward_Debt;
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

	public static class PayoutFromProductLeg1Default extends PayoutFromProductLeg1 {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg = PayoutLegWithAuxiliary.builder();
			return assignOutput(payoutLeg, product, tradeLot, reportableInformation);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder payoutLeg, NonTransferableProduct product, TradeLot tradeLot, ReportableInformationBase reportableInformation) {
			final Boolean boolean0 = isCreditSwaption.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
					.setCreditDefaultPayout(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).get())
					.setAuxiliaryLeg(PayoutLeg.builder()
						.setInterestRatePayout(interestRateLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))
						.build())
					.setSettlementTerms(MapperS.of(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get())
					.build());
			} else {
				final Boolean boolean1 = isCredit.evaluate(product);
				if ((boolean1 == null ? false : boolean1)) {
					payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
						.setCreditDefaultPayout(payout(product, tradeLot, reportableInformation).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).get())
						.setAuxiliaryLeg(PayoutLeg.builder()
							.setInterestRatePayout(payout(product, tradeLot, reportableInformation).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get())
							.build())
						.build());
				} else if (ComparisonResult.ofNullSafe(MapperS.of(isEquityOption.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isInterestRateDebtOption.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(product))).andNullSafe(exists(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout())))).getOrDefault(false)) {
					payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
						.setOptionPayout(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get())
						.setTradeLot(tradeLot)
						.setIsProductETD(isProductETD.evaluate(product))
						.build());
				} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Equity_OtherOption.evaluate(economicTermsForProduct.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Credit_Option_NonStandard.evaluate(economicTermsForProduct.evaluate(product))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option_NonStandard.evaluate(economicTermsForProduct.evaluate(product))))).getOrDefault(false)) {
					payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
						.setOptionPayout(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get())
						.setTradeLot(tradeLot)
						.build());
				} else {
					final Boolean boolean2 = qualify_InterestRate_Option_Swaption.evaluate(economicTermsForProduct.evaluate(product));
					if ((boolean2 == null ? false : boolean2)) {
						payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
							.setInterestRatePayout(interestRateLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))
							.setSettlementTerms(MapperS.of(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get())
							.build());
					} else if (ComparisonResult.ofNullSafe(MapperS.of(isEquityForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(product))).andNullSafe(exists(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout())))).getOrDefault(false)) {
						payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
							.setSettlementPayout(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get())
							.setTradeLot(tradeLot)
							.setIsProductETD(isProductETD.evaluate(product))
							.build());
					} else if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isTotalReturnSwapDebtUnderlier.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditTotalReturnSwap.evaluate(product)))).getOrDefault(false)) {
						payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
							.setPerformancePayout(payout(product, tradeLot, reportableInformation).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout()).get())
							.setTradeLot(tradeLot)
							.build());
					} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product)))).getOrDefault(false)) {
						payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
							.setCashflow(fXLeg1.evaluate(product, tradeLot))
							.setSettlementTerms(MapperS.of(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).getOrDefault(MapperS.of(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get()))
							.setZeroNotionalAmountDefaulting(true)
							.build());
					} else {
						final Boolean boolean3 = isFXSwap.evaluate(product);
						if ((boolean3 == null ? false : boolean3)) {
							payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
								.setCashflow(fXSwapLeg1.evaluate(product, tradeLot))
								.setSettlementTerms(MapperS.of(fXFarLeg.evaluate(product)).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get())
								.setZeroNotionalAmountDefaulting(true)
								.build());
						} else {
							final Boolean boolean4 = isCommodityOption.evaluate(product);
							if ((boolean4 == null ? false : boolean4)) {
								payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
									.setOptionPayout(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get())
									.setTradeLot(tradeLot)
									.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
									.setIsProductETD(isProductETD.evaluate(product))
									.build());
							} else {
								final Boolean boolean5 = qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(product));
								if ((boolean5 == null ? false : boolean5)) {
									payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
										.setFixedPricePayout(payout(product, tradeLot, reportableInformation).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).get())
										.setTradeLot(tradeLot)
										.setAuxiliaryLeg(PayoutLeg.builder()
											.setCommodityPayout(commodityLeg2.evaluate(product))
											.build())
										.build());
								} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(product)))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))))).getOrDefault(false)) {
									payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
										.setFixedPricePayout(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).get())
										.setSettlementTerms(MapperS.of(payout(product, tradeLot, reportableInformation).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout()).get()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get())
										.setTradeLot(tradeLot)
										.build());
								} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(product)))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))))).getOrDefault(false)) {
									PayoutLeg ifThenElseResult0 = null;
									if (exists(MapperS.of(lastAvailableSpotPrice.evaluate(reportableInformation))).getOrDefault(false)) {
										ifThenElseResult0 = PayoutLeg.builder()
											.setCommodityPayout(commodityBasisLegWithNoSpread.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))
											.build();
									}
									payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
										.setCommodityPayout(commodityLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()))
										.setTradeLot(tradeLot)
										.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
										.setAuxiliaryLeg(ifThenElseResult0)
										.build());
								} else {
									final Boolean boolean6 = qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(product));
									if ((boolean6 == null ? false : boolean6)) {
										PayoutLeg ifThenElseResult1 = null;
										if (exists(MapperS.of(lastAvailableSpotPrice.evaluate(reportableInformation))).getOrDefault(false)) {
											ifThenElseResult1 = PayoutLeg.builder()
												.setCommodityPayout(commodityBasisLegWithNoSpread.evaluate(product))
												.build();
										}
										payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
											.setCommodityPayout(commodityLeg1.evaluate(product))
											.setTradeLot(tradeLot)
											.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
											.setAuxiliaryLeg(ifThenElseResult1)
											.build());
									} else {
										final Boolean boolean7 = isSingleCommodityPayoutProduct.evaluate(product);
										if ((boolean7 == null ? false : boolean7)) {
											payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
												.setCommodityPayout(payout(product, tradeLot, reportableInformation).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout()).get())
												.setTradeLot(tradeLot)
												.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
												.build());
										} else {
											final Boolean boolean8 = isCommodityFixedPriceForward.evaluate(product);
											if ((boolean8 == null ? false : boolean8)) {
												payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
													.setFixedPricePayout(payout(product, tradeLot, reportableInformation).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout()).get())
													.build());
											} else {
												final Boolean boolean9 = isCommodityFloatingPriceForward.evaluate(product);
												if ((boolean9 == null ? false : boolean9)) {
													payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
														.setCommodityPayout(payout(product, tradeLot, reportableInformation).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout()).get())
														.setTradeLot(tradeLot)
														.setLastAvailableSpotPrice(lastAvailableSpotPrice.evaluate(reportableInformation))
														.build());
												} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommodityForward.evaluate(product))).andNullSafe(exists(MapperS.of(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get()))).getOrDefault(false)) {
													payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
														.setSettlementPayout(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get())
														.build());
												} else {
													final Boolean boolean10 = isFixedFloatZeroCouponSwapKnownAmount.evaluate(product);
													if ((boolean10 == null ? false : boolean10)) {
														payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
															.setInterestRatePayout(interestRateLeg1ZeroCouponSwapKnownAmount.evaluate(product))
															.setAuxiliaryLeg(PayoutLeg.builder()
																.setInterestRatePayout(interestRateLeg2FixedFloatSingleCurrency.evaluate(product))
																.build())
															.build());
													} else {
														final Boolean boolean11 = qualify_InterestRate_Forward_Debt.evaluate(economicTermsForProduct.evaluate(product));
														if ((boolean11 == null ? false : boolean11)) {
															payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
																.setSettlementPayout(payout(product, tradeLot, reportableInformation).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()).get())
																.build());
														} else {
															final Boolean boolean12 = qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(product));
															if ((boolean12 == null ? false : boolean12)) {
																payoutLeg = toBuilder(PayoutLegWithAuxiliary.builder()
																	.setInterestRatePayout(interestRateLeg1.evaluate(product))
																	.build());
															} else {
																payoutLeg = null;
															}
														}
													}
												}
											}
										}
									}
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
