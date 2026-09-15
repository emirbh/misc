package drr.regulation.common.dtcc.trade.functions;

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
import drr.base.trade.ReportingSide;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iosco.cde.version3.execution.reports.CentralCounterpartyRule;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SEFOrDCMAnonymousExecutionIndicator.DTCC_SEFOrDCMAnonymousExecutionIndicatorDefault.class)
public abstract class DTCC_SEFOrDCMAnonymousExecutionIndicator implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected EventTypeRule eventTypeRule;

	/**
	* @param transaction 
	* @param supervisor 
	* @return result 
	*/
	public Boolean evaluate(TransactionReportInstruction transaction, SupervisoryBodyEnum supervisor) {
		Boolean result = doEvaluate(transaction, supervisor);
		
		return result;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transaction, SupervisoryBodyEnum supervisor);

	public static class DTCC_SEFOrDCMAnonymousExecutionIndicatorDefault extends DTCC_SEFOrDCMAnonymousExecutionIndicator {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transaction, SupervisoryBodyEnum supervisor) {
			Boolean result = null;
			return assignOutput(result, transaction, supervisor);
		}
		
		protected Boolean assignOutput(Boolean result, TransactionReportInstruction transaction, SupervisoryBodyEnum supervisor) {
			if (areEqual(MapperS.of(actionTypeRule.evaluate(transaction)), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(eventTypeRule.evaluate(transaction)), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(centralCounterpartyRule.evaluate(transaction)))).getOrDefault(false)) {
				final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisor), CardinalityOperator.All).get());
				final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
				result = thenArg2
					.mapSingleToItem(item -> MapperS.of(item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<Boolean>map("getSefOrDcmAnonymousIndicator", reportableExecutionVenue -> reportableExecutionVenue.getSefOrDcmAnonymousIndicator()).getOrDefault(false))).get();
			} else {
				final MapperC<ReportableJurisdictionInformation> thenArg3 = MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg4 = thenArg3
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisor), CardinalityOperator.All).get());
				final MapperS<ReportableJurisdictionInformation> thenArg5 = MapperS.of(thenArg4.get());
				result = thenArg5
					.mapSingleToItem(item -> {
						final MapperC<RelatedParty> _thenArg0 = MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty());
						final MapperC<RelatedParty> _thenArg1 = _thenArg0
							.filterItemNullSafe(_item -> areEqual(_item.<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.EXECUTION_FACILITY), CardinalityOperator.All).andNullSafe(areEqual(_item.<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), MapperS.of(transaction).<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All)).get());
						if (exists(item).andNullSafe(ComparisonResult.ofNullSafe(exists(_thenArg1).asMapper())).getOrDefault(false)) {
							return MapperS.of(item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<Boolean>map("getSefOrDcmAnonymousIndicator", reportableExecutionVenue -> reportableExecutionVenue.getSefOrDcmAnonymousIndicator()).getOrDefault(false));
						}
						return MapperS.<Boolean>ofNull();
					}).get();
			}
			
			return result;
		}
	}
}
