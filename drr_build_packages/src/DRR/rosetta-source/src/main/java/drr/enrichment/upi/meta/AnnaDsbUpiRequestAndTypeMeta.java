package drr.enrichment.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.enrichment.upi.validation.AnnaDsbUpiRequestAndTypeTypeFormatValidator;
import drr.enrichment.upi.validation.AnnaDsbUpiRequestAndTypeValidator;
import drr.enrichment.upi.validation.exists.AnnaDsbUpiRequestAndTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUpiRequestAndType.class)
public class AnnaDsbUpiRequestAndTypeMeta implements RosettaMetaData<AnnaDsbUpiRequestAndType> {

	@Override
	public List<Validator<? super AnnaDsbUpiRequestAndType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUpiRequestAndType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUpiRequestAndType> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRequestAndType>create(AnnaDsbUpiRequestAndTypeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUpiRequestAndType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRequestAndType>create(AnnaDsbUpiRequestAndTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRequestAndType> validator() {
		return new AnnaDsbUpiRequestAndTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRequestAndType> typeFormatValidator() {
		return new AnnaDsbUpiRequestAndTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUpiRequestAndType, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUpiRequestAndTypeOnlyExistsValidator();
	}
}
