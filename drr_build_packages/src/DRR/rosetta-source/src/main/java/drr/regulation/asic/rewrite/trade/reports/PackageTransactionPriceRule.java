package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.link.reports.PackageIdentifierRule;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionPriceNotationEnumRule;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionPriceValueRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageTransactionPriceRule.PackageTransactionPriceRuleDefault.class)
public abstract class PackageTransactionPriceRule implements ReportFunction<TransactionReportInstruction, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected PackageTransactionPriceNotationEnumRule packageTransactionPriceNotationEnumRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceValueRule packageTransactionPriceValueRule;
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

	public static class PackageTransactionPriceRuleDefault extends PackageTransactionPriceRule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToItem(item -> {
					final String string = packageIdentifierRule.evaluate(item.get());
					final BigDecimal ifThenElseResult;
					if ((string == null ? exists(MapperS.<FieldWithMetaString>ofNull()) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string).build()))).andNullSafe(notExists(MapperS.of(packageTransactionPriceNotationEnumRule.evaluate(item.get())))).getOrDefault(false)) {
						ifThenElseResult = BigDecimal.valueOf(99999999999l);
					} else {
						ifThenElseResult = packageTransactionPriceValueRule.evaluate(item.get());
					}
					return MapperS.of(priceFormatFromNotation.evaluate(ifThenElseResult, packageTransactionPriceNotationRule.evaluate(item.get())));
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
