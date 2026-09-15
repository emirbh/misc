package drr.enrichment.common.valuation.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeReportableValuation;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.ValuationDetails;
import drr.standards.iso.ReportLevelEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_RegimeReportableValuation.Create_RegimeReportableValuationDefault.class)
public abstract class Create_RegimeReportableValuation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableValuation 
	* @param regimeReportingSide 
	* @return regimeReportableValuation 
	*/
	public RegimeReportableValuation evaluate(ReportableValuation reportableValuation, List<? extends RegimeReportingSide> regimeReportingSide) {
		RegimeReportableValuation.RegimeReportableValuationBuilder regimeReportableValuationBuilder = doEvaluate(reportableValuation, regimeReportingSide);
		
		final RegimeReportableValuation regimeReportableValuation;
		if (regimeReportableValuationBuilder == null) {
			regimeReportableValuation = null;
		} else {
			regimeReportableValuation = regimeReportableValuationBuilder.build();
			objectValidator.validate(RegimeReportableValuation.class, regimeReportableValuation);
		}
		
		return regimeReportableValuation;
	}

	protected abstract RegimeReportableValuation.RegimeReportableValuationBuilder doEvaluate(ReportableValuation reportableValuation, List<? extends RegimeReportingSide> regimeReportingSide);

	public static class Create_RegimeReportableValuationDefault extends Create_RegimeReportableValuation {
		@Override
		protected RegimeReportableValuation.RegimeReportableValuationBuilder doEvaluate(ReportableValuation reportableValuation, List<? extends RegimeReportingSide> regimeReportingSide) {
			if (regimeReportingSide == null) {
				regimeReportingSide = Collections.emptyList();
			}
			RegimeReportableValuation.RegimeReportableValuationBuilder regimeReportableValuation = RegimeReportableValuation.builder();
			return assignOutput(regimeReportableValuation, reportableValuation, regimeReportingSide);
		}
		
		protected RegimeReportableValuation.RegimeReportableValuationBuilder assignOutput(RegimeReportableValuation.RegimeReportableValuationBuilder regimeReportableValuation, ReportableValuation reportableValuation, List<? extends RegimeReportingSide> regimeReportingSide) {
			regimeReportableValuation = toBuilder(RegimeReportableValuation.builder()
				.setValuationDetails(MapperS.of(reportableValuation).<ValuationDetails>map("getValuationDetails", _reportableValuation -> _reportableValuation.getValuationDetails()).get())
				.setReportableInformation(MapperS.of(reportableValuation).<ReportableInformation>map("getReportableInformation", _reportableValuation -> _reportableValuation.getReportableInformation()).get())
				.setCollateralDetails(MapperS.of(reportableValuation).<Collateral>map("getCollateralDetails", _reportableValuation -> _reportableValuation.getCollateralDetails()).get())
				.setRegimeReportingSide(new ArrayList(regimeReportingSide))
				.setEventIdentifier(MapperS.of(reportableValuation).<Identifier>mapC("getEventIdentifier", _reportableValuation -> _reportableValuation.getEventIdentifier()).getMulti())
				.setLevel(MapperS.of(reportableValuation).<ReportLevelEnum>map("getLevel", _reportableValuation -> _reportableValuation.getLevel()).get())
				.build());
			
			return Optional.ofNullable(regimeReportableValuation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
