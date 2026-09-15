package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.LegId;
import fpml.consolidated.shared.validation.LegIdTypeFormatValidator;
import fpml.consolidated.shared.validation.LegIdValidator;
import fpml.consolidated.shared.validation.exists.LegIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegId.class)
public class LegIdMeta implements RosettaMetaData<LegId> {

	@Override
	public List<Validator<? super LegId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegId> validator(ValidatorFactory factory) {
		return factory.<LegId>create(LegIdValidator.class);
	}

	@Override
	public Validator<? super LegId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegId>create(LegIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegId> validator() {
		return new LegIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegId> typeFormatValidator() {
		return new LegIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegId, Set<String>> onlyExistsValidator() {
		return new LegIdOnlyExistsValidator();
	}
}
