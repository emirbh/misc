package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.SupervisoryBody;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsReportingRegimeMatching.IsReportingRegimeMatchingDefault.class)
public abstract class IsReportingRegimeMatching implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRegimeNameEnum mapRegimeNameEnum;

	/**
	* @param fpmlReportingRegime 
	* @param regimeName 
	* @param supervisoryBodyValue 
	* @return matches 
	*/
	public Boolean evaluate(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue) {
		Boolean matches = doEvaluate(fpmlReportingRegime, regimeName, supervisoryBodyValue);
		
		return matches;
	}

	protected abstract Boolean doEvaluate(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue);

	protected abstract MapperS<RegimeNameEnum> currentRegimeName(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue);

	protected abstract MapperS<SupervisoryBodyEnum> currentSupervisoryBodyValue(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue);

	public static class IsReportingRegimeMatchingDefault extends IsReportingRegimeMatching {
		@Override
		protected Boolean doEvaluate(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue) {
			Boolean matches = null;
			return assignOutput(matches, fpmlReportingRegime, regimeName, supervisoryBodyValue);
		}
		
		protected Boolean assignOutput(Boolean matches, ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue) {
			if (exists(MapperS.of(supervisoryBodyValue)).andNullSafe(exists(currentSupervisoryBodyValue(fpmlReportingRegime, regimeName, supervisoryBodyValue))).andNullSafe(exists(currentRegimeName(fpmlReportingRegime, regimeName, supervisoryBodyValue))).andNullSafe(exists(MapperS.of(regimeName))).getOrDefault(false)) {
				matches = areEqual(currentRegimeName(fpmlReportingRegime, regimeName, supervisoryBodyValue), MapperS.of(regimeName), CardinalityOperator.All).andNullSafe(areEqual(currentSupervisoryBodyValue(fpmlReportingRegime, regimeName, supervisoryBodyValue), MapperS.of(supervisoryBodyValue), CardinalityOperator.All)).get();
			} else if (exists(MapperS.of(supervisoryBodyValue)).andNullSafe(exists(currentSupervisoryBodyValue(fpmlReportingRegime, regimeName, supervisoryBodyValue))).getOrDefault(false)) {
				matches = areEqual(currentSupervisoryBodyValue(fpmlReportingRegime, regimeName, supervisoryBodyValue), MapperS.of(supervisoryBodyValue), CardinalityOperator.All).get();
			} else {
				matches = areEqual(currentRegimeName(fpmlReportingRegime, regimeName, supervisoryBodyValue), MapperS.of(regimeName), CardinalityOperator.All).get();
			}
			
			return matches;
		}
		
		@Override
		protected MapperS<RegimeNameEnum> currentRegimeName(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue) {
			return MapperS.of(mapRegimeNameEnum.evaluate(MapperS.of(fpmlReportingRegime).<ReportingRegimeName>map("getName", reportingRegime -> reportingRegime.getName()).get()));
		}
		
		@Override
		protected MapperS<SupervisoryBodyEnum> currentSupervisoryBodyValue(ReportingRegime fpmlReportingRegime, RegimeNameEnum regimeName, SupervisoryBodyEnum supervisoryBodyValue) {
			return MapperS.of(fpmlReportingRegime).<SupervisorRegistration>mapC("getSupervisorRegistration", reportingRegime -> reportingRegime.getSupervisorRegistration()).<SupervisoryBody>map("getSupervisoryBody", supervisorRegistration -> supervisorRegistration.getSupervisoryBody()).<String>map("getValue", supervisoryBody -> supervisoryBody.getValue())
				.first().checkedMap("to-enum", SupervisoryBodyEnum::fromDisplayName, IllegalArgumentException.class);
		}
	}
}
