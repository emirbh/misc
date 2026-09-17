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


@ImplementedBy(GetFpmlPayer.GetFpmlPayerDefault.class)
public abstract class GetFpmlPayer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityLeg 
	* @return fpmlPayerPartyReference 
	*/
	public PartyReference evaluate(CommodityLeg fpmlCommodityLeg) {
		PartyReference.PartyReferenceBuilder fpmlPayerPartyReferenceBuilder = doEvaluate(fpmlCommodityLeg);
		
		final PartyReference fpmlPayerPartyReference;
		if (fpmlPayerPartyReferenceBuilder == null) {
			fpmlPayerPartyReference = null;
		} else {
			fpmlPayerPartyReference = fpmlPayerPartyReferenceBuilder.build();
			objectValidator.validate(PartyReference.class, fpmlPayerPartyReference);
		}
		
		return fpmlPayerPartyReference;
	}

	protected abstract PartyReference.PartyReferenceBuilder doEvaluate(CommodityLeg fpmlCommodityLeg);

	public static class GetFpmlPayerDefault extends GetFpmlPayer {
		@Override
		protected PartyReference.PartyReferenceBuilder doEvaluate(CommodityLeg fpmlCommodityLeg) {
			PartyReference.PartyReferenceBuilder fpmlPayerPartyReference = PartyReference.builder();
			return assignOutput(fpmlPayerPartyReference, fpmlCommodityLeg);
		}
		
		protected PartyReference.PartyReferenceBuilder assignOutput(PartyReference.PartyReferenceBuilder fpmlPayerPartyReference, CommodityLeg fpmlCommodityLeg) {
			if (fpmlCommodityLeg == null) {
				fpmlPayerPartyReference = null;
			} else if (fpmlCommodityLeg instanceof FloatingLeg) {
				final FloatingLeg floatingLeg = (FloatingLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(floatingLeg).<PartyReference>map("getPayerPartyReference", _floatingLeg -> _floatingLeg.getPayerPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof GasPhysicalLeg) {
				final GasPhysicalLeg gasPhysicalLeg = (GasPhysicalLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(gasPhysicalLeg).<PartyReference>map("getPayerPartyReference", _gasPhysicalLeg -> _gasPhysicalLeg.getPayerPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof OilPhysicalLeg) {
				final OilPhysicalLeg oilPhysicalLeg = (OilPhysicalLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(oilPhysicalLeg).<PartyReference>map("getPayerPartyReference", _oilPhysicalLeg -> _oilPhysicalLeg.getPayerPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof ElectricityPhysicalLeg) {
				final ElectricityPhysicalLeg electricityPhysicalLeg = (ElectricityPhysicalLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(electricityPhysicalLeg).<PartyReference>map("getPayerPartyReference", _electricityPhysicalLeg -> _electricityPhysicalLeg.getPayerPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof EnvironmentalPhysicalLeg) {
				final EnvironmentalPhysicalLeg environmentalPhysicalLeg = (EnvironmentalPhysicalLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(environmentalPhysicalLeg).<PartyReference>map("getPayerPartyReference", _environmentalPhysicalLeg -> _environmentalPhysicalLeg.getPayerPartyReference()).get());
			} else if (fpmlCommodityLeg instanceof CoalPhysicalLeg) {
				final CoalPhysicalLeg coalPhysicalLeg = (CoalPhysicalLeg) fpmlCommodityLeg;
				fpmlPayerPartyReference = toBuilder(MapperS.of(coalPhysicalLeg).<PartyReference>map("getPayerPartyReference", _coalPhysicalLeg -> _coalPhysicalLeg.getPayerPartyReference()).get());
			} else {
				fpmlPayerPartyReference = null;
			}
			
			return Optional.ofNullable(fpmlPayerPartyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
