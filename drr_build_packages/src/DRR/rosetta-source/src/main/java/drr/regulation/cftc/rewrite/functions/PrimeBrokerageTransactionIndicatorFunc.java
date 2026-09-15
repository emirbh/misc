package drr.regulation.cftc.rewrite.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PartyInformation;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PrimeBrokerageTransactionIndicatorFunc.PrimeBrokerageTransactionIndicatorFuncDefault.class)
public abstract class PrimeBrokerageTransactionIndicatorFunc implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;

	/**
	* @param transaction 
	* @return indicator 
	*/
	public Boolean evaluate(TransactionReportInstruction transaction) {
		Boolean indicator = doEvaluate(transaction);
		
		return indicator;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transaction);

	protected abstract MapperS<Boolean> primeBrokerExists(TransactionReportInstruction transaction);

	protected abstract MapperC<? extends JurisdictionPartyInformation> executingBrokerPartyInfo(TransactionReportInstruction transaction);

	protected abstract MapperS<Boolean> executingBrokerIsUSPerson(TransactionReportInstruction transaction);

	public static class PrimeBrokerageTransactionIndicatorFuncDefault extends PrimeBrokerageTransactionIndicatorFunc {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transaction) {
			Boolean indicator = null;
			return assignOutput(indicator, transaction);
		}
		
		protected Boolean assignOutput(Boolean indicator, TransactionReportInstruction transaction) {
			indicator = ComparisonResult.ofNullSafe(primeBrokerExists(transaction)).andNullSafe(ComparisonResult.ofNullSafe(executingBrokerIsUSPerson(transaction))).get();
			
			return indicator;
		}
		
		@Override
		protected MapperS<Boolean> primeBrokerExists(TransactionReportInstruction transaction) {
			return exists(MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.PRIME_BROKER))).asMapper();
		}
		
		@Override
		protected MapperC<? extends JurisdictionPartyInformation> executingBrokerPartyInfo(TransactionReportInstruction transaction) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.DODD_FRANK_ACT), CardinalityOperator.All).andNullSafe(areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All)).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
				.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
			return thenArg3
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.EXECUTING_BROKER)), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperS<Boolean> executingBrokerIsUSPerson(TransactionReportInstruction transaction) {
			return MapperS.of(executingBrokerPartyInfo(transaction).<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()).<Boolean>map("getIsUSPerson", cFTCPartyInformation -> cFTCPartyInformation.getIsUSPerson())
				.first().getOrDefault(false));
		}
	}
}
