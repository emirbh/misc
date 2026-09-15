package drr.regulation.csa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsUnderlierTOTV.IsUnderlierTOTVDefault.class)
public abstract class IsUnderlierTOTV implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param reportableInformation 
	* @return result 
	*/
	public Boolean evaluate(ReportableInformation reportableInformation) {
		Boolean result = doEvaluate(reportableInformation);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableInformation reportableInformation);

	public static class IsUnderlierTOTVDefault extends IsUnderlierTOTV {
		@Override
		protected Boolean doEvaluate(ReportableInformation reportableInformation) {
			Boolean result = null;
			return assignOutput(result, reportableInformation);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableInformation reportableInformation) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
			final MapperS<Boolean> thenArg2 = MapperS.of(distinctIgnoringPrecision(thenArg1.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<Boolean>map("getUnderlierTradedOnTradingVenue", transactionInformation -> transactionInformation.getUnderlierTradedOnTradingVenue())).get());
			result = thenArg2
				.mapSingleToItem(item -> {
					if (areEqual(item, MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.of(false);
				}).get();
			
			return result;
		}
	}
}
