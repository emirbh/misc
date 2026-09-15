package drr.regulation.common.trade.contract.reports;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.LegalAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MasterAgreementVersionRule.MasterAgreementVersionRuleDefault.class)
public abstract class MasterAgreementVersionRule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Integer evaluate(TransactionReportInstruction input) {
		Integer output = doEvaluate(input);
		
		return output;
	}

	protected abstract Integer doEvaluate(TransactionReportInstruction input);

	public static class MasterAgreementVersionRuleDefault extends MasterAgreementVersionRule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperC<LegalAgreement> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<ContractDetails>map("getContractDetails", trade -> trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()));
			final MapperC<LegalAgreement> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<LegalAgreementTypeEnum>map("getAgreementType", agreementName -> agreementName.getAgreementType()), MapperS.of(LegalAgreementTypeEnum.MASTER_AGREEMENT), CardinalityOperator.All).get());
			final MapperS<LegalAgreement> thenArg3 = MapperS.of(thenArg2.get());
			output = thenArg3
				.mapSingleToItem(item -> item.<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<Integer>map("getVintage", legalAgreementIdentification -> legalAgreementIdentification.getVintage())).get();
			
			return output;
		}
	}
}
