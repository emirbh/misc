package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.validation.AdjustedRelativeDateOffsetTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustedRelativeDateOffsetValidator;
import fpml.consolidated.shared.validation.datarule.RelativeDateOffsetChoice;
import fpml.consolidated.shared.validation.exists.AdjustedRelativeDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustedRelativeDateOffset.class)
public class AdjustedRelativeDateOffsetMeta implements RosettaMetaData<AdjustedRelativeDateOffset> {

	@Override
	public List<Validator<? super AdjustedRelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RelativeDateOffset>create(RelativeDateOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustedRelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustedRelativeDateOffset> validator(ValidatorFactory factory) {
		return factory.<AdjustedRelativeDateOffset>create(AdjustedRelativeDateOffsetValidator.class);
	}

	@Override
	public Validator<? super AdjustedRelativeDateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustedRelativeDateOffset>create(AdjustedRelativeDateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustedRelativeDateOffset> validator() {
		return new AdjustedRelativeDateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustedRelativeDateOffset> typeFormatValidator() {
		return new AdjustedRelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustedRelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new AdjustedRelativeDateOffsetOnlyExistsValidator();
	}
}
