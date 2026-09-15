package drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.cftc.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ValuationType1Code;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedData.Create_SubmissionHarmonizedDataDefault.class)
public abstract class Create_SubmissionHarmonizedData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return harmonized 
	*/
	public HarmonizedData evaluate(CFTCValuationReport drrReport) {
		HarmonizedData.HarmonizedDataBuilder harmonizedBuilder = doEvaluate(drrReport);
		
		final HarmonizedData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCValuationReport drrReport);

	public static class Create_SubmissionHarmonizedDataDefault extends Create_SubmissionHarmonizedData {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCValuationReport drrReport) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CFTCValuationReport drrReport) {
			harmonized = toBuilder(HarmonizedData.builder()
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cFTCValuationReport -> cFTCValuationReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setVersion(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getVersion", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getVersion()).get())
				.setComment1(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getComment1", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getComment1()).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cFTCValuationReport -> cFTCValuationReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cFTCValuationReport -> cFTCValuationReport.getVariationMarginCollateralPortfolioCode()).get())
				.setTradeParty1ValuationAmount(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", cFTCValuationReport -> cFTCValuationReport.getValuationAmount()).get())
				.setTradeParty1ValuationCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", cFTCValuationReport -> cFTCValuationReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setTradeParty1ValuationDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", cFTCValuationReport -> cFTCValuationReport.getValuationTimestamp()).get())
				.setTradeParty1ValuationType(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", cFTCValuationReport -> cFTCValuationReport.getValuationMethod()).map("to-string", ValuationType1Code::toDisplayString).get())
				.setNextFloatingReferenceResetDateLeg1(MapperS.of(drrReport).<Date>map("getNextFloatingReferenceResetDateLeg1", cFTCValuationReport -> cFTCValuationReport.getNextFloatingReferenceResetDateLeg1()).get())
				.setLastFloatingReferenceValueLeg1(MapperS.of(drrReport).<BigDecimal>map("getLastFloatingReferenceValueLeg1", cFTCValuationReport -> cFTCValuationReport.getLastFloatingReferenceValueLeg1()).get())
				.setLastFloatingReferenceResetDateLeg1(MapperS.of(drrReport).<Date>map("getLastFloatingReferenceResetDateLeg1", cFTCValuationReport -> cFTCValuationReport.getLastFloatingReferenceResetDateLeg1()).get())
				.setNextFloatingReferenceResetDateLeg2(MapperS.of(drrReport).<Date>map("getNextFloatingReferenceResetDateLeg2", cFTCValuationReport -> cFTCValuationReport.getNextFloatingReferenceResetDateLeg2()).get())
				.setLastFloatingReferenceValueLeg2(MapperS.of(drrReport).<BigDecimal>map("getLastFloatingReferenceValueLeg2", cFTCValuationReport -> cFTCValuationReport.getLastFloatingReferenceValueLeg2()).get())
				.setLastFloatingReferenceResetDateLeg2(MapperS.of(drrReport).<Date>map("getLastFloatingReferenceResetDateLeg2", cFTCValuationReport -> cFTCValuationReport.getLastFloatingReferenceResetDateLeg2()).get())
				.setCdeDelta(MapperS.of(drrReport).<BigDecimal>map("getDelta", cFTCValuationReport -> cFTCValuationReport.getDelta()).get())
				.build());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
