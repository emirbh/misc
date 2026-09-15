package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.Package4__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetPackg.GetPackgDefault.class)
public abstract class GetPackg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return packg 
	*/
	public Package4__1 evaluate(MASTransactionReport drrReport) {
		Package4__1.Package4__1Builder packgBuilder = doEvaluate(drrReport);
		
		final Package4__1 packg;
		if (packgBuilder == null) {
			packg = null;
		} else {
			packg = packgBuilder.build();
			objectValidator.validate(Package4__1.class, packg);
		}
		
		return packg;
	}

	protected abstract Package4__1.Package4__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class GetPackgDefault extends GetPackg {
		@Override
		protected Package4__1.Package4__1Builder doEvaluate(MASTransactionReport drrReport) {
			Package4__1.Package4__1Builder packg = Package4__1.builder();
			return assignOutput(packg, drrReport);
		}
		
		protected Package4__1.Package4__1Builder assignOutput(Package4__1.Package4__1Builder packg, MASTransactionReport drrReport) {
			packg = toBuilder(Package4__1.builder()
				.setCmplxTradId(MapperS.of(drrReport).<String>map("getPackageIdentifier", mASTransactionReport -> mASTransactionReport.getPackageIdentifier()).get())
				.setFxSwpLkId(MapperS.of(drrReport).<String>map("getSwapLinkID", mASTransactionReport -> mASTransactionReport.getSwapLinkID()).get())
				.build());
			
			return Optional.ofNullable(packg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
