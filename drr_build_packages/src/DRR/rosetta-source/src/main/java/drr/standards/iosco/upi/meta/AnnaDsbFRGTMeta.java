package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import drr.standards.iosco.upi.validation.AnnaDsbFRGTTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbFRGTValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbFRGTOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbFRGT.class)
public class AnnaDsbFRGTMeta implements RosettaMetaData<AnnaDsbFRGT> {

	@Override
	public List<Validator<? super AnnaDsbFRGT>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbFRGT, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbFRGT> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbFRGT>create(AnnaDsbFRGTValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbFRGT> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbFRGT>create(AnnaDsbFRGTTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbFRGT> validator() {
		return new AnnaDsbFRGTValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbFRGT> typeFormatValidator() {
		return new AnnaDsbFRGTTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbFRGT, Set<String>> onlyExistsValidator() {
		return new AnnaDsbFRGTOnlyExistsValidator();
	}
}
