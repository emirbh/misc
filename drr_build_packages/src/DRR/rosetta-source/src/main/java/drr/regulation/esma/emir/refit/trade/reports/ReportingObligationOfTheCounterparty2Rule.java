package drr.regulation.esma.emir.refit.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportingObligationOfTheCounterparty2Rule.ReportingObligationOfTheCounterparty2RuleDefault.class)
public abstract class ReportingObligationOfTheCounterparty2Rule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class ReportingObligationOfTheCounterparty2RuleDefault extends ReportingObligationOfTheCounterparty2Rule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<ESMAPartyInformation> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).get();
					return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA)).<ESMAPartyInformation>map("getEsmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getEsmaPartyInformation());
				});
			final MapperS<ESMAPartyInformation> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(MapperC.<NatureOfPartyEnum>of(MapperS.of(NatureOfPartyEnum.FINANCIAL), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL)), item.<NatureOfPartyEnum>map("getNatureOfParty", eSMAPartyInformation -> eSMAPartyInformation.getNatureOfParty()), CardinalityOperator.Any).get());
			output = thenArg2
				.mapSingleToItem(item -> areEqual(item.<NatureOfPartyEnum>map("getNatureOfParty", eSMAPartyInformation -> eSMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.FINANCIAL), CardinalityOperator.All).orNullSafe(areEqual(item.<NatureOfPartyEnum>map("getNatureOfParty", eSMAPartyInformation -> eSMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All).andNullSafe(areEqual(item.<Boolean>map("getExceedsClearingThreshold", eSMAPartyInformation -> eSMAPartyInformation.getExceedsClearingThreshold()), MapperS.of(true), CardinalityOperator.All))).asMapper()).get();
			
			return output;
		}
	}
}
