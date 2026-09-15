package iso20022.auth108.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.mas.MarginCollateralReport5__1;
import iso20022.auth108.mas.MarginReportData9__1;
import iso20022.auth108.mas.PostedMarginOrCollateral6__1;
import iso20022.auth108.mas.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.mas.TechnicalAttributes6__1;
import iso20022.auth108.mas.TradeCounterpartyReport20__1;
import iso20022.auth108.mas.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginReportData9__1Validator implements Validator<MarginReportData9__1> {

	private List<ComparisonResult> getComparisonResults(MarginReportData9__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgTmStmp", (ZonedDateTime) o.getRptgTmStmp() != null ? 1 : 0, 1, 1), 
				checkCardinality("ctrPtyId", (TradeCounterpartyReport20__1) o.getCtrPtyId() != null ? 1 : 0, 1, 1), 
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("coll", (MarginCollateralReport5__1) o.getColl() != null ? 1 : 0, 1, 1), 
				checkCardinality("pstdMrgnOrColl", (PostedMarginOrCollateral6__1) o.getPstdMrgnOrColl() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvdMrgnOrColl", (ReceivedMarginOrCollateral6__1) o.getRcvdMrgnOrColl() != null ? 1 : 0, 0, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes6__1) o.getTechAttrbts() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginReportData9__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginReportData9__1", ValidationResult.ValidationType.CARDINALITY, "MarginReportData9__1", path, "", res.getError());
				}
				return success("MarginReportData9__1", ValidationResult.ValidationType.CARDINALITY, "MarginReportData9__1", path, "");
			})
			.collect(toList());
	}

}
