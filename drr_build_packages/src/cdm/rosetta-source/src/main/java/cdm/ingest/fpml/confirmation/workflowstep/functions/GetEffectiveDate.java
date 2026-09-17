package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetEffectiveDate.GetEffectiveDateDefault.class)
public abstract class GetEffectiveDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlAmendment 
	* @param fpmlTermination 
	* @param fpmlNovation 
	* @return effectiveDate 
	*/
	public Date evaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation) {
		Date effectiveDate = doEvaluate(fpmlAmendment, fpmlTermination, fpmlNovation);
		
		return effectiveDate;
	}

	protected abstract Date doEvaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation);

	public static class GetEffectiveDateDefault extends GetEffectiveDate {
		@Override
		protected Date doEvaluate(TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation) {
			Date effectiveDate = null;
			return assignOutput(effectiveDate, fpmlAmendment, fpmlTermination, fpmlNovation);
		}
		
		protected Date assignOutput(Date effectiveDate, TradeAmendmentContent fpmlAmendment, TradeNotionalChange fpmlTermination, TradeNovationContent fpmlNovation) {
			if (exists(MapperS.of(fpmlAmendment).<ZonedDateTime>map("getEffectiveDate", tradeAmendmentContent -> tradeAmendmentContent.getEffectiveDate())).getOrDefault(false)) {
				effectiveDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlAmendment).<ZonedDateTime>map("getEffectiveDate", tradeAmendmentContent -> tradeAmendmentContent.getEffectiveDate()).get());
			} else if (exists(MapperS.of(fpmlTermination).<ZonedDateTime>map("getEffectiveDate", tradeNotionalChange -> tradeNotionalChange.getEffectiveDate())).getOrDefault(false)) {
				effectiveDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlTermination).<ZonedDateTime>map("getEffectiveDate", tradeNotionalChange -> tradeNotionalChange.getEffectiveDate()).get());
			} else if (exists(MapperS.of(fpmlNovation).<ZonedDateTime>map("getNovationDate", tradeNovationContent -> tradeNovationContent.getNovationDate())).getOrDefault(false)) {
				effectiveDate = mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlNovation).<ZonedDateTime>map("getNovationDate", tradeNovationContent -> tradeNovationContent.getNovationDate()).get());
			} else {
				effectiveDate = null;
			}
			
			return effectiveDate;
		}
	}
}
