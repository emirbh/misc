package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.validation.MutuallyAgreedClearinghouseTypeFormatValidator;
import fpml.consolidated.shared.validation.MutuallyAgreedClearinghouseValidator;
import fpml.consolidated.shared.validation.datarule.MutuallyAgreedClearinghouseChoice;
import fpml.consolidated.shared.validation.exists.MutuallyAgreedClearinghouseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MutuallyAgreedClearinghouse.class)
public class MutuallyAgreedClearinghouseMeta implements RosettaMetaData<MutuallyAgreedClearinghouse> {

	@Override
	public List<Validator<? super MutuallyAgreedClearinghouse>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MutuallyAgreedClearinghouse>create(MutuallyAgreedClearinghouseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MutuallyAgreedClearinghouse, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MutuallyAgreedClearinghouse> validator(ValidatorFactory factory) {
		return factory.<MutuallyAgreedClearinghouse>create(MutuallyAgreedClearinghouseValidator.class);
	}

	@Override
	public Validator<? super MutuallyAgreedClearinghouse> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MutuallyAgreedClearinghouse>create(MutuallyAgreedClearinghouseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MutuallyAgreedClearinghouse> validator() {
		return new MutuallyAgreedClearinghouseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MutuallyAgreedClearinghouse> typeFormatValidator() {
		return new MutuallyAgreedClearinghouseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MutuallyAgreedClearinghouse, Set<String>> onlyExistsValidator() {
		return new MutuallyAgreedClearinghouseOnlyExistsValidator();
	}
}
