package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.ContractType15__3;
import iso20022.auth030.mas.FinancialInstrumentContractType2Code;
import iso20022.auth030.mas.ProductType4Code__1;
import iso20022.auth030.mas.SecurityIdentification46__3;
import iso20022.auth030.mas.UniqueProductIdentifier2Choice__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ContractType15__3.Create_ContractType15__3Default.class)
public abstract class Create_ContractType15__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__3 evaluate(MASTransactionReport drrReport) {
		ContractType15__3.ContractType15__3Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType15__3 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType15__3.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType15__3.ContractType15__3Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_ContractType15__3Default extends Create_ContractType15__3 {
		@Override
		protected ContractType15__3.ContractType15__3Builder doEvaluate(MASTransactionReport drrReport) {
			ContractType15__3.ContractType15__3Builder ctrctData = ContractType15__3.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__3.ContractType15__3Builder assignOutput(ContractType15__3.ContractType15__3Builder ctrctData, MASTransactionReport drrReport) {
			ctrctData = toBuilder(ContractType15__3.builder()
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPdctId(SecurityIdentification46__3.builder()
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__2.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", mASTransactionReport -> mASTransactionReport.getUniqueProductIdentifier()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
