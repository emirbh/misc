package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import fpml.consolidated.shared.ReportingRegimeName;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapRegimeNameEnum.MapRegimeNameEnumDefault.class)
public abstract class MapRegimeNameEnum implements RosettaFunction {

	/**
	* @param reportingRegimeName 
	* @return regimeNameEnum 
	*/
	public RegimeNameEnum evaluate(ReportingRegimeName reportingRegimeName) {
		RegimeNameEnum regimeNameEnum = doEvaluate(reportingRegimeName);
		
		return regimeNameEnum;
	}

	protected abstract RegimeNameEnum doEvaluate(ReportingRegimeName reportingRegimeName);

	public static class MapRegimeNameEnumDefault extends MapRegimeNameEnum {
		@Override
		protected RegimeNameEnum doEvaluate(ReportingRegimeName reportingRegimeName) {
			RegimeNameEnum regimeNameEnum = null;
			return assignOutput(regimeNameEnum, reportingRegimeName);
		}
		
		protected RegimeNameEnum assignOutput(RegimeNameEnum regimeNameEnum, ReportingRegimeName reportingRegimeName) {
			final MapperS<String> switchArgument = MapperS.of(reportingRegimeName).<String>map("getValue", _reportingRegimeName -> _reportingRegimeName.getValue());
			if (switchArgument.get() == null) {
				regimeNameEnum = null;
			} else if (areEqual(switchArgument, MapperS.of("CA.Rule.91-507"), CardinalityOperator.All).get()) {
				regimeNameEnum = RegimeNameEnum.CSA;
			} else if (areEqual(switchArgument, MapperS.of("HKTR"), CardinalityOperator.All).get()) {
				regimeNameEnum = RegimeNameEnum.HKMA;
			} else {
				regimeNameEnum = MapperS.of(reportingRegimeName).<String>map("getValue", _reportingRegimeName -> _reportingRegimeName.getValue()).checkedMap("to-enum", RegimeNameEnum::fromDisplayName, IllegalArgumentException.class).get();
			}
			
			return regimeNameEnum;
		}
	}
}
