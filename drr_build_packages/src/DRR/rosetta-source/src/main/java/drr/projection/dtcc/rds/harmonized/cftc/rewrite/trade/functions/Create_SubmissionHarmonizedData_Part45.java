package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.JurisdictionEnum;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedData_Part45.Create_SubmissionHarmonizedData_Part45Default.class)
public abstract class Create_SubmissionHarmonizedData_Part45 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param commonHarmonized 
	* @return harmonized 
	*/
	public HarmonizedData evaluate(CFTCPart45TransactionReport drrReport, HarmonizedData commonHarmonized) {
		HarmonizedData.HarmonizedDataBuilder harmonizedBuilder = doEvaluate(drrReport, commonHarmonized);
		
		final HarmonizedData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCPart45TransactionReport drrReport, HarmonizedData commonHarmonized);

	public static class Create_SubmissionHarmonizedData_Part45Default extends Create_SubmissionHarmonizedData_Part45 {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCPart45TransactionReport drrReport, HarmonizedData commonHarmonized) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport, commonHarmonized);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CFTCPart45TransactionReport drrReport, HarmonizedData commonHarmonized) {
			harmonized = toBuilder(commonHarmonized, () -> HarmonizedData.builder());
			
			harmonized
				.setAllocationType(MapperS.of(drrReport).<AllocationIndicatorEnum>map("getAllocationIndicator", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getAllocationIndicator()).map("to-string", AllocationIndicatorEnum::toDisplayString).get());
			
			harmonized
				.setOriginalSwapUsi(MapperS.of(drrReport).<String>map("getOriginalSwapUSI", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getOriginalSwapUSI()).get());
			
			harmonized
				.setCounterparty1FederalEntityIndicator(MapperS.of(drrReport).<Boolean>map("getCounterparty1FederalEntityIndicator", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getCounterparty1FederalEntityIndicator()).get());
			
			harmonized
				.setCounterparty2FederalEntityIndicator(MapperS.of(drrReport).<Boolean>map("getCounterparty2FederalEntityIndicator", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getCounterparty2FederalEntityIndicator()).get());
			
			harmonized
				.setSwapReportingJurisdiction(MapperS.of(drrReport).<JurisdictionEnum>map("getJurisdiction", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getJurisdiction()).map("to-string", JurisdictionEnum::toDisplayString).get());
			
			harmonized
				.setClearingSwapUtiId(MapperS.of(drrReport).<String>mapC("getClearingSwapUTIs", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getClearingSwapUTIs())
					.first().get());
			
			harmonized
				.setSecondaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getSecondaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getSecondaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get());
			
			harmonized
				.setTradeParty1CftcFinancialEntityStatus(MapperS.of(drrReport).<Boolean>map("getCounterparty1FinancialEntityIndicator", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getCounterparty1FinancialEntityIndicator()).map("to-string", Object::toString).get());
			
			harmonized
				.setTradeParty2CftcFinancialEntityStatus(MapperS.of(drrReport).<Boolean>map("getCounterparty2FinancialEntityIndicator", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getCounterparty2FinancialEntityIndicator()).map("to-string", Object::toString).get());
			
			harmonized
				.setVersion(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>map("getVersion", dTCCAdditionalFields -> dTCCAdditionalFields.getVersion()).get());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
