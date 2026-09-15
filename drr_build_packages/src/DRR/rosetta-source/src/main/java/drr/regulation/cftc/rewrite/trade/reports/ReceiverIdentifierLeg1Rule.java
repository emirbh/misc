package drr.regulation.cftc.rewrite.trade.reports;

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
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version2.party.functions.ReceiverParty;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReceiverIdentifierLeg1Rule.ReceiverIdentifierLeg1RuleDefault.class)
public abstract class ReceiverIdentifierLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
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

	public static class ReceiverIdentifierLeg1RuleDefault extends ReceiverIdentifierLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<String> ifThenElseResult;
			if (notExists(MapperS.of(sellerIdentifierRule.evaluate(thenArg.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(productForEvent.evaluate(thenArg.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(productForEvent.evaluate(thenArg.get()))))).getOrDefault(false)) {
				ifThenElseResult = thenArg
					.mapSingleToItem(item -> {
						final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
						return MapperS.of(partyLeiAndPersonByRoles.evaluate(receiverParty.evaluate(payoutLeg1Rule.evaluate(item.get()), counterpartiesForEvent.evaluate(item.get())), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
					});
			} else {
				ifThenElseResult = MapperS.<String>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
