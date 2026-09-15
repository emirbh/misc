package drr.regulation.common.emir.contract.functions;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.MandatorilyClearableEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsRegulatedMarketOrThirdCountryEquivalentMarket;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.standards.iso.ClearingObligationEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EMIRClearingObligation.EMIRClearingObligationDefault.class)
public abstract class EMIRClearingObligation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCleared isCleared;
	@Inject protected IsRegulatedMarketOrThirdCountryEquivalentMarket isRegulatedMarketOrThirdCountryEquivalentMarket;

	/**
	* @param transactionReportInstruction 
	* @param rgmName 
	* @param sprvsryBody 
	* @return result 
	*/
	public ClearingObligationEnum evaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum rgmName, SupervisoryBodyEnum sprvsryBody) {
		ClearingObligationEnum result = doEvaluate(transactionReportInstruction, rgmName, sprvsryBody);
		
		return result;
	}

	protected abstract ClearingObligationEnum doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum rgmName, SupervisoryBodyEnum sprvsryBody);

	public static class EMIRClearingObligationDefault extends EMIRClearingObligation {
		@Override
		protected ClearingObligationEnum doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum rgmName, SupervisoryBodyEnum sprvsryBody) {
			ClearingObligationEnum result = null;
			return assignOutput(result, transactionReportInstruction, rgmName, sprvsryBody);
		}
		
		protected ClearingObligationEnum assignOutput(ClearingObligationEnum result, TransactionReportInstruction transactionReportInstruction, RegimeNameEnum rgmName, SupervisoryBodyEnum sprvsryBody) {
			final Boolean _boolean = isCleared.evaluate(MapperS.of(transactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get());
			if ((_boolean == null ? false : _boolean)) {
				result = ClearingObligationEnum.UKWN;
			} else if (areEqual(MapperS.of(isRegulatedMarketOrThirdCountryEquivalentMarket.evaluate(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get(), rgmName)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(sprvsryBody), CardinalityOperator.All).andNullSafe(areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(rgmName), CardinalityOperator.All)).get());
				final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
				final MapperS<MandatorilyClearableEnum> thenArg3 = thenArg2
					.mapSingleToItem(item -> MapperS.of(distinctIgnoringPrecision(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<MandatorilyClearableEnum>map("getMandatorilyClearable", jurisdictionPartyInformation -> jurisdictionPartyInformation.getMandatorilyClearable())).get()));
				result = thenArg3
					.mapSingleToItem(item -> {
						if (areEqual(item, MapperS.of(MandatorilyClearableEnum.PRODUCT_AND_CPTY_MANDATORY), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(ClearingObligationEnum.TRUE);
						}
						if (areEqual(item, MapperS.of(MandatorilyClearableEnum.PRODUCT_MANDATORY_BUT_NOT_CPTY), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(ClearingObligationEnum.FLSE);
						}
						if (areEqual(item, MapperS.of(MandatorilyClearableEnum.PRODUCT_NOT_MANDATORY), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(ClearingObligationEnum.UKWN);
						}
						return MapperS.<ClearingObligationEnum>ofNull();
					}).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
