package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Compute_NotionalScheduleType.Compute_NotionalScheduleTypeDefault.class)
public abstract class Compute_NotionalScheduleType implements RosettaFunction {

	/**
	* @param values 
	* @return scheduleType 
	*/
	public AnnaDsbNotionalScheduleEnum evaluate(List<BigDecimal> values) {
		AnnaDsbNotionalScheduleEnum scheduleType = doEvaluate(values);
		
		return scheduleType;
	}

	protected abstract AnnaDsbNotionalScheduleEnum doEvaluate(List<BigDecimal> values);

	public static class Compute_NotionalScheduleTypeDefault extends Compute_NotionalScheduleType {
		@Override
		protected AnnaDsbNotionalScheduleEnum doEvaluate(List<BigDecimal> values) {
			if (values == null) {
				values = Collections.emptyList();
			}
			AnnaDsbNotionalScheduleEnum scheduleType = null;
			return assignOutput(scheduleType, values);
		}
		
		protected AnnaDsbNotionalScheduleEnum assignOutput(AnnaDsbNotionalScheduleEnum scheduleType, List<BigDecimal> values) {
			if (notExists(MapperC.<BigDecimal>of(values)).getOrDefault(false)) {
				scheduleType = AnnaDsbNotionalScheduleEnum.CONSTANT;
			} else {
				scheduleType = null;
			}
			
			return scheduleType;
		}
	}
}
