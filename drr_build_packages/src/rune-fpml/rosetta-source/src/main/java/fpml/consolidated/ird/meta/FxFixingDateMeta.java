package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FxFixingDate;
import fpml.consolidated.ird.validation.FxFixingDateTypeFormatValidator;
import fpml.consolidated.ird.validation.FxFixingDateValidator;
import fpml.consolidated.ird.validation.datarule.FxFixingDateChoice0;
import fpml.consolidated.ird.validation.datarule.FxFixingDateChoice1;
import fpml.consolidated.ird.validation.exists.FxFixingDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFixingDate.class)
public class FxFixingDateMeta implements RosettaMetaData<FxFixingDate> {

	@Override
	public List<Validator<? super FxFixingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxFixingDate>create(FxFixingDateChoice0.class),
			factory.<FxFixingDate>create(FxFixingDateChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingDate> validator(ValidatorFactory factory) {
		return factory.<FxFixingDate>create(FxFixingDateValidator.class);
	}

	@Override
	public Validator<? super FxFixingDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFixingDate>create(FxFixingDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingDate> validator() {
		return new FxFixingDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingDate> typeFormatValidator() {
		return new FxFixingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingDate, Set<String>> onlyExistsValidator() {
		return new FxFixingDateOnlyExistsValidator();
	}
}
