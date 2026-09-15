package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CompressionType;
import fpml.consolidated.business.events.validation.CompressionTypeTypeFormatValidator;
import fpml.consolidated.business.events.validation.CompressionTypeValidator;
import fpml.consolidated.business.events.validation.exists.CompressionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CompressionType.class)
public class CompressionTypeMeta implements RosettaMetaData<CompressionType> {

	@Override
	public List<Validator<? super CompressionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompressionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CompressionType> validator(ValidatorFactory factory) {
		return factory.<CompressionType>create(CompressionTypeValidator.class);
	}

	@Override
	public Validator<? super CompressionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CompressionType>create(CompressionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CompressionType> validator() {
		return new CompressionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CompressionType> typeFormatValidator() {
		return new CompressionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionType, Set<String>> onlyExistsValidator() {
		return new CompressionTypeOnlyExistsValidator();
	}
}
