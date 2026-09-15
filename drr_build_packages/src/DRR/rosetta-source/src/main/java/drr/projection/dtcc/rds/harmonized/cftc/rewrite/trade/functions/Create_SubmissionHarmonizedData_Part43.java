package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedData_Part43.Create_SubmissionHarmonizedData_Part43Default.class)
public abstract class Create_SubmissionHarmonizedData_Part43 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param commonHarmonized 
	* @return harmonized 
	*/
	public HarmonizedData evaluate(CFTCPart43TransactionReport drrReport, HarmonizedData commonHarmonized) {
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

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCPart43TransactionReport drrReport, HarmonizedData commonHarmonized);

	public static class Create_SubmissionHarmonizedData_Part43Default extends Create_SubmissionHarmonizedData_Part43 {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCPart43TransactionReport drrReport, HarmonizedData commonHarmonized) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport, commonHarmonized);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CFTCPart43TransactionReport drrReport, HarmonizedData commonHarmonized) {
			harmonized = toBuilder(commonHarmonized, () -> HarmonizedData.builder());
			
			harmonized
				.setClearingVenueIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart43TransactionReport -> cFTCPart43TransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getClearingVenueIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getClearingVenueIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setOriginalSwapSdrIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart43TransactionReport -> cFTCPart43TransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getOriginalSwapSDRIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOriginalSwapSDRIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setTradeParty1ClearingBrokerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart43TransactionReport -> cFTCPart43TransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ClearingBrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ClearingBrokerIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setVersion(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart43TransactionReport -> cFTCPart43TransactionReport.getDtccAdditionalFields()).<String>map("getVersion", dTCCAdditionalFields -> dTCCAdditionalFields.getVersion()).get());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
