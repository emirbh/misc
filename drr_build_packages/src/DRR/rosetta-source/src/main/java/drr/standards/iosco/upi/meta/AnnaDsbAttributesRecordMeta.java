package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.validation.AnnaDsbAttributesRecordTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbAttributesRecordValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbAttributesRecordOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbAttributesRecord.class)
public class AnnaDsbAttributesRecordMeta implements RosettaMetaData<AnnaDsbAttributesRecord> {

	@Override
	public List<Validator<? super AnnaDsbAttributesRecord>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbAttributesRecord, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbAttributesRecord> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbAttributesRecord>create(AnnaDsbAttributesRecordValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbAttributesRecord> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbAttributesRecord>create(AnnaDsbAttributesRecordTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAttributesRecord> validator() {
		return new AnnaDsbAttributesRecordValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAttributesRecord> typeFormatValidator() {
		return new AnnaDsbAttributesRecordTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbAttributesRecord, Set<String>> onlyExistsValidator() {
		return new AnnaDsbAttributesRecordOnlyExistsValidator();
	}
}
