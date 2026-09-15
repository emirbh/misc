package drr.regulation.common.trade.execution.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.standards.iosco.cde.version3.execution.reports.PlatformIdentifierRule;
import drr.standards.iso.MicData;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PlatformIdentifier.PlatformIdentifierDefault.class)
public abstract class PlatformIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected TOTVExists tOTVExists;

	/**
	* @param transactionReportInstruction 
	* @param regimeName 
	* @param supervisoryBodies 
	* @return result 
	*/
	public String evaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
		String result = doEvaluate(transactionReportInstruction, regimeName, supervisoryBodies);
		
		return result;
	}

	protected abstract String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies);

	public static class PlatformIdentifierDefault extends PlatformIdentifier {
		@Override
		protected String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
			if (supervisoryBodies == null) {
				supervisoryBodies = Collections.emptyList();
			}
			String result = null;
			return assignOutput(result, transactionReportInstruction, regimeName, supervisoryBodies);
		}
		
		protected String assignOutput(String result, TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName, List<SupervisoryBodyEnum> supervisoryBodies) {
			if (notExists(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(tOTVExists.evaluate(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get(), regimeName, supervisoryBodies)))).getOrDefault(false)) {
				final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
					.filterItemNullSafe(item -> areEqual(MapperS.of(regimeName), MapperS.of(regimeName), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodies), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any)).get());
				final MapperS<TradableOnTradingVenueEnum> thenArg2 = MapperS.of(distinctIgnoringPrecision(thenArg1.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", transactionInformation -> transactionInformation.getTradableOnTradingVenue())).get());
				final MapperS<String> ifThenElseResult;
				if (areEqual(thenArg2, MapperS.of(TradableOnTradingVenueEnum.ADMITTED), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = MapperS.of("XOFF");
				} else if (areEqual(thenArg2, MapperS.of(TradableOnTradingVenueEnum.NOT_ADMITTED), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = MapperS.of("XXXX");
				} else if (areEqual(thenArg2, MapperS.of(TradableOnTradingVenueEnum.UNKNOWN), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = MapperS.of("BILT");
				} else {
					ifThenElseResult = MapperS.<String>ofNull();
				}
				result = ifThenElseResult.get();
			} else if (exists(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData())).andNullSafe(areEqual(MapperC.<String>of(MapperS.of("XOFF"), MapperS.of("XXXX"), MapperS.of("BILT")), MapperS.of(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).get()).<String>map("getMic", micData -> micData.getMic()), CardinalityOperator.Any)).getOrDefault(false)) {
				result = MapperS.of(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).get()).<String>map("getMic", micData -> micData.getMic()).get();
			} else {
				result = platformIdentifierRule.evaluate(transactionReportInstruction);
			}
			
			return result;
		}
	}
}
