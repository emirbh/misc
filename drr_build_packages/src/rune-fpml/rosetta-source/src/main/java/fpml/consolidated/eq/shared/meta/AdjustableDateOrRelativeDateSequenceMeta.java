package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import fpml.consolidated.eq.shared.validation.AdjustableDateOrRelativeDateSequenceTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.AdjustableDateOrRelativeDateSequenceValidator;
import fpml.consolidated.eq.shared.validation.datarule.AdjustableDateOrRelativeDateSequenceChoice;
import fpml.consolidated.eq.shared.validation.exists.AdjustableDateOrRelativeDateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableDateOrRelativeDateSequence.class)
public class AdjustableDateOrRelativeDateSequenceMeta implements RosettaMetaData<AdjustableDateOrRelativeDateSequence> {

	@Override
	public List<Validator<? super AdjustableDateOrRelativeDateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableDateOrRelativeDateSequence>create(AdjustableDateOrRelativeDateSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDateOrRelativeDateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> validator(ValidatorFactory factory) {
		return factory.<AdjustableDateOrRelativeDateSequence>create(AdjustableDateOrRelativeDateSequenceValidator.class);
	}

	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableDateOrRelativeDateSequence>create(AdjustableDateOrRelativeDateSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> validator() {
		return new AdjustableDateOrRelativeDateSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> typeFormatValidator() {
		return new AdjustableDateOrRelativeDateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDateOrRelativeDateSequence, Set<String>> onlyExistsValidator() {
		return new AdjustableDateOrRelativeDateSequenceOnlyExistsValidator();
	}
}
