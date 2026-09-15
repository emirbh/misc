package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.standards.iso.DurationType1Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetDurationCodeFromCommodityTimeUnit.GetDurationCodeFromCommodityTimeUnitDefault.class)
public abstract class GetDurationCodeFromCommodityTimeUnit implements RosettaFunction {

	/**
	* @param timeUnit 
	* @return duration 
	*/
	public DurationType1Code evaluate(CommodityTimeUnitEnum timeUnit) {
		DurationType1Code duration = doEvaluate(timeUnit);
		
		return duration;
	}

	protected abstract DurationType1Code doEvaluate(CommodityTimeUnitEnum timeUnit);

	public static class GetDurationCodeFromCommodityTimeUnitDefault extends GetDurationCodeFromCommodityTimeUnit {
		@Override
		protected DurationType1Code doEvaluate(CommodityTimeUnitEnum timeUnit) {
			DurationType1Code duration = null;
			return assignOutput(duration, timeUnit);
		}
		
		protected DurationType1Code assignOutput(DurationType1Code duration, CommodityTimeUnitEnum timeUnit) {
			if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.MINUTE), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.MNUT;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.HOUR), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.HOUR;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.DAY), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.DASD;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.WEEK), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.WEEK;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.MONTH), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.MNTH;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.QUARTER), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.QURT;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.SEASON), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.SEAS;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.YEAR), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.YEAR;
			} else if (areEqual(MapperS.of(timeUnit), MapperS.of(CommodityTimeUnitEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				duration = DurationType1Code.OTHR;
			} else {
				duration = null;
			}
			
			return duration;
		}
	}
}
