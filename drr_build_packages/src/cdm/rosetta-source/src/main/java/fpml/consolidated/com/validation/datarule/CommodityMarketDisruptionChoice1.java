package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.MarketDisruptionEvent;
import fpml.consolidated.fpmlenum.MarketDisruptionEventsEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityMarketDisruptionChoice1")
@ImplementedBy(CommodityMarketDisruptionChoice1.Default.class)
public interface CommodityMarketDisruptionChoice1 extends Validator<CommodityMarketDisruption> {
	
	String NAME = "CommodityMarketDisruptionChoice1";
	String DEFINITION = "marketDisruptionEvent is absent or marketDisruptionEvents is absent and additionalMarketDisruptionEvent is absent";
	
	class Default implements CommodityMarketDisruptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruption commodityMarketDisruption) {
			ComparisonResult result = executeDataRule(commodityMarketDisruption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityMarketDisruption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityMarketDisruption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityMarketDisruption commodityMarketDisruption) {
			try {
				return notExists(MapperS.of(commodityMarketDisruption).<MarketDisruptionEvent>mapC("getMarketDisruptionEvent", _commodityMarketDisruption -> _commodityMarketDisruption.getMarketDisruptionEvent())).orNullSafe(notExists(MapperS.of(commodityMarketDisruption).<MarketDisruptionEventsEnum>map("getMarketDisruptionEvents", _commodityMarketDisruption -> _commodityMarketDisruption.getMarketDisruptionEvents())).andNullSafe(notExists(MapperS.of(commodityMarketDisruption).<MarketDisruptionEvent>mapC("getAdditionalMarketDisruptionEvent", _commodityMarketDisruption -> _commodityMarketDisruption.getAdditionalMarketDisruptionEvent()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityMarketDisruptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruption commodityMarketDisruption) {
			return Collections.emptyList();
		}
	}
}
