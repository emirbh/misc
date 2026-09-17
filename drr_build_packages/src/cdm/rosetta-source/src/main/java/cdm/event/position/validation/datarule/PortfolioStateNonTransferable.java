package cdm.event.position.validation.datarule;

import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("PortfolioStateNonTransferable")
@ImplementedBy(PortfolioStateNonTransferable.Default.class)
public interface PortfolioStateNonTransferable extends Validator<PortfolioState> {
	
	String NAME = "PortfolioStateNonTransferable";
	String DEFINITION = "positions -> product -> NonTransferableProduct exists";
	
	class Default implements PortfolioStateNonTransferable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioState portfolioState) {
			ComparisonResult result = executeDataRule(portfolioState);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PortfolioState portfolioState) {
			try {
				return exists(MapperS.of(portfolioState).<Position>mapC("getPositions", _portfolioState -> _portfolioState.getPositions()).<Product>map("getProduct", position -> position.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioStateNonTransferable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioState portfolioState) {
			return Collections.emptyList();
		}
	}
}
