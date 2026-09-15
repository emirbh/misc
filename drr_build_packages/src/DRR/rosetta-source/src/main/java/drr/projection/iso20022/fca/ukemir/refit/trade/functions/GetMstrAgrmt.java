package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.AgreementType2Choice__1;
import iso20022.auth030.fca.MasterAgreement8__1;
import iso20022.auth030.fca.MasterAgreementType2Code;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetMstrAgrmt.GetMstrAgrmtDefault.class)
public abstract class GetMstrAgrmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return mstrAgrmt 
	*/
	public MasterAgreement8__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		MasterAgreement8__1.MasterAgreement8__1Builder mstrAgrmtBuilder = doEvaluate(drrReport);
		
		final MasterAgreement8__1 mstrAgrmt;
		if (mstrAgrmtBuilder == null) {
			mstrAgrmt = null;
		} else {
			mstrAgrmt = mstrAgrmtBuilder.build();
			objectValidator.validate(MasterAgreement8__1.class, mstrAgrmt);
		}
		
		return mstrAgrmt;
	}

	protected abstract MasterAgreement8__1.MasterAgreement8__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetMstrAgrmtDefault extends GetMstrAgrmt {
		@Override
		protected MasterAgreement8__1.MasterAgreement8__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			MasterAgreement8__1.MasterAgreement8__1Builder mstrAgrmt = MasterAgreement8__1.builder();
			return assignOutput(mstrAgrmt, drrReport);
		}
		
		protected MasterAgreement8__1.MasterAgreement8__1Builder assignOutput(MasterAgreement8__1.MasterAgreement8__1Builder mstrAgrmt, FCAUKEMIRTransactionReport drrReport) {
			mstrAgrmt = toBuilder(MasterAgreement8__1.builder()
				.setTp(AgreementType2Choice__1.builder()
					.setTp(MapperS.of(drrReport).<MasterAgreementEnum>map("getMasterAgreementType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getMasterAgreementType()).checkedMap("to-enum", e -> MasterAgreementType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())
				.setOthrMstrAgrmtDtls(MapperS.of(drrReport).<String>map("getOtherMasterAgreementType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOtherMasterAgreementType()).get())
				.setVrsn(MapperS.of(drrReport).<Integer>map("getMasterAgreementVersion", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getMasterAgreementVersion()).map("to-string", Object::toString).get())
				.build());
			
			return Optional.ofNullable(mstrAgrmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
