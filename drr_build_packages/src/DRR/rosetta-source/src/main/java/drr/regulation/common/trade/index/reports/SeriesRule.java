package drr.regulation.common.trade.index.reports;

import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.functions.FormatToMax5Number;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SeriesRule.SeriesRuleDefault.class)
public abstract class SeriesRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FormatToMax5Number formatToMax5Number;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class SeriesRuleDefault extends SeriesRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg0 = MapperS.of(productForEvent.evaluate(input));
			final MapperC<CreditDefaultPayout> thenArg1 = thenArg0
				.mapSingleToList(item -> {
					if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout())).getOrDefault(false)) {
						return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout());
					}
					if (exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout())).getOrDefault(false)) {
						return MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout());
					}
					return MapperC.<CreditDefaultPayout>ofNull();
				});
			final MapperC<Integer> thenArg2 = thenArg1
				.mapItem(item -> item.<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<Integer>map("getIndexSeries", creditIndex -> creditIndex.getIndexSeries()));
			final Integer integer = thenArg2.get();
			output = MapperS.of(formatToMax5Number.evaluate((integer == null ? null : BigDecimal.valueOf(integer)))).get();
			
			return output;
		}
	}
}
