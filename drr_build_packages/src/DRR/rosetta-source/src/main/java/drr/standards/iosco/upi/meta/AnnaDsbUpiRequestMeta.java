package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import drr.standards.iosco.upi.validation.AnnaDsbUpiRequestTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUpiRequestValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUpiRequestOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUpiRequest.class)
public class AnnaDsbUpiRequestMeta implements RosettaMetaData<AnnaDsbUpiRequest> {

	@Override
	public List<Validator<? super AnnaDsbUpiRequest>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUpiRequest, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUpiRequest> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRequest>create(AnnaDsbUpiRequestValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUpiRequest> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRequest>create(AnnaDsbUpiRequestTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRequest> validator() {
		return new AnnaDsbUpiRequestValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRequest> typeFormatValidator() {
		return new AnnaDsbUpiRequestTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUpiRequest, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUpiRequestOnlyExistsValidator();
	}
}
