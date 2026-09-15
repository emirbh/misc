package drr.enrichment.lei.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.functions.AddBusinessDays;
import cdm.base.datetime.functions.DateDifference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(LeiRegistrationStatusIsValidForStatus.LeiRegistrationStatusIsValidForStatusDefault.class)
public abstract class LeiRegistrationStatusIsValidForStatus implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AddBusinessDays addBusinessDays;
	@Inject protected DateDifference dateDifference;
	@Inject protected GetOrFetchLeiData getOrFetchLeiData;

	/**
	* @param leiData 
	* @param partyLei 
	* @param eventDate 
	* @param reportingDate 
	* @param statuses 
	* @return valid 
	*/
	public Boolean evaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate, List<LeiRegistrationStatusEnum> statuses) {
		Boolean valid = doEvaluate(leiData, partyLei, eventDate, reportingDate, statuses);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate, List<LeiRegistrationStatusEnum> statuses);

	public static class LeiRegistrationStatusIsValidForStatusDefault extends LeiRegistrationStatusIsValidForStatus {
		@Override
		protected Boolean doEvaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate, List<LeiRegistrationStatusEnum> statuses) {
			if (leiData == null) {
				leiData = Collections.emptyList();
			}
			if (statuses == null) {
				statuses = Collections.emptyList();
			}
			Boolean valid = null;
			return assignOutput(valid, leiData, partyLei, eventDate, reportingDate, statuses);
		}
		
		protected Boolean assignOutput(Boolean valid, List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate, List<LeiRegistrationStatusEnum> statuses) {
			if (exists(MapperS.of(getOrFetchLeiData.evaluate(leiData, partyLei))).andNullSafe(lessThanEquals(MapperS.of(dateDifference.evaluate(addBusinessDays.evaluate(eventDate, 1, Collections.<BusinessCenterEnum>emptyList()), reportingDate)), MapperS.of(0), CardinalityOperator.All)).getOrDefault(false)) {
				valid = areEqual(MapperC.<LeiRegistrationStatusEnum>of(statuses), MapperS.of(getOrFetchLeiData.evaluate(leiData, partyLei)).<LeiRegistrationStatusEnum>map("getRegistrationStatus", _leiData -> _leiData.getRegistrationStatus()), CardinalityOperator.Any).get();
			} else {
				valid = null;
			}
			
			return valid;
		}
	}
}
