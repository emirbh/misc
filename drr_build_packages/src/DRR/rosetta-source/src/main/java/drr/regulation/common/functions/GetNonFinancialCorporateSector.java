package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.NonFinancialSectorEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(GetNonFinancialCorporateSector.GetNonFinancialCorporateSectorDefault.class)
public abstract class GetNonFinancialCorporateSector implements RosettaFunction {

	/**
	* @param nonFinancialSector 
	* @return corporateSector 
	*/
	public List<String> evaluate(List<? extends NonFinancialSector> nonFinancialSector) {
		List<String> corporateSector = doEvaluate(nonFinancialSector);
		
		return corporateSector;
	}

	protected abstract List<String> doEvaluate(List<? extends NonFinancialSector> nonFinancialSector);

	public static class GetNonFinancialCorporateSectorDefault extends GetNonFinancialCorporateSector {
		@Override
		protected List<String> doEvaluate(List<? extends NonFinancialSector> nonFinancialSector) {
			if (nonFinancialSector == null) {
				nonFinancialSector = Collections.emptyList();
			}
			List<String> corporateSector = new ArrayList<>();
			return assignOutput(corporateSector, nonFinancialSector);
		}
		
		protected List<String> assignOutput(List<String> corporateSector, List<? extends NonFinancialSector> nonFinancialSector) {
			corporateSector.addAll(MapperC.<NonFinancialSector>of(nonFinancialSector)
				.mapItem(item -> item.<NonFinancialSectorEnum>map("getNonFinancialSectorIndicator", _nonFinancialSector -> _nonFinancialSector.getNonFinancialSectorIndicator()).map("to-string", NonFinancialSectorEnum::toDisplayString)).getMulti());
			
			return corporateSector;
		}
	}
}
