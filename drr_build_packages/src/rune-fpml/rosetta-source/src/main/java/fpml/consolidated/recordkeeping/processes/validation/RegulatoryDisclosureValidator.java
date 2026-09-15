package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.business.events.EventTaxonomy;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.recordkeeping.processes.EventTimestamps;
import fpml.consolidated.recordkeeping.processes.RegReportingCDE;
import fpml.consolidated.recordkeeping.processes.RegulationDetails;
import fpml.consolidated.recordkeeping.processes.RegulatoryDisclosure;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryDisclosureValidator implements Validator<RegulatoryDisclosure> {

	private List<ComparisonResult> getComparisonResults(RegulatoryDisclosure o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (NotificationMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("asOfDate", (IdentifiedDate) o.getAsOfDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("asOfTime", (LocalTime) o.getAsOfTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventId", (EventId) o.getEventId() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventType", (EventTaxonomy) o.getEventType() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventTimestamps", (EventTimestamps) o.getEventTimestamps() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingPartyReference", (PartyReference) o.getReportingPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterPartyReference", (PartyReference) o.getCounterPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalChange", (NotionalChangeEnum) o.getNotionalChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("applicableRegulations", (ApplicableRegulations) o.getApplicableRegulations() != null ? 1 : 0, 0, 1), 
				checkCardinality("regulationSpecificInformation", (RegulationDetails) o.getRegulationSpecificInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("cpmiIoscoCDE", (RegReportingCDE) o.getCpmiIoscoCDE() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralization", (List<? extends RegulatoryReportingCollateralization>) o.getCollateralization() == null ? 0 : o.getCollateralization().size(), 0, 2), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryDisclosure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryDisclosure", ValidationResult.ValidationType.CARDINALITY, "RegulatoryDisclosure", path, "", res.getError());
				}
				return success("RegulatoryDisclosure", ValidationResult.ValidationType.CARDINALITY, "RegulatoryDisclosure", path, "");
			})
			.collect(toList());
	}

}
