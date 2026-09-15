package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.math.NonNegativeQuantity;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentAmountRule.OtherPaymentAmountRuleDefault.class)
public abstract class OtherPaymentAmountRule implements ReportFunction<TransferState, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransferState input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransferState input);

	public static class OtherPaymentAmountRuleDefault extends OtherPaymentAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransferState input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransferState input) {
			final MapperS<BigDecimal> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<BigDecimal>map("getValue", nonNegativeQuantity -> nonNegativeQuantity.getValue()));
			output = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
