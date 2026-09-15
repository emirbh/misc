package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.math.Rounding;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.RoundingDirectionEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFinalRateRounding.MapFinalRateRoundingDefault.class)
public abstract class MapFinalRateRounding implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlRounding 
	* @return rounding 
	*/
	public Rounding evaluate(fpml.consolidated.shared.Rounding fpmlRounding) {
		Rounding.RoundingBuilder roundingBuilder = doEvaluate(fpmlRounding);
		
		final Rounding rounding;
		if (roundingBuilder == null) {
			rounding = null;
		} else {
			rounding = roundingBuilder.build();
			objectValidator.validate(Rounding.class, rounding);
		}
		
		return rounding;
	}

	protected abstract Rounding.RoundingBuilder doEvaluate(fpml.consolidated.shared.Rounding fpmlRounding);

	public static class MapFinalRateRoundingDefault extends MapFinalRateRounding {
		@Override
		protected Rounding.RoundingBuilder doEvaluate(fpml.consolidated.shared.Rounding fpmlRounding) {
			Rounding.RoundingBuilder rounding = Rounding.builder();
			return assignOutput(rounding, fpmlRounding);
		}
		
		protected Rounding.RoundingBuilder assignOutput(Rounding.RoundingBuilder rounding, fpml.consolidated.shared.Rounding fpmlRounding) {
			if (exists(MapperS.of(fpmlRounding)).getOrDefault(false)) {
				rounding = toBuilder(Rounding.builder()
					.setRoundingDirection(MapperS.of(fpmlRounding).<RoundingDirectionEnum>map("getRoundingDirection", _rounding -> _rounding.getRoundingDirection()).checkedMap("to-enum", e -> cdm.base.math.RoundingDirectionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setPrecision(MapperS.of(fpmlRounding).<Integer>map("getPrecision", _rounding -> _rounding.getPrecision()).get())
					.build());
			} else {
				rounding = null;
			}
			
			return Optional.ofNullable(rounding)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
