package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ConfirmationEnum;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import iso20022.auth030.fca.TradeConfirmation2;
import iso20022.auth030.fca.TradeConfirmationType1Code;
import iso20022.auth030.fca.TradeConfirmationType2Code;
import iso20022.auth030.fca.TradeNonConfirmation1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTradConf.GetTradConfDefault.class)
public abstract class GetTradConf implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return tradConf 
	*/
	public TradeConfirmation1Choice evaluate(FCAUKEMIRTransactionReport drrReport) {
		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder tradConfBuilder = doEvaluate(drrReport);
		
		final TradeConfirmation1Choice tradConf;
		if (tradConfBuilder == null) {
			tradConf = null;
		} else {
			tradConf = tradConfBuilder.build();
			objectValidator.validate(TradeConfirmation1Choice.class, tradConf);
		}
		
		return tradConf;
	}

	protected abstract TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetTradConfDefault extends GetTradConf {
		@Override
		protected TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder tradConf = TradeConfirmation1Choice.builder();
			return assignOutput(tradConf, drrReport);
		}
		
		protected TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder assignOutput(TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder tradConf, FCAUKEMIRTransactionReport drrReport) {
			ZonedDateTime ifThenElseResult0 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<ZonedDateTime>map("getConfirmationTimestamp", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmationTimestamp()).get();
			}
			TradeConfirmationType1Code ifThenElseResult1 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			TradeConfirmationType2Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			tradConf = toBuilder(TradeConfirmation1Choice.builder()
				.setConfd(TradeConfirmation2.builder()
					.setTmStmp(ifThenElseResult0)
					.setTp(ifThenElseResult1)
					.build())
				.setNonConfd(TradeNonConfirmation1.builder()
					.setTp(ifThenElseResult2)
					.build())
				.build());
			
			return Optional.ofNullable(tradConf)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
