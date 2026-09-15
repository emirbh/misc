package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionSpreadValueRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageTransactionSpreadRule.PackageTransactionSpreadRuleDefault.class)
public abstract class PackageTransactionSpreadRule implements ReportFunction<TransactionReportInstruction, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PackageTransactionSpreadValueRule packageTransactionSpreadValueRule;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceFormat evaluate(TransactionReportInstruction input) {
		PriceFormat.PriceFormatBuilder outputBuilder = doEvaluate(input);
		
		final PriceFormat output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceFormat.class, output);
		}
		
		return output;
	}

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input);

	public static class PackageTransactionSpreadRuleDefault extends PackageTransactionSpreadRule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(packageTransactionSpreadValueRule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(priceFormatFromNotation.evaluate(packageTransactionSpreadValueRule.evaluate(item.get()), packageTransactionSpreadNotationRule.evaluate(item.get())));
					}
					if (areEqual(MapperS.of(packageTransactionSpreadNotationRule.evaluate(item.get())), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PriceFormat.builder()
							.setMonetary(new BigDecimal("99999.9999999999999"))
							.build());
					}
					if (areEqual(MapperS.of(packageTransactionSpreadNotationRule.evaluate(item.get())), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PriceFormat.builder()
							.setDecimal(new BigDecimal("9.9999999999"))
							.build());
					}
					if (areEqual(MapperS.of(packageTransactionSpreadNotationRule.evaluate(item.get())), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PriceFormat.builder()
							.setBasis(BigDecimal.valueOf(99999))
							.build());
					}
					return MapperS.<PriceFormat>ofNull();
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
