package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(CDSIndexAttachmentPointRule.CDSIndexAttachmentPointRuleDefault.class)
public abstract class CDSIndexAttachmentPointRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.index.reports.CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCredit isCredit;
	@Inject protected ProductForEvent productForEvent;

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

	public static class CDSIndexAttachmentPointRuleDefault extends CDSIndexAttachmentPointRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean _boolean = isCredit.evaluate(productForEvent.evaluate(item.get()));
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(cDSIndexAttachmentPointRule.evaluate(item.get()));
					}
					return MapperS.<BigDecimal>ofNull();
				}).get();
			
			return output;
		}
	}
}
