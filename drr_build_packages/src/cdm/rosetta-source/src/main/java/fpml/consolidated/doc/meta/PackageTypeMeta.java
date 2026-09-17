package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PackageType;
import fpml.consolidated.doc.validation.PackageTypeTypeFormatValidator;
import fpml.consolidated.doc.validation.PackageTypeValidator;
import fpml.consolidated.doc.validation.exists.PackageTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PackageType.class)
public class PackageTypeMeta implements RosettaMetaData<PackageType> {

	@Override
	public List<Validator<? super PackageType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PackageType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PackageType> validator(ValidatorFactory factory) {
		return factory.<PackageType>create(PackageTypeValidator.class);
	}

	@Override
	public Validator<? super PackageType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PackageType>create(PackageTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PackageType> validator() {
		return new PackageTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PackageType> typeFormatValidator() {
		return new PackageTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PackageType, Set<String>> onlyExistsValidator() {
		return new PackageTypeOnlyExistsValidator();
	}
}
