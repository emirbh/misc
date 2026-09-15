package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iosco.cde.version3.execution.reports.CentralCounterpartyRule;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PlatformAnonymousExecutionIndicatorRule.PlatformAnonymousExecutionIndicatorRuleDefault.class)
public abstract class PlatformAnonymousExecutionIndicatorRule implements ReportFunction<TransactionReportInstruction, List<Boolean>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<Boolean> evaluate(TransactionReportInstruction input) {
		List<Boolean> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<Boolean> doEvaluate(TransactionReportInstruction input);

	public static class PlatformAnonymousExecutionIndicatorRuleDefault extends PlatformAnonymousExecutionIndicatorRule {
		@Override
		protected List<Boolean> doEvaluate(TransactionReportInstruction input) {
			List<Boolean> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<Boolean> assignOutput(List<Boolean> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperC<Boolean> ifThenElseResult;
			if (areEqual(MapperS.of(actionTypeRule.evaluate(thenArg0.get())), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(eventTypeRule.evaluate(thenArg0.get())), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(centralCounterpartyRule.evaluate(thenArg0.get())))).getOrDefault(false)) {
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
					.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
				ifThenElseResult = thenArg2
					.mapItem(item -> MapperS.of(item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<Boolean>map("getSefOrDcmAnonymousIndicator", reportableExecutionVenue -> reportableExecutionVenue.getSefOrDcmAnonymousIndicator()).getOrDefault(false)));
			} else {
				final MapperC<ReportableJurisdictionInformation> thenArg3 = thenArg0
					.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
				ifThenElseResult = thenArg3
					.mapItem(item -> {
						final MapperS<ReportableJurisdictionInformation> thenArg = item
							.filterSingleNullSafe(_item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), _item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
						if (ComparisonResult.ofNullSafe(exists(thenArg).asMapper()).andNullSafe(areEqual(MapperC.<ExecutionVenueTypeEnum>of(MapperS.of(ExecutionVenueTypeEnum.SEF), MapperS.of(ExecutionVenueTypeEnum.DCM)), item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", reportableExecutionVenue -> reportableExecutionVenue.getExecutionVenueType()), CardinalityOperator.Any)).getOrDefault(false)) {
							return MapperS.of(item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<Boolean>map("getSefOrDcmAnonymousIndicator", reportableExecutionVenue -> reportableExecutionVenue.getSefOrDcmAnonymousIndicator()).getOrDefault(false));
						}
						return MapperS.<Boolean>ofNull();
					});
			}
			output = ifThenElseResult.getMulti();
			
			return output;
		}
	}
}
