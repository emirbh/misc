package drr.regulation.common.emir.reports;

import cdm.observable.asset.CreditIndex;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.Tranche;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TrancheRule.TrancheRuleDefault.class)
public abstract class TrancheRule implements ReportFunction<TransactionReportInstruction, List<Boolean>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<Boolean> evaluate(TransactionReportInstruction input) {
		List<Boolean> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<Boolean> doEvaluate(TransactionReportInstruction input);

	public static class TrancheRuleDefault extends TrancheRule {
		@Override
		protected List<Boolean> doEvaluate(TransactionReportInstruction input) {
			List<Boolean> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<Boolean> assignOutput(List<Boolean> output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(item.get()))));
			final MapperC<CreditDefaultPayout> thenArg1 = thenArg0
				.mapSingleToList(item -> {
					final Boolean boolean0 = isCreditSwaption.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout());
					}
					final Boolean boolean1 = isCredit.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						return item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout());
					}
					return MapperC.<CreditDefaultPayout>ofNull();
				});
			output = thenArg1
				.mapItem(item -> {
					if (exists(item.<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Tranche>map("getTranche", creditIndex -> creditIndex.getTranche())).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (exists(item.<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<Tranche>map("getTranche", basketReferenceInformation -> basketReferenceInformation.getTranche())).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.of(false);
				}).getMulti();
			
			return output;
		}
	}
}
