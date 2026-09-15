package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.validation.AnnaDsbUpiRecordTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUpiRecordValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUpiRecordOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUpiRecord.class)
public class AnnaDsbUpiRecordMeta implements RosettaMetaData<AnnaDsbUpiRecord> {

	@Override
	public List<Validator<? super AnnaDsbUpiRecord>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUpiRecord, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUpiRecord> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRecord>create(AnnaDsbUpiRecordValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUpiRecord> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUpiRecord>create(AnnaDsbUpiRecordTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRecord> validator() {
		return new AnnaDsbUpiRecordValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUpiRecord> typeFormatValidator() {
		return new AnnaDsbUpiRecordTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUpiRecord, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUpiRecordOnlyExistsValidator();
	}
}
