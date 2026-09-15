package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Fra;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Basket;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Loan;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsDividendSwap;
import drr.base.qualification.product.functions.IsEquityForward;
import drr.base.qualification.product.functions.IsEquitySwapProduct;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsOption;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.util.string.functions.StringContains;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetInstrumentType.GetInstrumentTypeDefault.class)
public abstract class GetInstrumentType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsCreditTotalReturnSwap isCreditTotalReturnSwap;
	@Inject protected IsDividendSwap isDividendSwap;
	@Inject protected IsEquityForward isEquityForward;
	@Inject protected IsEquitySwapProduct isEquitySwapProduct;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsOption isOption0;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_BaseProduct_Fra qualify_BaseProduct_Fra;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_CreditDefaultSwap_Basket qualify_CreditDefaultSwap_Basket;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_Loan qualify_CreditDefaultSwap_Loan;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_Basket qualify_EquityForward_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_SingleName qualify_EquityForward_PriceReturnBasicPerformance_SingleName;
	@Inject protected Qualify_EquitySwap_PriceReturnBasicPerformance_Basket qualify_EquitySwap_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquitySwap_PriceReturnBasicPerformance_Index qualify_EquitySwap_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName qualify_EquitySwap_PriceReturnBasicPerformance_SingleName;
	@Inject protected Qualify_EquitySwap_TotalReturnBasicPerformance_Basket qualify_EquitySwap_TotalReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquitySwap_TotalReturnBasicPerformance_Index qualify_EquitySwap_TotalReturnBasicPerformance_Index;
	@Inject protected Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName qualify_EquitySwap_TotalReturnBasicPerformance_SingleName;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVariance qualify_ForeignExchange_ParameterReturnVariance;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVolatility qualify_ForeignExchange_ParameterReturnVolatility;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_Forward_Debt qualify_InterestRate_Forward_Debt;
	@Inject protected StringContains stringContains;

	/**
	* @param reportableEvent 
	* @return instrumentType 
	*/
	public AnnaDsbInstrumentTypeEnum evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbInstrumentTypeEnum instrumentType = doEvaluate(reportableEvent);
		
		return instrumentType;
	}

	protected abstract AnnaDsbInstrumentTypeEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent);

	protected abstract MapperS<Boolean> isOption1(ReportableEventBase reportableEvent);

	public static class GetInstrumentTypeDefault extends GetInstrumentType {
		@Override
		protected AnnaDsbInstrumentTypeEnum doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbInstrumentTypeEnum instrumentType = null;
			return assignOutput(instrumentType, reportableEvent);
		}
		
		protected AnnaDsbInstrumentTypeEnum assignOutput(AnnaDsbInstrumentTypeEnum instrumentType, ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(isOption1(reportableEvent)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwaption.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				instrumentType = AnnaDsbInstrumentTypeEnum.OPTION;
			} else {
				final FieldWithMetaString fieldWithMetaString0 = isdaTaxonomy(reportableEvent).get();
				if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditTotalReturnSwap.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), "^Credit:TotalReturnSwap.*"))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquitySwapProduct.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isDividendSwap.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(product(reportableEvent).get()))).andNullSafe(areEqual(MapperS.of(qualify_ForeignExchange_ParameterReturnVariance.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(product(reportableEvent).get()))).andNullSafe(areEqual(MapperS.of(qualify_ForeignExchange_ParameterReturnVolatility.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_TotalReturnBasicPerformance_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_TotalReturnBasicPerformance_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_TotalReturnBasicPerformance_SingleName.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_PriceReturnBasicPerformance_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_PriceReturnBasicPerformance_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_PriceReturnBasicPerformance_SingleName.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
					instrumentType = AnnaDsbInstrumentTypeEnum.SWAP;
				} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Fra.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Forward_Debt.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDF.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of("InterestRate:Forward:Debt"), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquityForward.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_SingleName.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
					instrumentType = AnnaDsbInstrumentTypeEnum.FORWARD;
				} else {
					instrumentType = AnnaDsbInstrumentTypeEnum.OTHER;
				}
			}
			
			return instrumentType;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent) {
			final MapperC<ProductTaxonomy> thenArg0 = product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).andNullSafe(exists(item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()))).get());
			final MapperS<ProductTaxonomy> thenArg1 = thenArg0
				.first();
			return thenArg1.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName());
		}
		
		@Override
		protected MapperS<Boolean> isOption1(ReportableEventBase reportableEvent) {
			return MapperS.of(isOption0.evaluate(product(reportableEvent).get()));
		}
	}
}
