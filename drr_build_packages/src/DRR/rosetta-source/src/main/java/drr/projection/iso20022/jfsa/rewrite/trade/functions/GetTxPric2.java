package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.PriceData2__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetTxPric2.GetTxPric2Default.class)
public abstract class GetTxPric2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_UnitOfMeasure8Choice__1 create_UnitOfMeasure8Choice__1;
	@Inject protected GetPric getPric;

	/**
	* @param drrReport 
	* @return txPric 
	*/
	public PriceData2__2 evaluate(JFSATransactionReport drrReport) {
		PriceData2__2.PriceData2__2Builder txPricBuilder = doEvaluate(drrReport);
		
		final PriceData2__2 txPric;
		if (txPricBuilder == null) {
			txPric = null;
		} else {
			txPric = txPricBuilder.build();
			objectValidator.validate(PriceData2__2.class, txPric);
		}
		
		return txPric;
	}

	protected abstract PriceData2__2.PriceData2__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetTxPric2Default extends GetTxPric2 {
		@Override
		protected PriceData2__2.PriceData2__2Builder doEvaluate(JFSATransactionReport drrReport) {
			PriceData2__2.PriceData2__2Builder txPric = PriceData2__2.builder();
			return assignOutput(txPric, drrReport);
		}
		
		protected PriceData2__2.PriceData2__2Builder assignOutput(PriceData2__2.PriceData2__2Builder txPric, JFSATransactionReport drrReport) {
			txPric = toBuilder(PriceData2__2.builder()
				.setPric(getPric.evaluate(drrReport))
				.setUnitOfMeasr(create_UnitOfMeasure8Choice__1.evaluate(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", jFSATransactionReport -> jFSATransactionReport.getPriceUnitOfMeasure()).get()))
				.build());
			
			return Optional.ofNullable(txPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
