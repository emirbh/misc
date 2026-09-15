package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerType;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingIssuerTypeTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingIssuerTypeValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlyingIssuerTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlyingIssuerType.class)
public class AnnaDsbUnderlyingIssuerTypeMeta implements RosettaMetaData<AnnaDsbUnderlyingIssuerType> {

	@Override
	public List<Validator<? super AnnaDsbUnderlyingIssuerType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlyingIssuerType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlyingIssuerType> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingIssuerType>create(AnnaDsbUnderlyingIssuerTypeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlyingIssuerType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingIssuerType>create(AnnaDsbUnderlyingIssuerTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingIssuerType> validator() {
		return new AnnaDsbUnderlyingIssuerTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingIssuerType> typeFormatValidator() {
		return new AnnaDsbUnderlyingIssuerTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlyingIssuerType, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlyingIssuerTypeOnlyExistsValidator();
	}
}
