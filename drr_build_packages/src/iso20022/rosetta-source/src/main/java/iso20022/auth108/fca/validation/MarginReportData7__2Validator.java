package iso20022.auth108.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.fca.MarginCollateralReport4__1;
import iso20022.auth108.fca.MarginReportData7__2;
import iso20022.auth108.fca.PostedMarginOrCollateral6__1;
import iso20022.auth108.fca.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.fca.TradeCounterpartyReport20__2;
import iso20022.auth108.fca.UniqueTransactionIdentifier2Choice__2;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginReportData7__2Validator implements Validator<MarginReportData7__2> {

	private List<ComparisonResult> getComparisonResults(MarginReportData7__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgTmStmp", (ZonedDateTime) o.getRptgTmStmp() != null ? 1 : 0, 1, 1), 
				checkCardinality("ctrPtyId", (TradeCounterpartyReport20__2) o.getCtrPtyId() != null ? 1 : 0, 1, 1), 
				checkCardinality("evtDt", (Date) o.getEvtDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__2) o.getTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("coll", (MarginCollateralReport4__1) o.getColl() != null ? 1 : 0, 1, 1), 
				checkCardinality("pstdMrgnOrColl", (PostedMarginOrCollateral6__1) o.getPstdMrgnOrColl() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvdMrgnOrColl", (ReceivedMarginOrCollateral6__1) o.getRcvdMrgnOrColl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginReportData7__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginReportData7__2", ValidationResult.ValidationType.CARDINALITY, "MarginReportData7__2", path, "", res.getError());
				}
				return success("MarginReportData7__2", ValidationResult.ValidationType.CARDINALITY, "MarginReportData7__2", path, "");
			})
			.collect(toList());
	}

}
