package drr.standards.iosco.cde.version1.execution.functions;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(ForwardSettlementDate.ForwardSettlementDateDefault.class)
public abstract class ForwardSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SettlementDateFromSettlementTerms settlementDateFromSettlementTerms;

	/**
	* @param forwardPayout 
	* @return forwardDate 
	*/
	public List<Date> evaluate(SettlementPayout forwardPayout) {
		List<Date> forwardDate = doEvaluate(forwardPayout);
		
		return forwardDate;
	}

	protected abstract List<Date> doEvaluate(SettlementPayout forwardPayout);

	public static class ForwardSettlementDateDefault extends ForwardSettlementDate {
		@Override
		protected List<Date> doEvaluate(SettlementPayout forwardPayout) {
			List<Date> forwardDate = new ArrayList<>();
			return assignOutput(forwardDate, forwardPayout);
		}
		
		protected List<Date> assignOutput(List<Date> forwardDate, SettlementPayout forwardPayout) {
			forwardDate.addAll(settlementDateFromSettlementTerms.evaluate(MapperS.of(forwardPayout).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get()));
			
			return forwardDate;
		}
	}
}
