package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.ContractType15__2;
import iso20022.auth030.mas.FinancialInstrumentContractType2Code;
import iso20022.auth030.mas.ProductType4Code__1;
import iso20022.auth030.mas.SecurityIdentification46__2;
import iso20022.auth030.mas.UniqueProductIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ContractType15__2.Create_ContractType15__2Default.class)
public abstract class Create_ContractType15__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__2 evaluate(MASTransactionReport drrReport) {
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

	protected abstract ContractType15__2.ContractType15__2Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_ContractType15__2Default extends Create_ContractType15__2 {
		@Override
		protected ContractType15__2.ContractType15__2Builder doEvaluate(MASTransactionReport drrReport) {
			ContractType15__2.ContractType15__2Builder ctrctData = ContractType15__2.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__2.ContractType15__2Builder assignOutput(ContractType15__2.ContractType15__2Builder ctrctData, MASTransactionReport drrReport) {
			ctrctData = toBuilder(ContractType15__2.builder()
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPdctId(SecurityIdentification46__2.builder()
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
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
