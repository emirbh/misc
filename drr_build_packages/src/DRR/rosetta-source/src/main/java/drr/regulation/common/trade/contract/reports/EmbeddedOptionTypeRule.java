package drr.regulation.common.trade.contract.reports;

import cdm.event.common.Trade;
import cdm.product.template.CancelableProvision;
import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExtendibleProvision;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TerminationProvision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EmbeddedOptionTypeRule.EmbeddedOptionTypeRuleDefault.class)
public abstract class EmbeddedOptionTypeRule implements ReportFunction<TransactionReportInstruction, EmbeddedOptionTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EmbeddedOptionTypeEnum evaluate(TransactionReportInstruction input) {
		EmbeddedOptionTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EmbeddedOptionTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class EmbeddedOptionTypeRuleDefault extends EmbeddedOptionTypeRule {
		@Override
		protected EmbeddedOptionTypeEnum doEvaluate(TransactionReportInstruction input) {
			EmbeddedOptionTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EmbeddedOptionTypeEnum assignOutput(EmbeddedOptionTypeEnum output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperS<EconomicTerms> thenArg1 = thenArg0
				.mapSingleToItem(item -> item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()));
			output = thenArg1
				.mapSingleToItem(item -> {
					if (onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()), Arrays.asList("cancelableProvision", "earlyTerminationProvision", "evergreenProvision", "extendibleProvision"), Arrays.asList("extendibleProvision")).getOrDefault(false)) {
						return MapperS.of(EmbeddedOptionTypeEnum.EXTD);
					}
					if (onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()), Arrays.asList("cancelableProvision", "earlyTerminationProvision", "evergreenProvision", "extendibleProvision"), Arrays.asList("cancelableProvision")).getOrDefault(false)) {
						return MapperS.of(EmbeddedOptionTypeEnum.CANC);
					}
					if (onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()), Arrays.asList("cancelableProvision", "earlyTerminationProvision", "evergreenProvision", "extendibleProvision"), Arrays.asList("earlyTerminationProvision")).andNullSafe(onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()), Arrays.asList("mandatoryEarlyTermination", "mandatoryEarlyTerminationDateTenor", "optionalEarlyTermination", "optionalEarlyTerminationParameters"), Arrays.asList("optionalEarlyTermination"))).getOrDefault(false)) {
						return MapperS.of(EmbeddedOptionTypeEnum.OPET);
					}
					if (onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()), Arrays.asList("cancelableProvision", "earlyTerminationProvision", "evergreenProvision", "extendibleProvision"), Arrays.asList("earlyTerminationProvision")).andNullSafe(onlyExists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()), Arrays.asList("mandatoryEarlyTermination", "mandatoryEarlyTerminationDateTenor", "optionalEarlyTermination", "optionalEarlyTerminationParameters"), Arrays.asList("mandatoryEarlyTermination"))).getOrDefault(false)) {
						return MapperS.of(EmbeddedOptionTypeEnum.MDET);
					}
					if (exists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<ExtendibleProvision>map("getExtendibleProvision", terminationProvision -> terminationProvision.getExtendibleProvision())).orNullSafe(exists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<CancelableProvision>map("getCancelableProvision", terminationProvision -> terminationProvision.getCancelableProvision()))).orNullSafe(exists(item.<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()))).getOrDefault(false)) {
						return MapperS.of(EmbeddedOptionTypeEnum.OTHR);
					}
					return MapperS.<EmbeddedOptionTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
