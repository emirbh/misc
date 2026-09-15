package drr.base.trade.validation;

import cdm.event.common.PositionIdentifier;
import cdm.observable.asset.PriceSchedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.basket.CustomBasket;
import drr.enrichment.common.EnrichmentData;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableInformationBaseValidator implements Validator<ReportableInformationBase> {

	private List<ComparisonResult> getComparisonResults(ReportableInformationBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("globalPartyInformation", (List<? extends PartyInformation>) o.getGlobalPartyInformation() == null ? 0 : o.getGlobalPartyInformation().size(), 1, 0), 
				checkCardinality("reportableAction", (ReportableActionEnum) o.getReportableAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("enrichment", (EnrichmentData) o.getEnrichment() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationMethod", (ConfirmationMethodEnum) o.getConfirmationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalExecutionTimestamp", (ZonedDateTime) o.getOriginalExecutionTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalContractualSettlementDate", (Date) o.getFinalContractualSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cryptoBased", (Boolean) o.getCryptoBased() != null ? 1 : 0, 0, 1), 
				checkCardinality("customBasket", (CustomBasket) o.getCustomBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("intragroup", (Boolean) o.getIntragroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("affiliated", (Boolean) o.getAffiliated() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetLastAvailableSpotPrice", (PriceSchedule) o.getUnderlyingAssetLastAvailableSpotPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("subsequentPositionUTI", (PositionIdentifier) o.getSubsequentPositionUTI() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterpartyPositionPriorUTI", (PositionIdentifier) o.getCounterpartyPositionPriorUTI() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableInformationBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableInformationBase", ValidationResult.ValidationType.CARDINALITY, "ReportableInformationBase", path, "", res.getError());
				}
				return success("ReportableInformationBase", ValidationResult.ValidationType.CARDINALITY, "ReportableInformationBase", path, "");
			})
			.collect(toList());
	}

}
