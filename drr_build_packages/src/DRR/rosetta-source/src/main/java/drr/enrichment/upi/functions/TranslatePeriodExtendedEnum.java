package drr.enrichment.upi.functions;

import cdm.base.datetime.PeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TranslatePeriodExtendedEnum.TranslatePeriodExtendedEnumDefault.class)
public abstract class TranslatePeriodExtendedEnum implements RosettaFunction {

	/**
	* @param period 
	* @return value 
	*/
	public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum evaluate(PeriodExtendedEnum period) {
		AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value = doEvaluate(period);
		
		return value;
	}

	protected abstract AnnaDsbUnderlyingInstrumentIndexTermUnitEnum doEvaluate(PeriodExtendedEnum period);

	public static class TranslatePeriodExtendedEnumDefault extends TranslatePeriodExtendedEnum {
		@Override
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum doEvaluate(PeriodExtendedEnum period) {
			AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value = null;
			return assignOutput(value, period);
		}
		
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum assignOutput(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum value, PeriodExtendedEnum period) {
			if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.DAYS;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.W), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.WEEK;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.M), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.MNTH;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				value = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR;
			} else {
				value = null;
			}
			
			return value;
		}
	}
}
