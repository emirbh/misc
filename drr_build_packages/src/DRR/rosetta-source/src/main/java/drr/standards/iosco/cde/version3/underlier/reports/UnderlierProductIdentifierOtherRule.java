package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierProductIdentifierOtherRule.UnderlierProductIdentifierOtherRuleDefault.class)
public abstract class UnderlierProductIdentifierOtherRule implements ReportFunction<TransactionReportInstructionBase, List<? extends AssetIdentifier>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends AssetIdentifier> evaluate(TransactionReportInstructionBase input) {
		List<AssetIdentifier.AssetIdentifierBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends AssetIdentifier> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, output);
		}
		
		return output;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierProductIdentifierOtherRuleDefault extends UnderlierProductIdentifierOtherRule {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(TransactionReportInstructionBase input) {
			List<AssetIdentifier.AssetIdentifierBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> output, TransactionReportInstructionBase input) {
			final MapperS<NonTransferableProduct> thenArg;
			if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(productForEvent.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(productForEvent.evaluate(input))))).getOrDefault(false)) {
				thenArg = MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(input))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
			} else {
				thenArg = MapperS.of(productForEvent.evaluate(input));
			}
			output = toBuilder(thenArg
				.mapSingleToList(item -> {
					if (notExists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN))).getOrDefault(false)) {
						return MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null));
					}
					return MapperC.<AssetIdentifier>ofNull();
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
