package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ConfirmationEnum;
import iso20022.auth030.jfsa.TradeConfirmation4Choice;
import iso20022.auth030.jfsa.TradeConfirmation5;
import iso20022.auth030.jfsa.TradeConfirmationType1Code;
import iso20022.auth030.jfsa.TradeConfirmationType2Code;
import iso20022.auth030.jfsa.TradeNonConfirmation1;
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
	public TradeConfirmation4Choice evaluate(JFSATransactionReport drrReport) {
		TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder tradConfBuilder = doEvaluate(drrReport);
		
		final TradeConfirmation4Choice tradConf;
		if (tradConfBuilder == null) {
			tradConf = null;
		} else {
			tradConf = tradConfBuilder.build();
			objectValidator.validate(TradeConfirmation4Choice.class, tradConf);
		}
		
		return tradConf;
	}

	protected abstract TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder doEvaluate(JFSATransactionReport drrReport);

	public static class GetTradConfDefault extends GetTradConf {
		@Override
		protected TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder doEvaluate(JFSATransactionReport drrReport) {
			TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder tradConf = TradeConfirmation4Choice.builder();
			return assignOutput(tradConf, drrReport);
		}
		
		protected TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder assignOutput(TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder tradConf, JFSATransactionReport drrReport) {
			ZonedDateTime ifThenElseResult0 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", jFSATransactionReport -> jFSATransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<ZonedDateTime>map("getConfirmationTimestamp", jFSATransactionReport -> jFSATransactionReport.getConfirmationTimestamp()).get();
			}
			TradeConfirmationType1Code ifThenElseResult1 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", jFSATransactionReport -> jFSATransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", jFSATransactionReport -> jFSATransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			TradeConfirmationType2Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", jFSATransactionReport -> jFSATransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", jFSATransactionReport -> jFSATransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			tradConf = toBuilder(TradeConfirmation4Choice.builder()
				.setConfd(TradeConfirmation5.builder()
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
