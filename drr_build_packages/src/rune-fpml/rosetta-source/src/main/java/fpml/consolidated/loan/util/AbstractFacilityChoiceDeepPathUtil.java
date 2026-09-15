package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.AbstractFacilityChoice;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FixedRateOption;
import fpml.consolidated.loan.LcOption;
import fpml.consolidated.loan.LegacyFloatingRateOption;
import fpml.consolidated.loan.LoanFloatingRateOption;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AbstractFacilityChoiceDeepPathUtil {
	public AccrualTypeId chooseAccrualOptionId(AbstractFacilityChoice abstractFacilityChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(abstractFacilityChoice).<FixedRateOption>map("getFixedRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<AccrualTypeId>map("getAccrualOptionId", _fixedRateOption -> _fixedRateOption.getAccrualOptionId()).get();
		}
		final MapperS<LoanFloatingRateOption> floatingRateOption = MapperS.of(abstractFacilityChoice).<LoanFloatingRateOption>map("getFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<AccrualTypeId>map("getAccrualOptionId", loanFloatingRateOption -> loanFloatingRateOption.getAccrualOptionId()).get();
		}
		final MapperS<LegacyFloatingRateOption> legacyFloatingRateOption = MapperS.of(abstractFacilityChoice).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLegacyFloatingRateOption());
		if (exists(legacyFloatingRateOption).getOrDefault(false)) {
			return legacyFloatingRateOption.<AccrualTypeId>map("getAccrualOptionId", _legacyFloatingRateOption -> _legacyFloatingRateOption.getAccrualOptionId()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(abstractFacilityChoice).<LcOption>map("getLcOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<AccrualTypeId>map("getAccrualOptionId", _lcOption -> _lcOption.getAccrualOptionId()).get();
		}
		return null;
	}
	
	public ZonedDateTime chooseEndDate(AbstractFacilityChoice abstractFacilityChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(abstractFacilityChoice).<FixedRateOption>map("getFixedRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<ZonedDateTime>map("getEndDate", _fixedRateOption -> _fixedRateOption.getEndDate()).get();
		}
		final MapperS<LoanFloatingRateOption> floatingRateOption = MapperS.of(abstractFacilityChoice).<LoanFloatingRateOption>map("getFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<ZonedDateTime>map("getEndDate", loanFloatingRateOption -> loanFloatingRateOption.getEndDate()).get();
		}
		final MapperS<LegacyFloatingRateOption> legacyFloatingRateOption = MapperS.of(abstractFacilityChoice).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLegacyFloatingRateOption());
		if (exists(legacyFloatingRateOption).getOrDefault(false)) {
			return legacyFloatingRateOption.<ZonedDateTime>map("getEndDate", _legacyFloatingRateOption -> _legacyFloatingRateOption.getEndDate()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(abstractFacilityChoice).<LcOption>map("getLcOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<ZonedDateTime>map("getEndDate", _lcOption -> _lcOption.getEndDate()).get();
		}
		return null;
	}
	
	public DayCountFraction chooseDayCountFraction(AbstractFacilityChoice abstractFacilityChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(abstractFacilityChoice).<FixedRateOption>map("getFixedRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<DayCountFraction>map("getDayCountFraction", _fixedRateOption -> _fixedRateOption.getDayCountFraction()).get();
		}
		final MapperS<LoanFloatingRateOption> floatingRateOption = MapperS.of(abstractFacilityChoice).<LoanFloatingRateOption>map("getFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<DayCountFraction>map("getDayCountFraction", loanFloatingRateOption -> loanFloatingRateOption.getDayCountFraction()).get();
		}
		final MapperS<LegacyFloatingRateOption> legacyFloatingRateOption = MapperS.of(abstractFacilityChoice).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLegacyFloatingRateOption());
		if (exists(legacyFloatingRateOption).getOrDefault(false)) {
			return legacyFloatingRateOption.<DayCountFraction>map("getDayCountFraction", _legacyFloatingRateOption -> _legacyFloatingRateOption.getDayCountFraction()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(abstractFacilityChoice).<LcOption>map("getLcOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<DayCountFraction>map("getDayCountFraction", _lcOption -> _lcOption.getDayCountFraction()).get();
		}
		return null;
	}
	
	public Period choosePaymentFrequency(AbstractFacilityChoice abstractFacilityChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(abstractFacilityChoice).<FixedRateOption>map("getFixedRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<Period>map("getPaymentFrequency", _fixedRateOption -> _fixedRateOption.getPaymentFrequency()).get();
		}
		final MapperS<LoanFloatingRateOption> floatingRateOption = MapperS.of(abstractFacilityChoice).<LoanFloatingRateOption>map("getFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<Period>map("getPaymentFrequency", loanFloatingRateOption -> loanFloatingRateOption.getPaymentFrequency()).get();
		}
		final MapperS<LegacyFloatingRateOption> legacyFloatingRateOption = MapperS.of(abstractFacilityChoice).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLegacyFloatingRateOption());
		if (exists(legacyFloatingRateOption).getOrDefault(false)) {
			return legacyFloatingRateOption.<Period>map("getPaymentFrequency", _legacyFloatingRateOption -> _legacyFloatingRateOption.getPaymentFrequency()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(abstractFacilityChoice).<LcOption>map("getLcOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<Period>map("getPaymentFrequency", _lcOption -> _lcOption.getPaymentFrequency()).get();
		}
		return null;
	}
	
	public ZonedDateTime chooseStartDate(AbstractFacilityChoice abstractFacilityChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(abstractFacilityChoice).<FixedRateOption>map("getFixedRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<ZonedDateTime>map("getStartDate", _fixedRateOption -> _fixedRateOption.getStartDate()).get();
		}
		final MapperS<LoanFloatingRateOption> floatingRateOption = MapperS.of(abstractFacilityChoice).<LoanFloatingRateOption>map("getFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<ZonedDateTime>map("getStartDate", loanFloatingRateOption -> loanFloatingRateOption.getStartDate()).get();
		}
		final MapperS<LegacyFloatingRateOption> legacyFloatingRateOption = MapperS.of(abstractFacilityChoice).<LegacyFloatingRateOption>map("getLegacyFloatingRateOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLegacyFloatingRateOption());
		if (exists(legacyFloatingRateOption).getOrDefault(false)) {
			return legacyFloatingRateOption.<ZonedDateTime>map("getStartDate", _legacyFloatingRateOption -> _legacyFloatingRateOption.getStartDate()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(abstractFacilityChoice).<LcOption>map("getLcOption", _abstractFacilityChoice -> _abstractFacilityChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<ZonedDateTime>map("getStartDate", _lcOption -> _lcOption.getStartDate()).get();
		}
		return null;
	}
	
}
