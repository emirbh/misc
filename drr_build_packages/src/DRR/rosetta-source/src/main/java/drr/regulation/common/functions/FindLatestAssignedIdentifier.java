package drr.regulation.common.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FindLatestAssignedIdentifier.FindLatestAssignedIdentifierDefault.class)
public abstract class FindLatestAssignedIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeIdentifier 
	* @return assignedIdentifier 
	*/
	public AssignedIdentifier evaluate(TradeIdentifier tradeIdentifier) {
		AssignedIdentifier.AssignedIdentifierBuilder assignedIdentifierBuilder = doEvaluate(tradeIdentifier);
		
		final AssignedIdentifier assignedIdentifier;
		if (assignedIdentifierBuilder == null) {
			assignedIdentifier = null;
		} else {
			assignedIdentifier = assignedIdentifierBuilder.build();
			objectValidator.validate(AssignedIdentifier.class, assignedIdentifier);
		}
		
		return assignedIdentifier;
	}

	protected abstract AssignedIdentifier.AssignedIdentifierBuilder doEvaluate(TradeIdentifier tradeIdentifier);

	protected abstract MapperC<? extends AssignedIdentifier> assignedIdentifiersWithVersion(TradeIdentifier tradeIdentifier);

	public static class FindLatestAssignedIdentifierDefault extends FindLatestAssignedIdentifier {
		@Override
		protected AssignedIdentifier.AssignedIdentifierBuilder doEvaluate(TradeIdentifier tradeIdentifier) {
			AssignedIdentifier.AssignedIdentifierBuilder assignedIdentifier = AssignedIdentifier.builder();
			return assignOutput(assignedIdentifier, tradeIdentifier);
		}
		
		protected AssignedIdentifier.AssignedIdentifierBuilder assignOutput(AssignedIdentifier.AssignedIdentifierBuilder assignedIdentifier, TradeIdentifier tradeIdentifier) {
			if (areEqual(MapperS.of(assignedIdentifiersWithVersion(tradeIdentifier).resultCount()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
				assignedIdentifier = toBuilder(MapperS.of(tradeIdentifier).<AssignedIdentifier>mapC("getAssignedIdentifier", _tradeIdentifier -> _tradeIdentifier.getAssignedIdentifier())
					.last().get());
			} else {
				final MapperC<? extends AssignedIdentifier> thenArg = assignedIdentifiersWithVersion(tradeIdentifier)
					.sort(item -> item.<Integer>map("getVersion", _assignedIdentifier -> _assignedIdentifier.getVersion()));
				assignedIdentifier = toBuilder(thenArg
					.last().get());
			}
			
			return Optional.ofNullable(assignedIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends AssignedIdentifier> assignedIdentifiersWithVersion(TradeIdentifier tradeIdentifier) {
			return MapperS.of(tradeIdentifier).<AssignedIdentifier>mapC("getAssignedIdentifier", _tradeIdentifier -> _tradeIdentifier.getAssignedIdentifier())
				.filterItemNullSafe(item -> exists(item.<Integer>map("getVersion", assignedIdentifier -> assignedIdentifier.getVersion())).get());
		}
	}
}
