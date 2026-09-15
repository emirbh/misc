package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.validation.OffsetTypeFormatValidator;
import fpml.consolidated.shared.validation.OffsetValidator;
import fpml.consolidated.shared.validation.exists.OffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Offset.class)
public class OffsetMeta implements RosettaMetaData<Offset> {

	@Override
	public List<Validator<? super Offset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Offset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Offset> validator(ValidatorFactory factory) {
		return factory.<Offset>create(OffsetValidator.class);
	}

	@Override
	public Validator<? super Offset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Offset>create(OffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Offset> validator() {
		return new OffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Offset> typeFormatValidator() {
		return new OffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Offset, Set<String>> onlyExistsValidator() {
		return new OffsetOnlyExistsValidator();
	}
}
