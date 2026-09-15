package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.common.reports.UpiPreEnrichmentDataRule;
import drr.enrichment.upi.UpiData;
import drr.regulation.common.functions.ExtractProductIdentifierBySource;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlierProductIdentifierOtherRule;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierIdOtherRule.UnderlierIdOtherRuleDefault.class)
public abstract class UnderlierIdOtherRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractProductIdentifierBySource extractProductIdentifierBySource;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected UnderlierProductIdentifierOtherRule underlierProductIdentifierOtherRule;
	@Inject protected UpiPreEnrichmentDataRule upiPreEnrichmentDataRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierIdOtherRuleDefault extends UnderlierIdOtherRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<TransactionReportInstructionBase> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final MapperC<AssetIdentifier> ifThenElseResult;
			if (exists(thenArg0.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformationBase -> reportableInformationBase.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<AnnaDsbUpiRecord>map("getUpiRecord", upiData -> upiData.getUpiRecord())).andNullSafe(areEqual(thenArg0.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformationBase -> reportableInformationBase.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<AnnaDsbUpiRecord>map("getUpiRecord", upiData -> upiData.getUpiRecord()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<String>map("getUnderlierID", annaDsbAttributesRecord -> annaDsbAttributesRecord.getUnderlierID()), MapperS.of("Other"), CardinalityOperator.Any)).orNullSafe(notExists(thenArg0.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformationBase -> reportableInformationBase.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<AnnaDsbUpiRecord>map("getUpiRecord", upiData -> upiData.getUpiRecord()))).getOrDefault(false)) {
				if (exists(MapperS.of(upiPreEnrichmentDataRule.evaluate(thenArg0.get())).<AnnaDsbUpiRequest>map("getRequest", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequest()).<AnnaDsbAttributes>map("getAttributes", annaDsbUpiRequest -> annaDsbUpiRequest.getAttributes()).<String>map("getUnderlierID", annaDsbAttributes -> annaDsbAttributes.getUnderlierID())).andNullSafe(areEqual(MapperS.of(upiPreEnrichmentDataRule.evaluate(thenArg0.get())).<AnnaDsbUpiRequest>map("getRequest", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequest()).<AnnaDsbAttributes>map("getAttributes", annaDsbUpiRequest -> annaDsbUpiRequest.getAttributes()).<String>map("getUnderlierID", annaDsbAttributes -> annaDsbAttributes.getUnderlierID()), MapperS.of("Other"), CardinalityOperator.All)).orNullSafe(notExists(MapperS.of(upiPreEnrichmentDataRule.evaluate(thenArg0.get())).<AnnaDsbUpiRequest>map("getRequest", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequest()).<AnnaDsbAttributes>map("getAttributes", annaDsbUpiRequest -> annaDsbUpiRequest.getAttributes()).<String>map("getUnderlierID", annaDsbAttributes -> annaDsbAttributes.getUnderlierID()))).getOrDefault(false)) {
					ifThenElseResult = thenArg0
						.mapSingleToList(item -> MapperC.<AssetIdentifier>of(underlierProductIdentifierOtherRule.evaluate(item.get())));
				} else {
					ifThenElseResult = MapperC.<AssetIdentifier>ofNull();
				}
			} else {
				ifThenElseResult = MapperC.<AssetIdentifier>ofNull();
			}
			final MapperS<AssetIdentifier> thenArg1 = MapperS.of(extractProductIdentifierBySource.evaluate(ifThenElseResult.getMulti()));
			final FieldWithMetaString fieldWithMetaString = thenArg1.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
