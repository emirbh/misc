package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.MandatorilyClearableEnum;
import fpml.consolidated.doc.ReportingBoolean;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMandatorilyClearableEnum.MapMandatorilyClearableEnumDefault.class)
public abstract class MapMandatorilyClearableEnum implements RosettaFunction {

	/**
	* @param mandatorilyClearable 
	* @return mandatorilyClearableEnum 
	*/
	public MandatorilyClearableEnum evaluate(ReportingBoolean mandatorilyClearable) {
		MandatorilyClearableEnum mandatorilyClearableEnum = doEvaluate(mandatorilyClearable);
		
		return mandatorilyClearableEnum;
	}

	protected abstract MandatorilyClearableEnum doEvaluate(ReportingBoolean mandatorilyClearable);

	public static class MapMandatorilyClearableEnumDefault extends MapMandatorilyClearableEnum {
		@Override
		protected MandatorilyClearableEnum doEvaluate(ReportingBoolean mandatorilyClearable) {
			MandatorilyClearableEnum mandatorilyClearableEnum = null;
			return assignOutput(mandatorilyClearableEnum, mandatorilyClearable);
		}
		
		protected MandatorilyClearableEnum assignOutput(MandatorilyClearableEnum mandatorilyClearableEnum, ReportingBoolean mandatorilyClearable) {
			final MapperS<String> switchArgument = MapperS.of(mandatorilyClearable).<String>map("getValue", reportingBoolean -> reportingBoolean.getValue());
			if (switchArgument.get() == null) {
				mandatorilyClearableEnum = null;
			} else if (areEqual(switchArgument, MapperS.of("true"), CardinalityOperator.All).get()) {
				mandatorilyClearableEnum = MandatorilyClearableEnum.PRODUCT_AND_CPTY_MANDATORY;
			} else if (areEqual(switchArgument, MapperS.of("false"), CardinalityOperator.All).get()) {
				mandatorilyClearableEnum = MandatorilyClearableEnum.PRODUCT_MANDATORY_BUT_NOT_CPTY;
			} else if (areEqual(switchArgument, MapperS.of("X"), CardinalityOperator.All).get()) {
				mandatorilyClearableEnum = MandatorilyClearableEnum.PRODUCT_NOT_MANDATORY;
			} else {
				mandatorilyClearableEnum = null;
			}
			
			return mandatorilyClearableEnum;
		}
	}
}
