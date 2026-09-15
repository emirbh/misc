package drr.regulation.common.trade.contract.reports;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCallOption;
import drr.base.qualification.product.functions.IsCap;
import drr.base.qualification.product.functions.IsFloor;
import drr.base.qualification.product.functions.IsOption;
import drr.base.qualification.product.functions.IsPutOption;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.OptionTypeCode;
import javax.inject.Inject;


@ImplementedBy(OptionTypeRule.OptionTypeRuleDefault.class)
public abstract class OptionTypeRule implements ReportFunction<TransactionReportInstruction, OptionTypeCode> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCallOption isCallOption;
	@Inject protected IsCap isCap;
	@Inject protected IsFloor isFloor;
	@Inject protected IsOption isOption;
	@Inject protected IsPutOption isPutOption;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionTypeCode evaluate(TransactionReportInstruction input) {
		OptionTypeCode output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionTypeCode doEvaluate(TransactionReportInstruction input);

	public static class OptionTypeRuleDefault extends OptionTypeRule {
		@Override
		protected OptionTypeCode doEvaluate(TransactionReportInstruction input) {
			OptionTypeCode output = null;
			return assignOutput(output, input);
		}
		
		protected OptionTypeCode assignOutput(OptionTypeCode output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isPutOption.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFloor.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(OptionTypeCode.PUTO);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isCallOption.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCap.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(OptionTypeCode.CALL);
					}
					final Boolean _boolean = isOption.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(OptionTypeCode.OTHR);
					}
					return MapperS.<OptionTypeCode>ofNull();
				}).get();
			
			return output;
		}
	}
}
