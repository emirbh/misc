package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iosco.cde.version3.price.functions.GetReportablePricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(ContractPriceScheduleRule.ContractPriceScheduleRuleDefault.class)
public abstract class ContractPriceScheduleRule implements ReportFunction<TransactionReportInstruction, List<? extends PricePeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetReportablePricePeriod getReportablePricePeriod;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends PricePeriod> evaluate(TransactionReportInstruction input) {
		List<PricePeriod.PricePeriodBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends PricePeriod> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, output);
		}
		
		return output;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstruction input);

	public static class ContractPriceScheduleRuleDefault extends ContractPriceScheduleRule {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstruction input) {
			List<PricePeriod.PricePeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).get());
			output = toBuilder(thenArg1
				.mapSingleToList(item -> MapperC.<PricePeriod>of(getReportablePricePeriod.evaluate(item.get(), DefaultingType.DEFAULT_PERCENTAGETO_DECIMAL))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
