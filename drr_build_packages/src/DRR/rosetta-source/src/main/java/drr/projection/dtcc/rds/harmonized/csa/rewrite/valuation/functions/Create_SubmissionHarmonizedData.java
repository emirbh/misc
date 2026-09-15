package drr.projection.dtcc.rds.harmonized.csa.rewrite.valuation.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
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
	public HarmonizedData evaluate(CSAValuationReport drrReport) {
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

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CSAValuationReport drrReport);

	public static class Create_SubmissionHarmonizedDataDefault extends Create_SubmissionHarmonizedData {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CSAValuationReport drrReport) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CSAValuationReport drrReport) {
			harmonized = toBuilder(HarmonizedData.builder()
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cSAValuationReport -> cSAValuationReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setVersion(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cSAValuationReport -> cSAValuationReport.getDtccValuationFields()).<String>map("getVersion", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getVersion()).get())
				.setComment1(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cSAValuationReport -> cSAValuationReport.getDtccValuationFields()).<String>map("getComment1", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getComment1()).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cSAValuationReport -> cSAValuationReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cSAValuationReport -> cSAValuationReport.getVariationMarginCollateralPortfolioCode()).get())
				.setPriorUsiIdPrefix(null)
				.setPriorUtiIdPrefix(null)
				.setTradeParty1ValuationAmount(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", cSAValuationReport -> cSAValuationReport.getValuationAmount()).get())
				.setTradeParty1ValuationCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", cSAValuationReport -> cSAValuationReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setTradeParty1ValuationDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", cSAValuationReport -> cSAValuationReport.getValuationTimestamp()).get())
				.setTradeParty1ValuationType(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", cSAValuationReport -> cSAValuationReport.getValuationMethod()).map("to-string", ValuationType1Code::toDisplayString).get())
				.setNextFloatingReferenceResetDateLeg1(MapperS.of(drrReport).<Date>map("getNextFloatingReferenceResetDateLeg1", cSAValuationReport -> cSAValuationReport.getNextFloatingReferenceResetDateLeg1()).get())
				.setLastFloatingReferenceValueLeg1(MapperS.of(drrReport).<BigDecimal>map("getLastFloatingReferenceValueLeg1", cSAValuationReport -> cSAValuationReport.getLastFloatingReferenceValueLeg1()).get())
				.setLastFloatingReferenceResetDateLeg1(MapperS.of(drrReport).<Date>map("getLastFloatingReferenceResetDateLeg1", cSAValuationReport -> cSAValuationReport.getLastFloatingReferenceResetDateLeg1()).get())
				.setNextFloatingReferenceResetDateLeg2(MapperS.of(drrReport).<Date>map("getNextFloatingReferenceResetDateLeg2", cSAValuationReport -> cSAValuationReport.getNextFloatingReferenceResetDateLeg2()).get())
				.setLastFloatingReferenceValueLeg2(MapperS.of(drrReport).<BigDecimal>map("getLastFloatingReferenceValueLeg2", cSAValuationReport -> cSAValuationReport.getLastFloatingReferenceValueLeg2()).get())
				.setLastFloatingReferenceResetDateLeg2(MapperS.of(drrReport).<Date>map("getLastFloatingReferenceResetDateLeg2", cSAValuationReport -> cSAValuationReport.getLastFloatingReferenceResetDateLeg2()).get())
				.setCdeDelta(MapperS.of(drrReport).<BigDecimal>map("getDelta", cSAValuationReport -> cSAValuationReport.getDelta()).get())
				.build());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
