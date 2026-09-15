package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.IndexAnnexSource;
import fpml.consolidated.cd.IndexName;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.SettledEntityMatrix;
import fpml.consolidated.cd.Tranche;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IndexReferenceInformationValidator implements Validator<IndexReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(IndexReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexName", (IndexName) o.getIndexName() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSeries", (Integer) o.getIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexVersion", (Integer) o.getIndexAnnexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexDate", (ZonedDateTime) o.getIndexAnnexDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexSource", (IndexAnnexSource) o.getIndexAnnexSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (Tranche) o.getTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("settledEntityMatrix", (SettledEntityMatrix) o.getSettledEntityMatrix() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "IndexReferenceInformation", path, "", res.getError());
				}
				return success("IndexReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "IndexReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
