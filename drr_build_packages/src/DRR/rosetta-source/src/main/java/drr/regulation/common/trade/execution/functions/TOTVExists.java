package drr.regulation.common.trade.execution.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TOTVExists.TOTVExistsDefault.class)
public abstract class TOTVExists implements RosettaFunction {

	/**
	* @param reportableInformation 
	* @param regimeName 
	* @param supervisoryBodies 
	* @return result 
	*/
	public Boolean evaluate(ReportableInformation reportableInformation, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
		Boolean result = doEvaluate(reportableInformation, regimeName, supervisoryBodies);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies);

	public static class TOTVExistsDefault extends TOTVExists {
		@Override
		protected Boolean doEvaluate(ReportableInformation reportableInformation, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
			if (supervisoryBodies == null) {
				supervisoryBodies = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, reportableInformation, regimeName, supervisoryBodies);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableInformation reportableInformation, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(MapperS.of(regimeName), MapperS.of(regimeName), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodies), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any)).get());
			final MapperS<TradableOnTradingVenueEnum> thenArg2 = MapperS.of(distinctIgnoringPrecision(thenArg1.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", transactionInformation -> transactionInformation.getTradableOnTradingVenue())).get());
			result = thenArg2
				.mapSingleToItem(item -> {
					if (exists(item).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.of(false);
				}).get();
			
			return result;
		}
	}
}
