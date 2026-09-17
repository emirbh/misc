package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CoalPhysicalLeg;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.OilPhysicalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetFpmlReceiver.GetFpmlReceiverDefault.class)
public abstract class GetFpmlReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityLeg 
	* @return fpmlReceiverPartyReference 
	*/
	public PartyReference evaluate(CommodityLeg fpmlCommodityLeg) {
		PartyReference.PartyReferenceBuilder fpmlReceiverPartyReferenceBuilder = doEvaluate(fpmlCommodityLeg);
		
		final PartyReference fpmlReceiverPartyReference;
		if (fpmlReceiverPartyReferenceBuilder == null) {
			fpmlReceiverPartyReference = null;
		} else {
			fpmlReceiverPartyReference = fpmlReceiverPartyReferenceBuilder.build();
			objectValidator.validate(PartyReference.class, fpmlReceiverPartyReference);
		}
		
		return fpmlReceiverPartyReference;
	}

	protected abstract PartyReference.PartyReferenceBuilder doEvaluate(CommodityLeg fpmlCommodityLeg);

	public static class GetFpmlReceiverDefault extends GetFpmlReceiver {
		@Override
		protected PartyReference.PartyReferenceBuilder doEvaluate(CommodityLeg fpmlCommodityLeg) {
			PartyReference.PartyReferenceBuilder fpmlReceiverPartyReference = PartyReference.builder();
			return assignOutput(fpmlReceiverPartyReference, fpmlCommodityLeg);
		}
		
		protected PartyReference.PartyReferenceBuilder assignOutput(PartyReference.PartyReferenceBuilder fpmlReceiverPartyReference, CommodityLeg fpmlCommodityLeg) {
			if (fpmlCommodityLeg == null) {
				fpmlReceiverPartyReference = null;
			} else if (fpmlCommodityLeg instanceof FloatingLeg) {
				final FloatingLeg floatingLeg = (FloatingLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(floatingLeg).<PartyReference>map("getReceiverPartyReference", _floatingLeg -> _floatingLeg.getReceiverPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof GasPhysicalLeg) {
				final GasPhysicalLeg gasPhysicalLeg = (GasPhysicalLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(gasPhysicalLeg).<PartyReference>map("getReceiverPartyReference", _gasPhysicalLeg -> _gasPhysicalLeg.getReceiverPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof OilPhysicalLeg) {
				final OilPhysicalLeg oilPhysicalLeg = (OilPhysicalLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(oilPhysicalLeg).<PartyReference>map("getReceiverPartyReference", _oilPhysicalLeg -> _oilPhysicalLeg.getReceiverPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof ElectricityPhysicalLeg) {
				final ElectricityPhysicalLeg electricityPhysicalLeg = (ElectricityPhysicalLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(electricityPhysicalLeg).<PartyReference>map("getReceiverPartyReference", _electricityPhysicalLeg -> _electricityPhysicalLeg.getReceiverPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof EnvironmentalPhysicalLeg) {
				final EnvironmentalPhysicalLeg environmentalPhysicalLeg = (EnvironmentalPhysicalLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(environmentalPhysicalLeg).<PartyReference>map("getReceiverPartyReference", _environmentalPhysicalLeg -> _environmentalPhysicalLeg.getReceiverPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof CoalPhysicalLeg) {
				final CoalPhysicalLeg coalPhysicalLeg = (CoalPhysicalLeg) fpmlCommodityLeg;
				fpmlReceiverPartyReference = toBuilder(MapperS.of(coalPhysicalLeg).<PartyReference>map("getReceiverPartyReference", _coalPhysicalLeg -> _coalPhysicalLeg.getReceiverPartyReference()).get());
			} else {
				fpmlReceiverPartyReference = null;
			}
			
			return Optional.ofNullable(fpmlReceiverPartyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
