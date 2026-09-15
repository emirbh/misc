package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.link.functions.PackageInformation;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageTransactionPriceRule.PackageTransactionPriceRuleDefault.class)
public abstract class PackageTransactionPriceRule implements ReportFunction<TransactionReportInstructionBase, Price> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PackageInformation packageInformation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Price evaluate(TransactionReportInstructionBase input) {
		Price.PriceBuilder outputBuilder = doEvaluate(input);
		
		final Price output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(Price.class, output);
		}
		
		return output;
	}

	protected abstract Price.PriceBuilder doEvaluate(TransactionReportInstructionBase input);

	public static class PackageTransactionPriceRuleDefault extends PackageTransactionPriceRule {
		@Override
		protected Price.PriceBuilder doEvaluate(TransactionReportInstructionBase input) {
			Price.PriceBuilder output = Price.builder();
			return assignOutput(output, input);
		}
		
		protected Price.PriceBuilder assignOutput(Price.PriceBuilder output, TransactionReportInstructionBase input) {
			final MapperS<Price> thenArg = MapperS.of(packageInformation.evaluate(input)).<Price>map("getPrice", identifiedList -> identifiedList.getPrice());
			output = toBuilder(thenArg
				.mapSingleToItem(item -> {
					if (notExists(item.<ArithmeticOperationEnum>map("getArithmeticOperator", price -> price.getArithmeticOperator())).getOrDefault(false)) {
						return item;
					}
					return MapperS.<Price>ofNull();
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
