package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbRateDetail;
import drr.standards.iosco.upi.validation.AnnaDsbRateDetailTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbRateDetailValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbRateDetailOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbRateDetail.class)
public class AnnaDsbRateDetailMeta implements RosettaMetaData<AnnaDsbRateDetail> {

	@Override
	public List<Validator<? super AnnaDsbRateDetail>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbRateDetail, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbRateDetail> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbRateDetail>create(AnnaDsbRateDetailValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbRateDetail> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbRateDetail>create(AnnaDsbRateDetailTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRateDetail> validator() {
		return new AnnaDsbRateDetailValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRateDetail> typeFormatValidator() {
		return new AnnaDsbRateDetailTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbRateDetail, Set<String>> onlyExistsValidator() {
		return new AnnaDsbRateDetailOnlyExistsValidator();
	}
}
