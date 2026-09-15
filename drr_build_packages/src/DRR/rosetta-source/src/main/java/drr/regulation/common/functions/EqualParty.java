package drr.regulation.common.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EqualParty.EqualPartyDefault.class)
public abstract class EqualParty implements RosettaFunction {

	/**
	* @param p1 
	* @param p2 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Party> p1, List<? extends Party> p2) {
		Boolean result = doEvaluate(p1, p2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Party> p1, List<? extends Party> p2);

	protected abstract MapperS<Boolean> sizeEqual(List<? extends Party> p1, List<? extends Party> p2);

	protected abstract MapperS<Boolean> containsAll(List<? extends Party> p1, List<? extends Party> p2);

	public static class EqualPartyDefault extends EqualParty {
		@Override
		protected Boolean doEvaluate(List<? extends Party> p1, List<? extends Party> p2) {
			if (p1 == null) {
				p1 = Collections.emptyList();
			}
			if (p2 == null) {
				p2 = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, p1, p2);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends Party> p1, List<? extends Party> p2) {
			result = ComparisonResult.ofNullSafe(sizeEqual(p1, p2)).andNullSafe(ComparisonResult.ofNullSafe(containsAll(p1, p2))).get();
			
			return result;
		}
		
		@Override
		protected MapperS<Boolean> sizeEqual(List<? extends Party> p1, List<? extends Party> p2) {
			return areEqual(MapperS.of(MapperC.<Party>of(p1).resultCount()), MapperS.of(MapperC.<Party>of(p2).resultCount()), CardinalityOperator.All).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> containsAll(List<? extends Party> p1, List<? extends Party> p2) {
			final MapperC<Boolean> thenArg = MapperC.<Party>of(p1)
				.mapItem(item -> areEqual(MapperC.<Party>of(p2), item, CardinalityOperator.Any).asMapper());
			return areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper();
		}
	}
}
