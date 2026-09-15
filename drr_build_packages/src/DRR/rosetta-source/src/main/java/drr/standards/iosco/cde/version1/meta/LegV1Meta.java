package drr.standards.iosco.cde.version1.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iosco.cde.version1.validation.LegV1TypeFormatValidator;
import drr.standards.iosco.cde.version1.validation.LegV1Validator;
import drr.standards.iosco.cde.version1.validation.exists.LegV1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=LegV1.class)
public class LegV1Meta implements RosettaMetaData<LegV1> {

	@Override
	public List<Validator<? super LegV1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegV1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegV1> validator(ValidatorFactory factory) {
		return factory.<LegV1>create(LegV1Validator.class);
	}

	@Override
	public Validator<? super LegV1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegV1>create(LegV1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegV1> validator() {
		return new LegV1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegV1> typeFormatValidator() {
		return new LegV1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegV1, Set<String>> onlyExistsValidator() {
		return new LegV1OnlyExistsValidator();
	}
}
