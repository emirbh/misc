package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.validation.DividendPayoutTypeFormatValidator;
import fpml.consolidated.asset.validation.DividendPayoutValidator;
import fpml.consolidated.asset.validation.datarule.DividendPayoutChoice;
import fpml.consolidated.asset.validation.exists.DividendPayoutOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendPayout.class)
public class DividendPayoutMeta implements RosettaMetaData<DividendPayout> {

	@Override
	public List<Validator<? super DividendPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DividendPayout>create(DividendPayoutChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendPayout> validator(ValidatorFactory factory) {
		return factory.<DividendPayout>create(DividendPayoutValidator.class);
	}

	@Override
	public Validator<? super DividendPayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendPayout>create(DividendPayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendPayout> validator() {
		return new DividendPayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendPayout> typeFormatValidator() {
		return new DividendPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPayout, Set<String>> onlyExistsValidator() {
		return new DividendPayoutOnlyExistsValidator();
	}
}
