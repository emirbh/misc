package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ManifestType;
import fpml.consolidated.validation.ManifestTypeTypeFormatValidator;
import fpml.consolidated.validation.ManifestTypeValidator;
import fpml.consolidated.validation.exists.ManifestTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ManifestType.class)
public class ManifestTypeMeta implements RosettaMetaData<ManifestType> {

	@Override
	public List<Validator<? super ManifestType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ManifestType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ManifestType> validator(ValidatorFactory factory) {
		return factory.<ManifestType>create(ManifestTypeValidator.class);
	}

	@Override
	public Validator<? super ManifestType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ManifestType>create(ManifestTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ManifestType> validator() {
		return new ManifestTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ManifestType> typeFormatValidator() {
		return new ManifestTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ManifestType, Set<String>> onlyExistsValidator() {
		return new ManifestTypeOnlyExistsValidator();
	}
}
