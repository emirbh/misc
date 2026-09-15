package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ConfirmationEnum;
import iso20022.auth030.mas.TradeConfirmation4Choice__1;
import iso20022.auth030.mas.TradeConfirmation5__1;
import iso20022.auth030.mas.TradeConfirmationType1Code;
import iso20022.auth030.mas.TradeConfirmationType2Code;
import iso20022.auth030.mas.TradeNonConfirmation1;
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
	public TradeConfirmation4Choice__1 evaluate(MASTransactionReport drrReport) {
		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder tradConfBuilder = doEvaluate(drrReport);
		
		final TradeConfirmation4Choice__1 tradConf;
		if (tradConfBuilder == null) {
			tradConf = null;
		} else {
			tradConf = tradConfBuilder.build();
			objectValidator.validate(TradeConfirmation4Choice__1.class, tradConf);
		}
		
		return tradConf;
	}

	protected abstract TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class GetTradConfDefault extends GetTradConf {
		@Override
		protected TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder doEvaluate(MASTransactionReport drrReport) {
			TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder tradConf = TradeConfirmation4Choice__1.builder();
			return assignOutput(tradConf, drrReport);
		}
		
		protected TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder assignOutput(TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder tradConf, MASTransactionReport drrReport) {
			ZonedDateTime ifThenElseResult0 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", mASTransactionReport -> mASTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<ZonedDateTime>map("getConfirmationTimestamp", mASTransactionReport -> mASTransactionReport.getConfirmationTimestamp()).get();
			}
			TradeConfirmationType1Code ifThenElseResult1 = null;
			if (notEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", mASTransactionReport -> mASTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", mASTransactionReport -> mASTransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			TradeConfirmationType2Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", mASTransactionReport -> mASTransactionReport.getConfirmed()), MapperS.of(ConfirmationEnum.NCNF), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<ConfirmationEnum>map("getConfirmed", mASTransactionReport -> mASTransactionReport.getConfirmed()).checkedMap("to-enum", e -> TradeConfirmationType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			tradConf = toBuilder(TradeConfirmation4Choice__1.builder()
				.setConfd(TradeConfirmation5__1.builder()
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
