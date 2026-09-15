package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.option.shared.validation.PremiumTypeFormatValidator;
import fpml.consolidated.option.shared.validation.PremiumValidator;
import fpml.consolidated.option.shared.validation.exists.PremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Premium.class)
public class PremiumMeta implements RosettaMetaData<Premium> {

	@Override
	public List<Validator<? super Premium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Premium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Premium> validator(ValidatorFactory factory) {
		return factory.<Premium>create(PremiumValidator.class);
	}

	@Override
	public Validator<? super Premium> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Premium>create(PremiumTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Premium> validator() {
		return new PremiumValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Premium> typeFormatValidator() {
		return new PremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Premium, Set<String>> onlyExistsValidator() {
		return new PremiumOnlyExistsValidator();
	}
}
