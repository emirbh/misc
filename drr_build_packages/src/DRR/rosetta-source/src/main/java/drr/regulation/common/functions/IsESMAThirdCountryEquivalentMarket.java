package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsESMAThirdCountryEquivalentMarket.IsESMAThirdCountryEquivalentMarketDefault.class)
public abstract class IsESMAThirdCountryEquivalentMarket implements RosettaFunction {

	/**
	* @param mic 
	* @return result 
	*/
	public Boolean evaluate(String mic) {
		Boolean result = doEvaluate(mic);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String mic);

	public static class IsESMAThirdCountryEquivalentMarketDefault extends IsESMAThirdCountryEquivalentMarket {
		@Override
		protected Boolean doEvaluate(String mic) {
			Boolean result = null;
			return assignOutput(result, mic);
		}
		
		protected Boolean assignOutput(Boolean result, String mic) {
			if (areEqual(MapperC.<String>of(MapperS.of("BTNL"), MapperS.of("XBOX"), MapperS.of("XCFF"), MapperS.of("XCBF"), MapperS.of("BATS"), MapperS.of("C2OX"), MapperS.of("EDGX"), MapperS.of("XCBO"), MapperS.of("XCBT"), MapperS.of("XCME"), MapperS.of("XCEC"), MapperS.of("XELX"), MapperS.of("ERIS"), MapperS.of("IFUS"), MapperS.of("KLSH"), MapperS.of("LEDG"), MapperS.of("FREX"), MapperS.of("XMIO"), MapperS.of("EMLD"), MapperS.of("MPRL"), MapperS.of("XMGE"), MapperS.of("GMNI"), MapperS.of("XISX"), MapperS.of("XBOS"), MapperS.of("MCRY"), MapperS.of("XPHL"), MapperS.of("XNDQ"), MapperS.of("XNYM"), MapperS.of("NODX"), MapperS.of("HEGX"), MapperS.of("AMXO"), MapperS.of("ARCX"), MapperS.of("XOCH"), MapperS.of("SMFE"), MapperS.of("TRUX"), MapperS.of("XASX"), MapperS.of("XSFE"), MapperS.of("CHIA"), MapperS.of("XFEX"), MapperS.of("XMOD"), MapperS.of("XCNQ"), MapperS.of("IFCA"), MapperS.of("NGXC"), MapperS.of("XTSX"), MapperS.of("XTNX"), MapperS.of("XATS"), MapperS.of("NEOC"), MapperS.of("XTKS"), MapperS.of("XOSE"), MapperS.of("XNGO"), MapperS.of("XFKA"), MapperS.of("XSAP"), MapperS.of("XTFF"), MapperS.of("XKAC"), MapperS.of("XTKT"), MapperS.of("XSIM"), MapperS.of("XSES"), MapperS.of("IFSG"), MapperS.of("CXAF"), MapperS.of("CDNA"), MapperS.of("BATO"), MapperS.of("IMIR"), MapperS.of("XISA"), MapperS.of("FCBT"), MapperS.of("XNYE"), MapperS.of("XATX"), MapperS.of("CXAB"), MapperS.of("ASXC"), MapperS.of("NZFX"), MapperS.of("NYMS"), MapperS.of("XIOM"), MapperS.of("XSCE"), MapperS.of("EDGO"), MapperS.of("CXAC"), MapperS.of("ADRK"), MapperS.of("XSBT"), MapperS.of("FUSD"), MapperS.of("CSE2"), MapperS.of("CXAR"), MapperS.of("CBTS"), MapperS.of("XCBD"), MapperS.of("FCME"), MapperS.of("EDGD"), MapperS.of("EDGA"), MapperS.of("ASXB"), MapperS.of("CXAP"), MapperS.of("XISE"), MapperS.of("ASXV"), MapperS.of("IMCR"), MapperS.of("EDDP"), MapperS.of("IFED"), MapperS.of("TRU1"), MapperS.of("IMEN"), MapperS.of("TRU2"), MapperS.of("PURE"), MapperS.of("XTPZ"), MapperS.of("IMCG"), MapperS.of("XSCA"), MapperS.of("XWCE"), MapperS.of("IEPA"), MapperS.of("CXAE"), MapperS.of("CTWO"), MapperS.of("CXAW"), MapperS.of("XIMM"), MapperS.of("XKBT"), MapperS.of("CMES"), MapperS.of("CXAV"), MapperS.of("CBSX"), MapperS.of("CECS"), MapperS.of("CXAM"), MapperS.of("ASXT"), MapperS.of("XSCL"), MapperS.of("CONE"), MapperS.of("XNYL"), MapperS.of("VDRK"), MapperS.of("CXAQ"), MapperS.of("XMFE"), MapperS.of("ASXP"), MapperS.of("BYXD"), MapperS.of("IMAG"), MapperS.of("BZXD"), MapperS.of("CXAI"), MapperS.of("BATY"), MapperS.of("IMFX"), MapperS.of("IMBD"), MapperS.of("CXAN"), MapperS.of("ARCO"), MapperS.of("GLBX"), MapperS.of("ICUS"), MapperS.of("XNYF"), MapperS.of("XBXO"), MapperS.of("NBXO"), MapperS.of("BOSD"), MapperS.of("XMOO"), MapperS.of("XTSE"), MapperS.of("XDRK"), MapperS.of("NEOD"), MapperS.of("NEON"), MapperS.of("XJPX"), MapperS.of("XJAS"), MapperS.of("XTAM"), MapperS.of("XTK1"), MapperS.of("XTK2"), MapperS.of("XTK3"), MapperS.of("XOSJ"), MapperS.of("XSGL")), MapperS.of(mic), CardinalityOperator.Any).getOrDefault(false)) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}
	}
}
