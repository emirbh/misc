package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.validation.AdjustableDatesOrRelativeDateOffsetTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableDatesOrRelativeDateOffsetValidator;
import fpml.consolidated.shared.validation.datarule.AdjustableDatesOrRelativeDateOffsetChoice;
import fpml.consolidated.shared.validation.exists.AdjustableDatesOrRelativeDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableDatesOrRelativeDateOffset.class)
public class AdjustableDatesOrRelativeDateOffsetMeta implements RosettaMetaData<AdjustableDatesOrRelativeDateOffset> {

	@Override
	public List<Validator<? super AdjustableDatesOrRelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableDatesOrRelativeDateOffset>create(AdjustableDatesOrRelativeDateOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDatesOrRelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> validator(ValidatorFactory factory) {
		return factory.<AdjustableDatesOrRelativeDateOffset>create(AdjustableDatesOrRelativeDateOffsetValidator.class);
	}

	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableDatesOrRelativeDateOffset>create(AdjustableDatesOrRelativeDateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> validator() {
		return new AdjustableDatesOrRelativeDateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> typeFormatValidator() {
		return new AdjustableDatesOrRelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDatesOrRelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new AdjustableDatesOrRelativeDateOffsetOnlyExistsValidator();
	}
}
