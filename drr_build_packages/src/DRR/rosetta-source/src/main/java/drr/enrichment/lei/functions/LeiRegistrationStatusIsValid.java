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

@ImplementedBy(LeiRegistrationStatusIsValid.LeiRegistrationStatusIsValidDefault.class)
public abstract class LeiRegistrationStatusIsValid implements RosettaFunction {
	
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
	* @return valid 
	*/
	public Boolean evaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate) {
		Boolean valid = doEvaluate(leiData, partyLei, eventDate, reportingDate);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate);

	public static class LeiRegistrationStatusIsValidDefault extends LeiRegistrationStatusIsValid {
		@Override
		protected Boolean doEvaluate(List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate) {
			if (leiData == null) {
				leiData = Collections.emptyList();
			}
			Boolean valid = null;
			return assignOutput(valid, leiData, partyLei, eventDate, reportingDate);
		}
		
		protected Boolean assignOutput(Boolean valid, List<? extends LeiData> leiData, String partyLei, Date eventDate, Date reportingDate) {
			if (exists(MapperS.of(getOrFetchLeiData.evaluate(leiData, partyLei))).andNullSafe(lessThanEquals(MapperS.of(dateDifference.evaluate(addBusinessDays.evaluate(eventDate, 1, Collections.<BusinessCenterEnum>emptyList()), reportingDate)), MapperS.of(0), CardinalityOperator.All)).getOrDefault(false)) {
				valid = areEqual(MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)), MapperS.of(getOrFetchLeiData.evaluate(leiData, partyLei)).<LeiRegistrationStatusEnum>map("getRegistrationStatus", _leiData -> _leiData.getRegistrationStatus()), CardinalityOperator.Any).get();
			} else {
				valid = null;
			}
			
			return valid;
		}
	}
}
