package drr.regulation.csa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(SupervisoryBodyForCSA.SupervisoryBodyForCSADefault.class)
public abstract class SupervisoryBodyForCSA implements RosettaFunction {

	/**
	* @return supervisoryBodyCSA 
	*/
	public List<SupervisoryBodyEnum> evaluate() {
		List<SupervisoryBodyEnum> supervisoryBodyCSA = doEvaluate();
		
		return supervisoryBodyCSA;
	}

	protected abstract List<SupervisoryBodyEnum> doEvaluate();

	public static class SupervisoryBodyForCSADefault extends SupervisoryBodyForCSA {
		@Override
		protected List<SupervisoryBodyEnum> doEvaluate() {
			List<SupervisoryBodyEnum> supervisoryBodyCSA = new ArrayList<>();
			return assignOutput(supervisoryBodyCSA);
		}
		
		protected List<SupervisoryBodyEnum> assignOutput(List<SupervisoryBodyEnum> supervisoryBodyCSA) {
			supervisoryBodyCSA.addAll(MapperC.<SupervisoryBodyEnum>of(MapperS.of(SupervisoryBodyEnum.CA_AB_ASC), MapperS.of(SupervisoryBodyEnum.CA_BC_BCSC), MapperS.of(SupervisoryBodyEnum.CA_MB_MSC), MapperS.of(SupervisoryBodyEnum.CA_NB_FCSC), MapperS.of(SupervisoryBodyEnum.CA_NL_DSS), MapperS.of(SupervisoryBodyEnum.CA_NS_NSSC), MapperS.of(SupervisoryBodyEnum.CA_NT_NTSO), MapperS.of(SupervisoryBodyEnum.CA_NU_NSO), MapperS.of(SupervisoryBodyEnum.CA_ON_OSC), MapperS.of(SupervisoryBodyEnum.CA_PEI_OSS), MapperS.of(SupervisoryBodyEnum.CA_QC_AMF), MapperS.of(SupervisoryBodyEnum.CA_SK_FCAA), MapperS.of(SupervisoryBodyEnum.CA_YT_OSS)).getMulti());
			
			return supervisoryBodyCSA;
		}
	}
}
