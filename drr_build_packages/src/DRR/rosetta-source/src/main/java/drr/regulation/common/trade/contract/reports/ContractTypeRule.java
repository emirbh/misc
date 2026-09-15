package drr.regulation.common.trade.contract.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodityForward;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsEquityOther;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ContractTypeRule.ContractTypeRuleDefault.class)
public abstract class ContractTypeRule implements ReportFunction<TransactionReportInstruction, CommonContractType> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityForward isCommodityForward;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsEquityOther isEquityOther;
	@Inject protected IsFRA isFRA;
	@Inject protected IsFXSwap isFXSwap;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected IsProductETD isProductETD;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_Basket qualify_EquityForward_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_SingleName qualify_EquityForward_PriceReturnBasicPerformance_SingleName;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_Forward_Debt qualify_InterestRate_Forward_Debt;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_YearOn_Year qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CommonContractType evaluate(TransactionReportInstruction input) {
		CommonContractType output = doEvaluate(input);
		
		return output;
	}

	protected abstract CommonContractType doEvaluate(TransactionReportInstruction input);

	public static class ContractTypeRuleDefault extends ContractTypeRule {
		@Override
		protected CommonContractType doEvaluate(TransactionReportInstruction input) {
			CommonContractType output = null;
			return assignOutput(output, input);
		}
		
		protected CommonContractType assignOutput(CommonContractType output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(productForEvent.evaluate(input));
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean boolean0 = isProductETD.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						if (onlyExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("SettlementPayout")).getOrDefault(false)) {
							return MapperS.of(CommonContractType.FUTR);
						}
						if (onlyExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("OptionPayout")).getOrDefault(false)) {
							return MapperS.of(CommonContractType.OPTN);
						}
						return MapperS.of(CommonContractType.OTHR);
					}
					final Boolean boolean1 = isFRA.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(CommonContractType.FRAS);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDF.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isSingleCommodityPayoutProduct.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodityForward.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Forward_Debt.evaluate(economicTermsForProduct.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_SingleName.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_Basket.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))))).getOrDefault(false)) {
						return MapperS.of(CommonContractType.FORW);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(CommonContractType.SWPT);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTermsForProduct.evaluate(item.get())))).orNullSafe(onlyExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("OptionPayout")).andNullSafe(notExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms())).orNullSafe(areEqual(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms()), MapperS.of(false), CardinalityOperator.All)))).getOrDefault(false)) {
						return MapperS.of(CommonContractType.OPTN);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_Basis_YearOn_Year.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_Basis_ZeroCoupon.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).andNullSafe(notExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms())).orNullSafe(areEqual(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms()), MapperS.of(false), CardinalityOperator.All)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).andNullSafe(areEqual(MapperS.of(isEquityOther.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXSwap.evaluate(item.get())))).orNullSafe(onlyExists(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("PerformancePayout"))).getOrDefault(false)) {
						return MapperS.of(CommonContractType.SWAP);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(item.get()))).andNullSafe(onlyExists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("SettlementPayout"))).getOrDefault(false)) {
						return MapperS.of(CommonContractType.FUTR);
					}
					return MapperS.of(CommonContractType.OTHR);
				}).get();
			
			return output;
		}
	}
}
