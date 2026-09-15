package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCDSSingleName;
import drr.standards.iosco.upi.validation.AnnaDsbCDSSingleNameTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbCDSSingleNameValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbCDSSingleNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbCDSSingleName.class)
public class AnnaDsbCDSSingleNameMeta implements RosettaMetaData<AnnaDsbCDSSingleName> {

	@Override
	public List<Validator<? super AnnaDsbCDSSingleName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbCDSSingleName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbCDSSingleName> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbCDSSingleName>create(AnnaDsbCDSSingleNameValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbCDSSingleName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbCDSSingleName>create(AnnaDsbCDSSingleNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCDSSingleName> validator() {
		return new AnnaDsbCDSSingleNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCDSSingleName> typeFormatValidator() {
		return new AnnaDsbCDSSingleNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbCDSSingleName, Set<String>> onlyExistsValidator() {
		return new AnnaDsbCDSSingleNameOnlyExistsValidator();
	}
}
