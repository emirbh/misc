package drr.projection.iso20022.esma.emir.refit.margin.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import iso20022.auth108.esma.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.esma.ReceivedMarginOrCollateral6__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ReceivedMarginReport.Create_ReceivedMarginReportDefault.class)
public abstract class Create_ReceivedMarginReport implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param marginReport 
	* @return rcvdMarginData 
	*/
	public ReceivedMarginOrCollateral6__1 evaluate(ESMAEMIRMarginReport marginReport) {
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder rcvdMarginDataBuilder = doEvaluate(marginReport);
		
		final ReceivedMarginOrCollateral6__1 rcvdMarginData;
		if (rcvdMarginDataBuilder == null) {
			rcvdMarginData = null;
		} else {
			rcvdMarginData = rcvdMarginDataBuilder.build();
			objectValidator.validate(ReceivedMarginOrCollateral6__1.class, rcvdMarginData);
		}
		
		return rcvdMarginData;
	}

	protected abstract ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder doEvaluate(ESMAEMIRMarginReport marginReport);

	public static class Create_ReceivedMarginReportDefault extends Create_ReceivedMarginReport {
		@Override
		protected ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder doEvaluate(ESMAEMIRMarginReport marginReport) {
			ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder rcvdMarginData = ReceivedMarginOrCollateral6__1.builder();
			return assignOutput(rcvdMarginData, marginReport);
		}
		
		protected ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder assignOutput(ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder rcvdMarginData, ESMAEMIRMarginReport marginReport) {
			rcvdMarginData = toBuilder(ReceivedMarginOrCollateral6__1.builder()
				.setInitlMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getInitialMarginCollectedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setInitlMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PostHaircut", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getInitialMarginCollectedByCounterparty1PostHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getInitialMarginCollectedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setVartnMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getVariationMarginCollectedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setVartnMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PostHaircut", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PostHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getVariationMarginCollectedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setXcssCollRcvd(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getExcessCollateralCollectedByTheCounterparty1", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getExcessCollateralCollectedByTheCounterparty1()).get())
					.setCcy(MapperS.of(marginReport).<String>map("getCurrencyOfTheExcessCollateralCollected", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCurrencyOfTheExcessCollateralCollected()).map("to-string", Object::toString).get())
					.build())
				.build());
			
			return Optional.ofNullable(rcvdMarginData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
