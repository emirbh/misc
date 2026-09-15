package drr.base.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.basket.BasketConstituentsReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(LimitBasketConstituents.LimitBasketConstituentsDefault.class)
public abstract class LimitBasketConstituents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param basketConstituents 
	* @param maxNumber 
	* @return result 
	*/
	public List<? extends BasketConstituentsReport> evaluate(List<? extends BasketConstituentsReport> basketConstituents, Integer maxNumber) {
		List<BasketConstituentsReport.BasketConstituentsReportBuilder> resultBuilder = doEvaluate(basketConstituents, maxNumber);
		
		final List<? extends BasketConstituentsReport> result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.stream().map(BasketConstituentsReport::build).collect(Collectors.toList());
			objectValidator.validate(BasketConstituentsReport.class, result);
		}
		
		return result;
	}

	protected abstract List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(List<? extends BasketConstituentsReport> basketConstituents, Integer maxNumber);

	public static class LimitBasketConstituentsDefault extends LimitBasketConstituents {
		@Override
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(List<? extends BasketConstituentsReport> basketConstituents, Integer maxNumber) {
			if (basketConstituents == null) {
				basketConstituents = Collections.emptyList();
			}
			List<BasketConstituentsReport.BasketConstituentsReportBuilder> result = new ArrayList<>();
			return assignOutput(result, basketConstituents, maxNumber);
		}
		
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> assignOutput(List<BasketConstituentsReport.BasketConstituentsReportBuilder> result, List<? extends BasketConstituentsReport> basketConstituents, Integer maxNumber) {
			return Optional.ofNullable(result)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
