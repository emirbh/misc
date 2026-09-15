package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import drr.regulation.common.FinancialSectorEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(GetFinancialCorporateSector.GetFinancialCorporateSectorDefault.class)
public abstract class GetFinancialCorporateSector implements RosettaFunction {

	/**
	* @param financialSector 
	* @return corporateSector 
	*/
	public List<String> evaluate(List<FinancialSectorEnum> financialSector) {
		List<String> corporateSector = doEvaluate(financialSector);
		
		return corporateSector;
	}

	protected abstract List<String> doEvaluate(List<FinancialSectorEnum> financialSector);

	public static class GetFinancialCorporateSectorDefault extends GetFinancialCorporateSector {
		@Override
		protected List<String> doEvaluate(List<FinancialSectorEnum> financialSector) {
			if (financialSector == null) {
				financialSector = Collections.emptyList();
			}
			List<String> corporateSector = new ArrayList<>();
			return assignOutput(corporateSector, financialSector);
		}
		
		protected List<String> assignOutput(List<String> corporateSector, List<FinancialSectorEnum> financialSector) {
			corporateSector.addAll(MapperC.<FinancialSectorEnum>of(financialSector)
				.mapItem(item -> item.map("to-string", FinancialSectorEnum::toDisplayString)).getMulti());
			
			return corporateSector;
		}
	}
}
