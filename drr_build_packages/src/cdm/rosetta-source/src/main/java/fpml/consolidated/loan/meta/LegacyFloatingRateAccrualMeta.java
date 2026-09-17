package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyFloatingRateAccrual;
import fpml.consolidated.loan.validation.LegacyFloatingRateAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyFloatingRateAccrualValidator;
import fpml.consolidated.loan.validation.exists.LegacyFloatingRateAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyFloatingRateAccrual.class)
public class LegacyFloatingRateAccrualMeta implements RosettaMetaData<LegacyFloatingRateAccrual> {

	@Override
	public List<Validator<? super LegacyFloatingRateAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyFloatingRateAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyFloatingRateAccrual> validator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateAccrual>create(LegacyFloatingRateAccrualValidator.class);
	}

	@Override
	public Validator<? super LegacyFloatingRateAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateAccrual>create(LegacyFloatingRateAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateAccrual> validator() {
		return new LegacyFloatingRateAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateAccrual> typeFormatValidator() {
		return new LegacyFloatingRateAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyFloatingRateAccrual, Set<String>> onlyExistsValidator() {
		return new LegacyFloatingRateAccrualOnlyExistsValidator();
	}
}
