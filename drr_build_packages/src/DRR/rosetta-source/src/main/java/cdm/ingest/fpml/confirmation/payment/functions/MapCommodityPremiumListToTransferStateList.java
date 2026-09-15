package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityPremium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPremiumListToTransferStateList.MapCommodityPremiumListToTransferStateListDefault.class)
public abstract class MapCommodityPremiumListToTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonNegativePaymentToTransferState mapNonNegativePaymentToTransferState;

	/**
	* @param fpmlCommodityPremiumList 
	* @param cdmFeeType 
	* @return transferStateList 
	*/
	public List<? extends TransferState> evaluate(List<? extends CommodityPremium> fpmlCommodityPremiumList, FeeTypeEnum cdmFeeType) {
		List<TransferState.TransferStateBuilder> transferStateListBuilder = doEvaluate(fpmlCommodityPremiumList, cdmFeeType);
		
		final List<? extends TransferState> transferStateList;
		if (transferStateListBuilder == null) {
			transferStateList = null;
		} else {
			transferStateList = transferStateListBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferStateList);
		}
		
		return transferStateList;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(List<? extends CommodityPremium> fpmlCommodityPremiumList, FeeTypeEnum cdmFeeType);

	public static class MapCommodityPremiumListToTransferStateListDefault extends MapCommodityPremiumListToTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(List<? extends CommodityPremium> fpmlCommodityPremiumList, FeeTypeEnum cdmFeeType) {
			if (fpmlCommodityPremiumList == null) {
				fpmlCommodityPremiumList = Collections.emptyList();
			}
			List<TransferState.TransferStateBuilder> transferStateList = new ArrayList<>();
			return assignOutput(transferStateList, fpmlCommodityPremiumList, cdmFeeType);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferStateList, List<? extends CommodityPremium> fpmlCommodityPremiumList, FeeTypeEnum cdmFeeType) {
			transferStateList.addAll(toBuilder(MapperC.<CommodityPremium>of(fpmlCommodityPremiumList)
				.mapItem(item -> MapperS.of(mapNonNegativePaymentToTransferState.evaluate(item.get(), cdmFeeType))).getMulti()));
			
			return Optional.ofNullable(transferStateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
