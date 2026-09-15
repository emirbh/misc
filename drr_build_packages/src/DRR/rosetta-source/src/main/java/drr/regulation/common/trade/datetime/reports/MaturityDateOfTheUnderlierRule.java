package drr.regulation.common.trade.datetime.reports;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.datetime.reports.ExpirationDateRule;
import javax.inject.Inject;


@ImplementedBy(MaturityDateOfTheUnderlierRule.MaturityDateOfTheUnderlierRuleDefault.class)
public abstract class MaturityDateOfTheUnderlierRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class MaturityDateOfTheUnderlierRuleDefault extends MaturityDateOfTheUnderlierRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(expirationDateRule.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get()));
					}
					return MapperS.<Date>ofNull();
				}).get();
			
			return output;
		}
	}
}
