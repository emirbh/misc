package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CommodityOrdinalExists")
@ImplementedBy(CommodityOrdinalExists.Default.class)
public interface CommodityOrdinalExists extends Validator<Commodity> {
	
	String NAME = "CommodityOrdinalExists";
	String DEFINITION = "if taxonomy -> value -> classification count > 1 then taxonomy -> value -> classification -> ordinal exists";
	
	class Default implements CommodityOrdinalExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Commodity commodity) {
			ComparisonResult result = executeDataRule(commodity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Commodity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Commodity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Commodity commodity) {
			try {
				if (greaterThan(MapperS.of(MapperS.of(commodity).<Taxonomy>mapC("getTaxonomy", _commodity -> _commodity.getTaxonomy()).<TaxonomyValue>map("getValue", taxonomy -> taxonomy.getValue()).<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(commodity).<Taxonomy>mapC("getTaxonomy", _commodity -> _commodity.getTaxonomy()).<TaxonomyValue>map("getValue", taxonomy -> taxonomy.getValue()).<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification()).<Integer>map("getOrdinal", taxonomyClassification -> taxonomyClassification.getOrdinal()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOrdinalExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Commodity commodity) {
			return Collections.emptyList();
		}
	}
}
