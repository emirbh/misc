package drr.regulation.common.dtcc.trade.reports;

import cdm.observable.asset.Price;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option_Cash;
import cdm.product.qualification.functions.Qualify_Commodity_Option_Physical;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.AveragingStrikeFeature;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodityFixedPriceForward;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsCommodityBullion;
import drr.regulation.common.functions.IsCommodityMetal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_TradeLegTypesRule.DTCC_TradeLegTypesRuleDefault.class)
public abstract class DTCC_TradeLegTypesRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityBullion isCommodityBullion;
	@Inject protected IsCommodityFixedPriceForward isCommodityFixedPriceForward;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsCommodityMetal isCommodityMetal;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option_Cash qualify_Commodity_Option_Cash;
	@Inject protected Qualify_Commodity_Option_Physical qualify_Commodity_Option_Physical;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_TradeLegTypesRuleDefault extends DTCC_TradeLegTypesRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean boolean0 = qualify_Commodity_Option_Cash.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of("O-:OPT:OPT");
					}
					final Boolean boolean1 = qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of("S-:FLT:FLT");
					}
					final Boolean boolean2 = qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean2 == null ? false : boolean2)) {
						return MapperS.of("S-:FXD:FLT");
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(item.get())))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get()))))).getOrDefault(false)) {
						return MapperS.of("SO:FLT:FLT");
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(item.get())))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get()))))).getOrDefault(false)) {
						return MapperS.of("SO:FXD:FLT");
					}
					final Boolean boolean3 = qualify_Commodity_Forward.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean3 == null ? false : boolean3)) {
						final Boolean boolean4 = isCommodityFloatingPriceForward.evaluate(item.get());
						if ((boolean4 == null ? false : boolean4)) {
							final Boolean boolean5 = isCommodityBullion.evaluate(item.get());
							if ((boolean5 == null ? false : boolean5)) {
								return MapperS.of("FO:AVG:BUL");
							}
							final Boolean boolean6 = isCommodityMetal.evaluate(item.get());
							if ((boolean6 == null ? false : boolean6)) {
								return MapperS.of("FO:AVG:MET");
							}
							return MapperS.<String>ofNull();
						}
						final Boolean boolean7 = isCommodityFixedPriceForward.evaluate(item.get());
						if ((boolean7 == null ? false : boolean7)) {
							final Boolean boolean8 = isCommodityBullion.evaluate(item.get());
							if ((boolean8 == null ? false : boolean8)) {
								return MapperS.of("FO:FXD:BUL");
							}
							final Boolean boolean9 = isCommodityMetal.evaluate(item.get());
							if ((boolean9 == null ? false : boolean9)) {
								return MapperS.of("FO:FXD:MET");
							}
							return MapperS.of("FO:FXD:PHY");
						}
						return MapperS.<String>ofNull();
					}
					final Boolean boolean10 = qualify_Commodity_Option_Physical.evaluate(economicTermsForProduct.evaluate(item.get()));
					if ((boolean10 == null ? false : boolean10)) {
						if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<AveragingStrikeFeature>map("getAveragingStrikeFeature", optionStrike -> optionStrike.getAveragingStrikeFeature())).getOrDefault(false)) {
							final Boolean boolean11 = isCommodityBullion.evaluate(item.get());
							if ((boolean11 == null ? false : boolean11)) {
								return MapperS.of("OF:AVG:BUL");
							}
							final Boolean boolean12 = isCommodityMetal.evaluate(item.get());
							if ((boolean12 == null ? false : boolean12)) {
								return MapperS.of("OF:AVG:MET");
							}
							return MapperS.<String>ofNull();
						}
						if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice())).getOrDefault(false)) {
							final Boolean boolean13 = isCommodityBullion.evaluate(item.get());
							if ((boolean13 == null ? false : boolean13)) {
								return MapperS.of("OF:FXD:BUL");
							}
							final Boolean boolean14 = isCommodityMetal.evaluate(item.get());
							if ((boolean14 == null ? false : boolean14)) {
								return MapperS.of("OF:FXD:MET");
							}
							return MapperS.<String>ofNull();
						}
						return MapperS.<String>ofNull();
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
