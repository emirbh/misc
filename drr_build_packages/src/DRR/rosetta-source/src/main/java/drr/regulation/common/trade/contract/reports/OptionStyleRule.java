package drr.regulation.common.trade.contract.reports;

import cdm.product.template.AveragingCalculation;
import cdm.product.template.AveragingStrikeFeature;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCap;
import drr.base.qualification.product.functions.IsFloor;
import drr.base.qualification.product.functions.IsOption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.OptionStyleEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionStyleRule.OptionStyleRuleDefault.class)
public abstract class OptionStyleRule implements ReportFunction<TransactionReportInstruction, OptionStyleEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCap isCap;
	@Inject protected IsFloor isFloor;
	@Inject protected IsOption isOption;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionStyleEnum evaluate(TransactionReportInstruction input) {
		OptionStyleEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionStyleEnum doEvaluate(TransactionReportInstruction input);

	public static class OptionStyleRuleDefault extends OptionStyleRule {
		@Override
		protected OptionStyleEnum doEvaluate(TransactionReportInstruction input) {
			OptionStyleEnum output = null;
			return assignOutput(output, input);
		}
		
		protected OptionStyleEnum assignOutput(OptionStyleEnum output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<AveragingStrikeFeature>map("getAveragingStrikeFeature", optionStrike -> optionStrike.getAveragingStrikeFeature())).orNullSafe(exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature()).<AveragingCalculation>map("getAveragingFeature", optionFeature -> optionFeature.getAveragingFeature()))).getOrDefault(false)) {
						return MapperS.of(OptionStyleEnum.ASIA);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(isFloor.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCap.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(OptionStyleEnum.EURO);
					}
					final Boolean _boolean = isOption.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle())
							.mapSingleToItem(_item -> {
								if (areEqual(_item, MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).getOrDefault(false)) {
									return MapperS.of(OptionStyleEnum.AMER);
								}
								if (areEqual(_item, MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).getOrDefault(false)) {
									return MapperS.of(OptionStyleEnum.EURO);
								}
								if (areEqual(_item, MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
									return MapperS.of(OptionStyleEnum.BERM);
								}
								return MapperS.<OptionStyleEnum>ofNull();
							});
					}
					return MapperS.<OptionStyleEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
