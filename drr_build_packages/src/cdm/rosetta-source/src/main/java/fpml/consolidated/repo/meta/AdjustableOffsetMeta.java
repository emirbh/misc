package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.validation.AdjustableOffsetTypeFormatValidator;
import fpml.consolidated.repo.validation.AdjustableOffsetValidator;
import fpml.consolidated.repo.validation.datarule.AdjustableOffsetChoice;
import fpml.consolidated.repo.validation.exists.AdjustableOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableOffset.class)
public class AdjustableOffsetMeta implements RosettaMetaData<AdjustableOffset> {

	@Override
	public List<Validator<? super AdjustableOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableOffset>create(AdjustableOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableOffset> validator(ValidatorFactory factory) {
		return factory.<AdjustableOffset>create(AdjustableOffsetValidator.class);
	}

	@Override
	public Validator<? super AdjustableOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableOffset>create(AdjustableOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOffset> validator() {
		return new AdjustableOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOffset> typeFormatValidator() {
		return new AdjustableOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOffset, Set<String>> onlyExistsValidator() {
		return new AdjustableOffsetOnlyExistsValidator();
	}
}
