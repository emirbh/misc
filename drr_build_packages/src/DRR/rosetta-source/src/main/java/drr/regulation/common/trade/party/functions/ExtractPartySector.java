package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.FinancialSectorEnum;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.functions.GetFinancialCorporateSector;
import drr.regulation.common.functions.GetNonFinancialCorporateSector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractPartySector.ExtractPartySectorDefault.class)
public abstract class ExtractPartySector implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFinancialCorporateSector getFinancialCorporateSector;
	@Inject protected GetNonFinancialCorporateSector getNonFinancialCorporateSector;

	/**
	* @param natureOfParty 
	* @param corporateSector 
	* @return sector 
	*/
	public List<String> evaluate(NatureOfPartyEnum natureOfParty, List<? extends CorporateSector> corporateSector) {
		List<String> sector = doEvaluate(natureOfParty, corporateSector);
		
		return sector;
	}

	protected abstract List<String> doEvaluate(NatureOfPartyEnum natureOfParty, List<? extends CorporateSector> corporateSector);

	public static class ExtractPartySectorDefault extends ExtractPartySector {
		@Override
		protected List<String> doEvaluate(NatureOfPartyEnum natureOfParty, List<? extends CorporateSector> corporateSector) {
			if (corporateSector == null) {
				corporateSector = Collections.emptyList();
			}
			List<String> sector = new ArrayList<>();
			return assignOutput(sector, natureOfParty, corporateSector);
		}
		
		protected List<String> assignOutput(List<String> sector, NatureOfPartyEnum natureOfParty, List<? extends CorporateSector> corporateSector) {
			if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
				sector = getNonFinancialCorporateSector.evaluate(MapperC.<CorporateSector>of(corporateSector).<NonFinancialSector>mapC("getNonFinancialSector", _corporateSector -> _corporateSector.getNonFinancialSector()).getMulti());
			} else if (areEqual(MapperS.of(natureOfParty), MapperS.of(NatureOfPartyEnum.FINANCIAL), CardinalityOperator.All).getOrDefault(false)) {
				sector = getFinancialCorporateSector.evaluate(MapperC.<CorporateSector>of(corporateSector).<FinancialSectorEnum>mapC("getFinancialSector", _corporateSector -> _corporateSector.getFinancialSector()).getMulti());
			} else {
				sector = Collections.<String>emptyList();
			}
			
			return sector;
		}
	}
}
