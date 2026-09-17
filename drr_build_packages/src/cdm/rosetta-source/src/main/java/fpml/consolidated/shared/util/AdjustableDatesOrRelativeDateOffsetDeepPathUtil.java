package fpml.consolidated.shared.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.RelativeDateOffset;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AdjustableDatesOrRelativeDateOffsetDeepPathUtil {
	public String chooseId(AdjustableDatesOrRelativeDateOffset adjustableDatesOrRelativeDateOffset) {
		final MapperS<AdjustableDates> adjustableDates = MapperS.of(adjustableDatesOrRelativeDateOffset).<AdjustableDates>map("getAdjustableDates", _adjustableDatesOrRelativeDateOffset -> _adjustableDatesOrRelativeDateOffset.getAdjustableDates());
		if (exists(adjustableDates).getOrDefault(false)) {
			return adjustableDates.<String>map("getId", _adjustableDates -> _adjustableDates.getId()).get();
		}
		final MapperS<RelativeDateOffset> relativeDate = MapperS.of(adjustableDatesOrRelativeDateOffset).<RelativeDateOffset>map("getRelativeDate", _adjustableDatesOrRelativeDateOffset -> _adjustableDatesOrRelativeDateOffset.getRelativeDate());
		if (exists(relativeDate).getOrDefault(false)) {
			return relativeDate.<String>map("getId", relativeDateOffset -> relativeDateOffset.getId()).get();
		}
		return null;
	}
	
}
