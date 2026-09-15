package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(SettlementDateFromSettlementTerms.SettlementDateFromSettlementTermsDefault.class)
public abstract class SettlementDateFromSettlementTerms implements RosettaFunction {

	/**
	* @param settlementTerms 
	* @return date 
	*/
	public List<Date> evaluate(SettlementTerms settlementTerms) {
		List<Date> date = doEvaluate(settlementTerms);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(SettlementTerms settlementTerms);

	public static class SettlementDateFromSettlementTermsDefault extends SettlementDateFromSettlementTerms {
		@Override
		protected List<Date> doEvaluate(SettlementTerms settlementTerms) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, settlementTerms);
		}
		
		protected List<Date> assignOutput(List<Date> date, SettlementTerms settlementTerms) {
			date.addAll(MapperS.of(settlementTerms).<SettlementDate>map("getSettlementDate", _settlementTerms -> _settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate()).getMulti());
			
			return date;
		}
	}
}
