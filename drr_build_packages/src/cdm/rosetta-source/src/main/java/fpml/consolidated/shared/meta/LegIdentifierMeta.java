package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.validation.LegIdentifierTypeFormatValidator;
import fpml.consolidated.shared.validation.LegIdentifierValidator;
import fpml.consolidated.shared.validation.exists.LegIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegIdentifier.class)
public class LegIdentifierMeta implements RosettaMetaData<LegIdentifier> {

	@Override
	public List<Validator<? super LegIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegIdentifier> validator(ValidatorFactory factory) {
		return factory.<LegIdentifier>create(LegIdentifierValidator.class);
	}

	@Override
	public Validator<? super LegIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegIdentifier>create(LegIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegIdentifier> validator() {
		return new LegIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegIdentifier> typeFormatValidator() {
		return new LegIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegIdentifier, Set<String>> onlyExistsValidator() {
		return new LegIdentifierOnlyExistsValidator();
	}
}
