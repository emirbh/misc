package drr.standards.iosco.cde.version2.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.cde.version2.LegV2;
import drr.standards.iosco.cde.version2.validation.LegV2TypeFormatValidator;
import drr.standards.iosco.cde.version2.validation.LegV2Validator;
import drr.standards.iosco.cde.version2.validation.exists.LegV2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=LegV2.class)
public class LegV2Meta implements RosettaMetaData<LegV2> {

	@Override
	public List<Validator<? super LegV2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegV2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegV2> validator(ValidatorFactory factory) {
		return factory.<LegV2>create(LegV2Validator.class);
	}

	@Override
	public Validator<? super LegV2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegV2>create(LegV2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegV2> validator() {
		return new LegV2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegV2> typeFormatValidator() {
		return new LegV2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegV2, Set<String>> onlyExistsValidator() {
		return new LegV2OnlyExistsValidator();
	}
}
