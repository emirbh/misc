package drr.regulation.sec.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.ReportingSide;
import drr.base.trade.functions.ProductForEvent;
import drr.base.util.party.functions.CounterpartiesForEvent;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import drr.standards.iosco.cde.version2.party.functions.ReceiverParty;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReceiverIdentifierLeg2Rule.ReceiverIdentifierLeg2RuleDefault.class)
public abstract class ReceiverIdentifierLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected ReceiverParty receiverParty;
	@Inject protected SellerIdentifierRule sellerIdentifierRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class ReceiverIdentifierLeg2RuleDefault extends ReceiverIdentifierLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperS<String> ifThenElseResult;
			if (notExists(MapperS.of(sellerIdentifierRule.evaluate(thenArg.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(productForEvent.evaluate(thenArg.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(productForEvent.evaluate(thenArg.get()))))).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> {
						final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
						return MapperS.of(partyLeiAndPersonByRoles.evaluate(receiverParty.evaluate(payoutLeg2Rule.evaluate(item.get()), counterpartiesForEvent.evaluate(item.get())), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
					});
			} else {
				ifThenElseResult = MapperS.<String>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
