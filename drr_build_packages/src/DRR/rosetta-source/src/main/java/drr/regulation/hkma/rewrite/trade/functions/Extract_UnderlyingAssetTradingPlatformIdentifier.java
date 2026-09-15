package drr.regulation.hkma.rewrite.trade.functions;

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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_UnderlyingAssetTradingPlatformIdentifier.Extract_UnderlyingAssetTradingPlatformIdentifierDefault.class)
public abstract class Extract_UnderlyingAssetTradingPlatformIdentifier implements RosettaFunction {

	/**
	* @param reportableInformation 
	* @return underlyingAssetPlatformIdentifier 
	*/
	public String evaluate(ReportableInformation reportableInformation) {
		String underlyingAssetPlatformIdentifier = doEvaluate(reportableInformation);
		
		return underlyingAssetPlatformIdentifier;
	}

	protected abstract String doEvaluate(ReportableInformation reportableInformation);

	public static class Extract_UnderlyingAssetTradingPlatformIdentifierDefault extends Extract_UnderlyingAssetTradingPlatformIdentifier {
		@Override
		protected String doEvaluate(ReportableInformation reportableInformation) {
			String underlyingAssetPlatformIdentifier = null;
			return assignOutput(underlyingAssetPlatformIdentifier, reportableInformation);
		}
		
		protected String assignOutput(String underlyingAssetPlatformIdentifier, ReportableInformation reportableInformation) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(reportableInformation).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", _reportableInformation -> _reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.HKMA), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			final MapperS<TransactionInformation> thenArg3 = thenArg2
				.mapSingleToItem(item -> item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()));
			underlyingAssetPlatformIdentifier = thenArg3
				.mapSingleToItem(item -> {
					if (exists(item.<String>map("getUnderlierAssetTradingPlatformIdentifier", transactionInformation -> transactionInformation.getUnderlierAssetTradingPlatformIdentifier())).getOrDefault(false)) {
						return item.<String>map("getUnderlierAssetTradingPlatformIdentifier", transactionInformation -> transactionInformation.getUnderlierAssetTradingPlatformIdentifier());
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return underlyingAssetPlatformIdentifier;
		}
	}
}
