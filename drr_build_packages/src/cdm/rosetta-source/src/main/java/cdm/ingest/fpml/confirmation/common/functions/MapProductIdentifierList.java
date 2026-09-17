package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ProductId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapProductIdentifierList.MapProductIdentifierListDefault.class)
public abstract class MapProductIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdentifier mapProductIdentifier;

	/**
	* @param fpmlProductIdList 
	* @return productIdentifierList 
	*/
	public List<? extends ProductIdentifier> evaluate(List<? extends ProductId> fpmlProductIdList) {
		List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierListBuilder = doEvaluate(fpmlProductIdList);
		
		final List<? extends ProductIdentifier> productIdentifierList;
		if (productIdentifierListBuilder == null) {
			productIdentifierList = null;
		} else {
			productIdentifierList = productIdentifierListBuilder.stream().map(ProductIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(ProductIdentifier.class, productIdentifierList);
		}
		
		return productIdentifierList;
	}

	protected abstract List<ProductIdentifier.ProductIdentifierBuilder> doEvaluate(List<? extends ProductId> fpmlProductIdList);

	public static class MapProductIdentifierListDefault extends MapProductIdentifierList {
		@Override
		protected List<ProductIdentifier.ProductIdentifierBuilder> doEvaluate(List<? extends ProductId> fpmlProductIdList) {
			if (fpmlProductIdList == null) {
				fpmlProductIdList = Collections.emptyList();
			}
			List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierList = new ArrayList<>();
			return assignOutput(productIdentifierList, fpmlProductIdList);
		}
		
		protected List<ProductIdentifier.ProductIdentifierBuilder> assignOutput(List<ProductIdentifier.ProductIdentifierBuilder> productIdentifierList, List<? extends ProductId> fpmlProductIdList) {
			productIdentifierList.addAll(toBuilder(MapperC.<ProductId>of(fpmlProductIdList)
				.mapItem(item -> MapperS.of(mapProductIdentifier.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(productIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
