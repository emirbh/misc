package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.ContractType15__2;
import iso20022.auth030.hkma.dtcc.ProductType4Code__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ContractType15__2.Create_ContractType15__2Default.class)
public abstract class Create_ContractType15__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__2 evaluate(HKMATransactionReport drrReport) {
		ContractType15__2.ContractType15__2Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType15__2 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType15__2.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType15__2.ContractType15__2Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_ContractType15__2Default extends Create_ContractType15__2 {
		@Override
		protected ContractType15__2.ContractType15__2Builder doEvaluate(HKMATransactionReport drrReport) {
			ContractType15__2.ContractType15__2Builder ctrctData = ContractType15__2.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__2.ContractType15__2Builder assignOutput(ContractType15__2.ContractType15__2Builder ctrctData, HKMATransactionReport drrReport) {
			ctrctData = toBuilder(ContractType15__2.builder()
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
