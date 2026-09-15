package drr.enrichment.upi.functions;

import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TranslatePeriodEnum.TranslatePeriodEnumDefault.class)
public abstract class TranslatePeriodEnum implements RosettaFunction {

	/**
	* @param period 
	* @return value 
	*/
	public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum evaluate(PeriodEnum period) {
		AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value = doEvaluate(period);
		
		return value;
	}

	protected abstract AnnaDsbUnderlyingInstrumentIndexTermUnitEnum doEvaluate(PeriodEnum period);

	public static class TranslatePeriodEnumDefault extends TranslatePeriodEnum {
		@Override
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum doEvaluate(PeriodEnum period) {
			AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value = null;
			return assignOutput(value, period);
		}
		
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum assignOutput(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value, PeriodEnum period) {
			if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.D), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.DAYS;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.W), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.WEEK;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.M), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.MNTH;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR;
			} else {
				value = null;
			}
			
			return value;
		}
	}
}
