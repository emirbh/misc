package drr.projection.iso20022.asic.rewrite.margin.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import iso20022.auth108.asic.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth108.asic.PostedMarginOrCollateral6__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_PostedMarginReport.Create_PostedMarginReportDefault.class)
public abstract class Create_PostedMarginReport implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param marginReport 
	* @return postMarginData 
	*/
	public PostedMarginOrCollateral6__1 evaluate(ASICMarginReport marginReport) {
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder postMarginDataBuilder = doEvaluate(marginReport);
		
		final PostedMarginOrCollateral6__1 postMarginData;
		if (postMarginDataBuilder == null) {
			postMarginData = null;
		} else {
			postMarginData = postMarginDataBuilder.build();
			objectValidator.validate(PostedMarginOrCollateral6__1.class, postMarginData);
		}
		
		return postMarginData;
	}

	protected abstract PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder doEvaluate(ASICMarginReport marginReport);

	public static class Create_PostedMarginReportDefault extends Create_PostedMarginReport {
		@Override
		protected PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder doEvaluate(ASICMarginReport marginReport) {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder postMarginData = PostedMarginOrCollateral6__1.builder();
			return assignOutput(postMarginData, marginReport);
		}
		
		protected PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder assignOutput(PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder postMarginData, ASICMarginReport marginReport) {
			postMarginData = toBuilder(PostedMarginOrCollateral6__1.builder()
				.setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getInitialMarginPostedByTheCounterparty1PreHaircut", aSICMarginReport -> aSICMarginReport.getInitialMarginPostedByTheCounterparty1PreHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getInitialMarginPostedByCounterparty1Currency", aSICMarginReport -> aSICMarginReport.getInitialMarginPostedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getInitialMarginPostedByTheCounterparty1PostHaircut", aSICMarginReport -> aSICMarginReport.getInitialMarginPostedByTheCounterparty1PostHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getInitialMarginPostedByCounterparty1Currency", aSICMarginReport -> aSICMarginReport.getInitialMarginPostedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(marginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", aSICMarginReport -> aSICMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()).get())
					.setCcy(MapperS.of(marginReport).<ISOCurrencyCodeEnum>map("getInitialMarginPostedByCounterparty1Currency", aSICMarginReport -> aSICMarginReport.getInitialMarginPostedByCounterparty1Currency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.build());
			
			return Optional.ofNullable(postMarginData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
