package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import drr.standards.iosco.upi.validation.AnnaDsbSingleNameTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbSingleNameValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbSingleNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbSingleName.class)
public class AnnaDsbSingleNameMeta implements RosettaMetaData<AnnaDsbSingleName> {

	@Override
	public List<Validator<? super AnnaDsbSingleName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbSingleName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbSingleName> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbSingleName>create(AnnaDsbSingleNameValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbSingleName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbSingleName>create(AnnaDsbSingleNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbSingleName> validator() {
		return new AnnaDsbSingleNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbSingleName> typeFormatValidator() {
		return new AnnaDsbSingleNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbSingleName, Set<String>> onlyExistsValidator() {
		return new AnnaDsbSingleNameOnlyExistsValidator();
	}
}
