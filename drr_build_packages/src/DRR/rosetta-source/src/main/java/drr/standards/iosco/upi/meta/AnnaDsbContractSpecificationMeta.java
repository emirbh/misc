package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbContractSpecification;
import drr.standards.iosco.upi.validation.AnnaDsbContractSpecificationTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbContractSpecificationValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbContractSpecificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbContractSpecification.class)
public class AnnaDsbContractSpecificationMeta implements RosettaMetaData<AnnaDsbContractSpecification> {

	@Override
	public List<Validator<? super AnnaDsbContractSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbContractSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbContractSpecification> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbContractSpecification>create(AnnaDsbContractSpecificationValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbContractSpecification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbContractSpecification>create(AnnaDsbContractSpecificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbContractSpecification> validator() {
		return new AnnaDsbContractSpecificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbContractSpecification> typeFormatValidator() {
		return new AnnaDsbContractSpecificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbContractSpecification, Set<String>> onlyExistsValidator() {
		return new AnnaDsbContractSpecificationOnlyExistsValidator();
	}
}
