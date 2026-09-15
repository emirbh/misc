package drr.standards.iosco.cde.version1.index.reports;

import cdm.observable.asset.CreditIndex;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.Tranche;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.TradeForEvent;
import drr.standards.iso.functions.FormatToBaseOneRate;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(CDSIndexDetachmentPointRule.CDSIndexDetachmentPointRuleDefault.class)
public abstract class CDSIndexDetachmentPointRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class CDSIndexDetachmentPointRuleDefault extends CDSIndexDetachmentPointRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			final MapperS<GeneralTerms> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(MapperS.of(tradeForEvent.evaluate(item.get())).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).get()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()));
			final MapperS<BigDecimal> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(item.<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Tranche>map("getTranche", creditIndex -> creditIndex.getTranche()).<BigDecimal>map("getExhaustionPoint", tranche -> tranche.getExhaustionPoint()).getOrDefault(item.<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<Tranche>map("getTranche", basketReferenceInformation -> basketReferenceInformation.getTranche()).<BigDecimal>map("getExhaustionPoint", tranche -> tranche.getExhaustionPoint()).get())));
			output = MapperS.of(formatToBaseOneRate.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
