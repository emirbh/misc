package drr.regulation.common.trade.index.reports;

import cdm.event.common.Trade;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.qualification.functions.Qualify_Credit_Option_NonStandard;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCreditDefaultSwapIndex;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsCreditTotalReturnSwap;
import drr.standards.iso.functions.FormatToBaseOne18Rate;
import drr.standards.iso.functions.FormatToBaseOneRate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IndexFactorRule.IndexFactorRuleDefault.class)
public abstract class IndexFactorRule implements ReportFunction<TransactionReportInstruction, List<BigDecimal>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FormatToBaseOne18Rate formatToBaseOne18Rate;
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;
	@Inject protected IsCreditDefaultSwapIndex isCreditDefaultSwapIndex;
	@Inject protected IsCreditTotalReturnSwap isCreditTotalReturnSwap;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_Credit_Option_NonStandard qualify_Credit_Option_NonStandard;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<BigDecimal> evaluate(TransactionReportInstruction input) {
		List<BigDecimal> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<BigDecimal> doEvaluate(TransactionReportInstruction input);

	public static class IndexFactorRuleDefault extends IndexFactorRule {
		@Override
		protected List<BigDecimal> doEvaluate(TransactionReportInstruction input) {
			List<BigDecimal> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<BigDecimal> assignOutput(List<BigDecimal> output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToList(item -> {
					final Boolean _boolean = isCreditDefaultSwapIndex.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<BigDecimal>map("getIndexFactor", creditIndex -> creditIndex.getIndexFactor());
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isCreditTotalReturnSwap.evaluate(productForTrade.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Credit_Option_NonStandard.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(item.get())))))).getOrDefault(false)) {
						return MapperC.of(Collections.singletonList(formatToBaseOne18Rate.evaluate(BigDecimal.valueOf(1))));
					}
					if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout())).getOrDefault(false)) {
						return MapperC.of(Collections.singletonList(formatToBaseOneRate.evaluate(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<BigDecimal>map("getIndexFactor", creditIndex -> creditIndex.getIndexFactor()).get())));
					}
					return MapperC.<BigDecimal>ofNull();
				}).getMulti();
			
			return output;
		}
	}
}
