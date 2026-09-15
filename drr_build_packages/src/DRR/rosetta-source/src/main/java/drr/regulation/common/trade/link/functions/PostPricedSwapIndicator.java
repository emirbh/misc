package drr.regulation.common.trade.link.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Collections;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PostPricedSwapIndicator.PostPricedSwapIndicatorDefault.class)
public abstract class PostPricedSwapIndicator implements RosettaFunction {

	/**
	* @param transactionReportInstruction 
	* @param supervisory 
	* @return result 
	*/
	public Boolean evaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum supervisory) {
		Boolean result = doEvaluate(transactionReportInstruction, supervisory);
		
		return result;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum supervisory);

	public static class PostPricedSwapIndicatorDefault extends PostPricedSwapIndicator {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum supervisory) {
			Boolean result = null;
			return assignOutput(result, transactionReportInstruction, supervisory);
		}
		
		protected Boolean assignOutput(Boolean result, TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum supervisory) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisory), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			final MapperC<Boolean> thenArg3 = thenArg2
				.mapSingleToList(item -> distinctIgnoringPrecision(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<Boolean>map("getPostPricedIndicator", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPostPricedIndicator())));
			final MapperC<Boolean> ifThenElseResult;
			if (exists(thenArg3).getOrDefault(false)) {
				ifThenElseResult = thenArg3;
			} else {
				ifThenElseResult = MapperC.of(Collections.singletonList(false));
			}
			result = MapperS.of(ifThenElseResult.get()).get();
			
			return result;
		}
	}
}
