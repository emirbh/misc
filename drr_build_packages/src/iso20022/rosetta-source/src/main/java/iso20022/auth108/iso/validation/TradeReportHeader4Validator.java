package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.Pagination1;
import iso20022.auth108.iso.TradeReportHeader4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReportHeader4Validator implements Validator<TradeReportHeader4> {

	private List<ComparisonResult> getComparisonResults(TradeReportHeader4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptExctnDt", (Date) o.getRptExctnDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("msgPgntn", (Pagination1) o.getMsgPgntn() != null ? 1 : 0, 0, 1), 
				checkCardinality("nbRcrds", (Long) o.getNbRcrds() != null ? 1 : 0, 1, 1), 
				checkCardinality("newTradRpstryIdr", (OrganisationIdentification15Choice) o.getNewTradRpstryIdr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReportHeader4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReportHeader4", ValidationResult.ValidationType.CARDINALITY, "TradeReportHeader4", path, "", res.getError());
				}
				return success("TradeReportHeader4", ValidationResult.ValidationType.CARDINALITY, "TradeReportHeader4", path, "");
			})
			.collect(toList());
	}

}
