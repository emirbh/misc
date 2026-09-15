package drr.enrichment.common.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.RegimeReportableCollateral;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.ReportableCollateral;
import drr.regulation.common.ReportableInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_RegimeReportableCollateral.Create_RegimeReportableCollateralDefault.class)
public abstract class Create_RegimeReportableCollateral implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableCollateral 
	* @param regimeReportingSide 
	* @return regimeReportableCollateral 
	*/
	public RegimeReportableCollateral evaluate(ReportableCollateral reportableCollateral, List<? extends RegimeReportingSide> regimeReportingSide) {
		RegimeReportableCollateral.RegimeReportableCollateralBuilder regimeReportableCollateralBuilder = doEvaluate(reportableCollateral, regimeReportingSide);
		
		final RegimeReportableCollateral regimeReportableCollateral;
		if (regimeReportableCollateralBuilder == null) {
			regimeReportableCollateral = null;
		} else {
			regimeReportableCollateral = regimeReportableCollateralBuilder.build();
			objectValidator.validate(RegimeReportableCollateral.class, regimeReportableCollateral);
		}
		
		return regimeReportableCollateral;
	}

	protected abstract RegimeReportableCollateral.RegimeReportableCollateralBuilder doEvaluate(ReportableCollateral reportableCollateral, List<? extends RegimeReportingSide> regimeReportingSide);

	public static class Create_RegimeReportableCollateralDefault extends Create_RegimeReportableCollateral {
		@Override
		protected RegimeReportableCollateral.RegimeReportableCollateralBuilder doEvaluate(ReportableCollateral reportableCollateral, List<? extends RegimeReportingSide> regimeReportingSide) {
			if (regimeReportingSide == null) {
				regimeReportingSide = Collections.emptyList();
			}
			RegimeReportableCollateral.RegimeReportableCollateralBuilder regimeReportableCollateral = RegimeReportableCollateral.builder();
			return assignOutput(regimeReportableCollateral, reportableCollateral, regimeReportingSide);
		}
		
		protected RegimeReportableCollateral.RegimeReportableCollateralBuilder assignOutput(RegimeReportableCollateral.RegimeReportableCollateralBuilder regimeReportableCollateral, ReportableCollateral reportableCollateral, List<? extends RegimeReportingSide> regimeReportingSide) {
			regimeReportableCollateral = toBuilder(RegimeReportableCollateral.builder()
				.setCollateralDetails(MapperS.of(reportableCollateral).<CollateralDetails>map("getCollateralDetails", _reportableCollateral -> _reportableCollateral.getCollateralDetails()).get())
				.setReportableInformation(MapperS.of(reportableCollateral).<ReportableInformation>map("getReportableInformation", _reportableCollateral -> _reportableCollateral.getReportableInformation()).get())
				.setRegimeReportingSide(new ArrayList(regimeReportingSide))
				.build());
			
			return Optional.ofNullable(regimeReportableCollateral)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
