package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxEuropeanExercise;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxDigitalOptionToSettlementTerms.MapFxDigitalOptionToSettlementTermsDefault.class)
public abstract class MapFxDigitalOptionToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlFxDigitalOption 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(FxDigitalOption fpmlFxDigitalOption) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlFxDigitalOption);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption);

	protected abstract MapperS<ZonedDateTime> AmericanExercise(FxDigitalOption fpmlFxDigitalOption);

	protected abstract MapperS<ZonedDateTime> EuropeanExercise(FxDigitalOption fpmlFxDigitalOption);

	protected abstract MapperS<ZonedDateTime> settlementDate(FxDigitalOption fpmlFxDigitalOption);

	public static class MapFxDigitalOptionToSettlementTermsDefault extends MapFxDigitalOptionToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(FxDigitalOption fpmlFxDigitalOption) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlFxDigitalOption);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, FxDigitalOption fpmlFxDigitalOption) {
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementDate(SettlementDate.builder()
					.setValueDate(mapZoneDateTimeToDate.evaluate(settlementDate(fpmlFxDigitalOption).get()))
					.build())
				.setSettlementType(null)
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ZonedDateTime> AmericanExercise(FxDigitalOption fpmlFxDigitalOption) {
			return MapperS.of(fpmlFxDigitalOption).<FxDigitalAmericanExercise>map("getAmericanExercise", fxDigitalOption -> fxDigitalOption.getAmericanExercise()).<ZonedDateTime>map("getLatestValueDate", fxDigitalAmericanExercise -> fxDigitalAmericanExercise.getLatestValueDate());
		}
		
		@Override
		protected MapperS<ZonedDateTime> EuropeanExercise(FxDigitalOption fpmlFxDigitalOption) {
			return MapperS.of(fpmlFxDigitalOption).<FxEuropeanExercise>map("getEuropeanExercise", fxDigitalOption -> fxDigitalOption.getEuropeanExercise()).<ZonedDateTime>map("getValueDate", fxEuropeanExercise -> fxEuropeanExercise.getValueDate());
		}
		
		@Override
		protected MapperS<ZonedDateTime> settlementDate(FxDigitalOption fpmlFxDigitalOption) {
			if (exists(EuropeanExercise(fpmlFxDigitalOption)).getOrDefault(false)) {
				return EuropeanExercise(fpmlFxDigitalOption);
			}
			if (exists(AmericanExercise(fpmlFxDigitalOption)).getOrDefault(false)) {
				return AmericanExercise(fpmlFxDigitalOption);
			}
			return MapperS.<ZonedDateTime>ofNull();
		}
	}
}
