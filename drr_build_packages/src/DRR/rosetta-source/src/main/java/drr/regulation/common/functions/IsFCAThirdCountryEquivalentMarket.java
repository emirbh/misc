package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsFCAThirdCountryEquivalentMarket.IsFCAThirdCountryEquivalentMarketDefault.class)
public abstract class IsFCAThirdCountryEquivalentMarket implements RosettaFunction {

	/**
	* @param mic 
	* @return result 
	*/
	public Boolean evaluate(String mic) {
		Boolean result = doEvaluate(mic);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String mic);

	public static class IsFCAThirdCountryEquivalentMarketDefault extends IsFCAThirdCountryEquivalentMarket {
		@Override
		protected Boolean doEvaluate(String mic) {
			Boolean result = null;
			return assignOutput(result, mic);
		}
		
		protected Boolean assignOutput(Boolean result, String mic) {
			if (areEqual(MapperC.<String>of(MapperS.of("XASX"), MapperS.of("XSFE"), MapperS.of("CHIA"), MapperS.of("WBAH"), MapperS.of("XBRD"), MapperS.of("XBRU"), MapperS.of("ZBUL"), MapperS.of("IBUL"), MapperS.of("ABUL"), MapperS.of("NEOE"), MapperS.of("XATS"), MapperS.of("XMOD"), MapperS.of("XCNQ"), MapperS.of("NGXC"), MapperS.of("XTSX"), MapperS.of("XTSX"), MapperS.of("XCXD"), MapperS.of("XZAG"), MapperS.of("XCYS"), MapperS.of("XPRA"), MapperS.of("XRMZ"), MapperS.of("XCSE"), MapperS.of("DCSE"), MapperS.of("MCSE"), MapperS.of("XTAL"), MapperS.of("XHEL"), MapperS.of("MHEL"), MapperS.of("DHEL"), MapperS.of("XMON"), MapperS.of("XPAR"), MapperS.of("XMAT"), MapperS.of("DUSA"), MapperS.of("BERA"), MapperS.of("BERC"), MapperS.of("STUC"), MapperS.of("STUA"), MapperS.of("HAMM"), MapperS.of("HAMA"), MapperS.of("HANA"), MapperS.of("DUSC"), MapperS.of("MUNC"), MapperS.of("XEER"), MapperS.of("MUNA"), MapperS.of("EQTB"), MapperS.of("EQTA"), MapperS.of("XGRM"), MapperS.of("FRAA"), MapperS.of("XETA"), MapperS.of("XEUR"), MapperS.of("XETU"), MapperS.of("XPSF"), MapperS.of("HDAT"), MapperS.of("XATH"), MapperS.of("XADE"), MapperS.of("HEDE"), MapperS.of("ASEX"), MapperS.of("HUDX"), MapperS.of("XBUD"), MapperS.of("MICE"), MapperS.of("XICE"), MapperS.of("DICE"), MapperS.of("XMSM"), MapperS.of("ETFP"), MapperS.of("MTAA"), MapperS.of("MOTX"), MapperS.of("MIVX"), MapperS.of("XDMI"), MapperS.of("MTSC"), MapperS.of("XTKS"), MapperS.of("XOSE"), MapperS.of("XNGO"), MapperS.of("XFKA"), MapperS.of("XSAP"), MapperS.of("XTFF"), MapperS.of("XKAC"), MapperS.of("XTKT"), MapperS.of("XRIS"), MapperS.of("XLIT"), MapperS.of("XLUX"), MapperS.of("XMAL"), MapperS.of("IFSM"), MapperS.of("XNXC"), MapperS.of("NDEX"), MapperS.of("XEUE"), MapperS.of("XEUC"), MapperS.of("BTAM"), MapperS.of("CCRM"), MapperS.of("BEUT"), MapperS.of("BARU"), MapperS.of("BEUO"), MapperS.of("XAMS"), MapperS.of("IMEQ"), MapperS.of("FISH"), MapperS.of("NORX"), MapperS.of("NEXO"), MapperS.of("ELNO"), MapperS.of("ELEU"), MapperS.of("ELSE"), MapperS.of("XOAS"), MapperS.of("XOSL"), MapperS.of("XOBD"), MapperS.of("WBCL"), MapperS.of("PLPD"), MapperS.of("WOPO"), MapperS.of("RPWC"), MapperS.of("WETP"), MapperS.of("WIND"), MapperS.of("WIPO"), MapperS.of("XWAR"), MapperS.of("WBON"), MapperS.of("WDER"), MapperS.of("MFOX"), MapperS.of("OMIP"), MapperS.of("XLIS"), MapperS.of("XBSE"), MapperS.of("XSIM"), MapperS.of("XSES"), MapperS.of("IFSG"), MapperS.of("XBRA"), MapperS.of("XLJU"), MapperS.of("SEND"), MapperS.of("MERF"), MapperS.of("SBAR"), MapperS.of("XMRV"), MapperS.of("XMPW"), MapperS.of("SBIL"), MapperS.of("XDRF"), MapperS.of("XBIL"), MapperS.of("XVAL"), MapperS.of("XMAD"), MapperS.of("XBAR"), MapperS.of("XMFX"), MapperS.of("EUWB"), MapperS.of("FIED"), MapperS.of("XSTO"), MapperS.of("DKED"), MapperS.of("EBON"), MapperS.of("NOCO"), MapperS.of("SEED"), MapperS.of("PNED"), MapperS.of("USWB"), MapperS.of("NOFI"), MapperS.of("DKFI"), MapperS.of("DSTO"), MapperS.of("NOED"), MapperS.of("MSTO"), MapperS.of("ESTO"), MapperS.of("GBWB"), MapperS.of("XNGM"), MapperS.of("BTNL"), MapperS.of("XCFF"), MapperS.of("XCBF"), MapperS.of("XCBT"), MapperS.of("XCME"), MapperS.of("XCEC"), MapperS.of("ERIS"), MapperS.of("IFUS"), MapperS.of("KLSH"), MapperS.of("LEDG"), MapperS.of("FREX"), MapperS.of("XMGE"), MapperS.of("XNYM"), MapperS.of("NODX"), MapperS.of("SMFE"), MapperS.of("CDNA"), MapperS.of("GLBX"), MapperS.of("ICUS"), MapperS.of("XNYF"), MapperS.of("XBXO"), MapperS.of("NBXO"), MapperS.of("BOSD"), MapperS.of("XMOO"), MapperS.of("XTSE"), MapperS.of("XDRK"), MapperS.of("NEOD"), MapperS.of("NEON"), MapperS.of("XJPX"), MapperS.of("XJAS"), MapperS.of("XTAM"), MapperS.of("XTK1"), MapperS.of("XTK2"), MapperS.of("XTK3"), MapperS.of("XOSJ")), MapperS.of(mic), CardinalityOperator.Any).getOrDefault(false)) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}
	}
}
