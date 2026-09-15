package drr.regulation.common.trade.reports;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.quantity.functions.GetProductForQuantity;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.functions.PayoutFromProductLeg1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PayoutForQuantityLeg1Rule.PayoutForQuantityLeg1RuleDefault.class)
public abstract class PayoutForQuantityLeg1Rule implements ReportFunction<TransactionReportInstruction, PayoutLegWithAuxiliary> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetProductForQuantity getProductForQuantity;
	@Inject protected PayoutFromProductLeg1 payoutFromProductLeg1;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PayoutLegWithAuxiliary evaluate(TransactionReportInstruction input) {
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder outputBuilder = doEvaluate(input);
		
		final PayoutLegWithAuxiliary output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PayoutLegWithAuxiliary.class, output);
		}
		
		return output;
	}

	protected abstract PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction input);

	public static class PayoutForQuantityLeg1RuleDefault extends PayoutForQuantityLeg1Rule {
		@Override
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder doEvaluate(TransactionReportInstruction input) {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output = PayoutLegWithAuxiliary.builder();
			return assignOutput(output, input);
		}
		
		protected PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder assignOutput(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder output, TransactionReportInstruction input) {
			output = toBuilder(payoutFromProductLeg1.evaluate(MapperS.of(getProductForQuantity.evaluate(input)).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(getProductForQuantity.evaluate(input)).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
