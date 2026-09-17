package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.validation.AdjustableDate2TypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableDate2Validator;
import fpml.consolidated.shared.validation.datarule.AdjustableDate2Choice;
import fpml.consolidated.shared.validation.exists.AdjustableDate2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableDate2.class)
public class AdjustableDate2Meta implements RosettaMetaData<AdjustableDate2> {

	@Override
	public List<Validator<? super AdjustableDate2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableDate2>create(AdjustableDate2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDate2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDate2> validator(ValidatorFactory factory) {
		return factory.<AdjustableDate2>create(AdjustableDate2Validator.class);
	}

	@Override
	public Validator<? super AdjustableDate2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableDate2>create(AdjustableDate2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDate2> validator() {
		return new AdjustableDate2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDate2> typeFormatValidator() {
		return new AdjustableDate2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDate2, Set<String>> onlyExistsValidator() {
		return new AdjustableDate2OnlyExistsValidator();
	}
}
