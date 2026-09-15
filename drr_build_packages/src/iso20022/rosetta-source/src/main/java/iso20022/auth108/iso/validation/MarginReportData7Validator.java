package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.MarginCollateralReport4;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.PostedMarginOrCollateral6;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import iso20022.auth108.iso.TechnicalAttributes6;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import iso20022.auth108.iso.UniqueTransactionIdentifier2Choice;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginReportData7Validator implements Validator<MarginReportData7> {

	private List<ComparisonResult> getComparisonResults(MarginReportData7 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgTmStmp", (ZonedDateTime) o.getRptgTmStmp() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrPtyId", (TradeCounterpartyReport20) o.getCtrPtyId() != null ? 1 : 0, 1, 1), 
				checkCardinality("evtDt", (Date) o.getEvtDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice) o.getTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("coll", (MarginCollateralReport4) o.getColl() != null ? 1 : 0, 1, 1), 
				checkCardinality("pstdMrgnOrColl", (PostedMarginOrCollateral6) o.getPstdMrgnOrColl() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvdMrgnOrColl", (ReceivedMarginOrCollateral6) o.getRcvdMrgnOrColl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrPtyRatgTrggrInd", (Boolean) o.getCtrPtyRatgTrggrInd() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrPtyRatgThrshldInd", (Boolean) o.getCtrPtyRatgThrshldInd() != null ? 1 : 0, 0, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes6) o.getTechAttrbts() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginReportData7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginReportData7", ValidationResult.ValidationType.CARDINALITY, "MarginReportData7", path, "", res.getError());
				}
				return success("MarginReportData7", ValidationResult.ValidationType.CARDINALITY, "MarginReportData7", path, "");
			})
			.collect(toList());
	}

}
