package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.CommodityBase;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.asset.CommodityDetails;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityChoice2")
@ImplementedBy(CommodityChoice2.Default.class)
public interface CommodityChoice2 extends Validator<Commodity> {
	
	String NAME = "CommodityChoice2";
	String DEFINITION = "commodityBase is absent and commodityDetails is absent or commodityClassification is absent";
	
	class Default implements CommodityChoice2 {
	
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
				return notExists(MapperS.of(commodity).<CommodityBase>map("getCommodityBase", _commodity -> _commodity.getCommodityBase())).andNullSafe(notExists(MapperS.of(commodity).<CommodityDetails>map("getCommodityDetails", _commodity -> _commodity.getCommodityDetails()))).orNullSafe(notExists(MapperS.of(commodity).<CommodityClassification>mapC("getCommodityClassification", _commodity -> _commodity.getCommodityClassification())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Commodity commodity) {
			return Collections.emptyList();
		}
	}
}
