package drr.regulation.common.emir.reports;

import cdm.base.math.RoundingDirectionEnum;
import cdm.base.math.functions.RoundToPrecision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumAmountRule.OptionPremiumAmountRuleDefault.class)
public abstract class OptionPremiumAmountRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected RoundToPrecision roundToPrecision;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class OptionPremiumAmountRuleDefault extends OptionPremiumAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (exists(MapperS.of(optionPremiumAmountRule.evaluate(thenArg0.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(optionPremiumAmountRule.evaluate(thenArg0.get()));
			} else if (areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractTypeRule.evaluate(thenArg0.get())), CardinalityOperator.Any).getOrDefault(false)) {
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				ifThenElseResult = bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			final MapperS<BigDecimal> thenArg1 = ifThenElseResult
				.mapSingleToItem(item -> MapperS.of(roundToPrecision.evaluate(item.get(), 5, RoundingDirectionEnum.NEAREST, true)));
			output = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
